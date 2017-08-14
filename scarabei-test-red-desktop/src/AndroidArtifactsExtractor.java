import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.err.Err;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FileInputStream;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.names.ID;
import com.jfixby.scarabei.api.names.Names;
import com.jfixby.scarabei.api.sys.Sys;
import com.jfixby.scarabei.api.util.Utils;
import com.jfixby.scarabei.api.util.path.RelativePath;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class AndroidArtifactsExtractor {

	private static final boolean DRY_RUN = false;
	private static final boolean ACTUALLY_EXECUTE = !DRY_RUN;

	static class Arguments {

		public File artifactFolder;
		public File output;
		public ID artifactID;
		public File subModuleFolder;
		public ID moduleID;
		public File versionFolder;
		public ID moduleVersion;
		public List<String> projectNames = Collections.newList();
		public boolean exit;
		public boolean dryRun;

	}

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();
		final File gradleArtifacts = LocalFileSystem.newFile("D:\\tmp\\shit");
		final File output = LocalFileSystem.newFile("D:\\[DEV]\\[GIT-3]\\AndroidArtifacts");
		final FilesList artifactsList = gradleArtifacts.listSubFolders();
// L.d("artifactsList", artifactsList);
		final Arguments arg = new Arguments();
		arg.output = output;
		arg.dryRun = !true;
		for (final File f : artifactsList) {
			arg.artifactFolder = f;
			extractArtifact(arg);
			if (arg.exit) {
				break;
			}
		}

		final File settingsFile = output.child("settings.gradle");
		final StringBuilder builde = new StringBuilder();
		for (final String pj : arg.projectNames) {
			builde.append("include '" + pj + "'");
			builde.append("\r\n");
			writeBuildGradleFile(output, pj);
			writeGitIgnore(output, pj);
		}
		L.d("writing", settingsFile);
		settingsFile.writeString(builde.toString());

		writeBuildGradleRootFile(output);
		L.d("DONE");
	}

	private static void writeGitIgnore (final File output, final String pj) throws IOException {
		final File projectFolder = output.child(pj);
		final File gitignore = projectFolder.child(".gitignore");
		L.d("writing", gitignore);
		gitignore.writeString("/bin/");
	}

	private static void writeBuildGradleFile (final File output, final String pj) throws IOException {
		final File projectFolder = output.child(pj);
		final File gradle = projectFolder.child("build.gradle");
		L.d("writing", gradle);
		gradle.writeString(
			"dependencies {\r\n" + "      compile group: 'com.google.android', name: 'android', version: '4.1.1.4'\r\n" + "}");
	}

	private static void extractArtifact (final Arguments arg) throws IOException {
		final File f = arg.artifactFolder;
		final ID artifactID = Names.newID(f.getName());
		arg.artifactID = artifactID;
// L.d("extracting", artifactID);

		final FilesList modules = f.listDirectChildren();

		for (final File s : modules) {
			arg.subModuleFolder = s;
			extractModule(arg);
			if (arg.exit) {
				break;
			}
		}

	}

	private static void extractModule (final Arguments arg) throws IOException {
		final File sub = arg.subModuleFolder;
		final ID artifactID = arg.artifactID;

		arg.moduleID = artifactID.child(sub.getName());
		L.d("extracting", arg.moduleID);
		final FilesList versions = sub.listDirectChildren();
		for (final File v : versions) {
			arg.versionFolder = v;
			extractVersion(arg);
			if (arg.exit) {
				break;
			}
		}

	}

	private static void extractVersion (final Arguments arg) throws IOException {
		final File v = arg.versionFolder;
		final File output = arg.output;
		final ID moduleID = arg.moduleID;

		arg.moduleVersion = moduleID.child(v.getName());
		L.d("          ", arg.moduleVersion);

		final File jarOutput = output.child(arg.moduleVersion.toString());

		arg.projectNames.add(jarOutput.getName());
		if (arg.dryRun) {
			return;
		}

		final File jars = v.child("jars");
		final FilesList jarsList = jars.listDirectChildren();
		if (jarsList.size() != 1 || !jarsList.getLast().getName().equals("classes.jar")) {
			L.d("             ", jarsList);
			Sys.exit();
		}
		final File jar = jarsList.getLast();

		jarOutput.makeFolder();
		jarOutput.clearFolder();

		final File javaDecompiler = LocalFileSystem.ApplicationHome().child("java-decompiler.jar");

		jar.getFileSystem().copyFileToFolder(jar, javaDecompiler.parent());
		final File jarCopy = javaDecompiler.parent().child(jar.getName());
		if (!jarCopy.exists()) {
			L.d("not found", jarCopy);
			Sys.exit();
		}
		final String copyHash = jarCopy.calculateHash().getMD5HashHexString();
		final String originalHash = jar.calculateHash().getMD5HashHexString();
		if (!copyHash.equals(originalHash)) {
			Err.reportError("mismatch");
		}

// java -cp java-decompiler.jar org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler classes.jar d:/tmp/
		final String command = "java -cp java-decompiler.jar org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler classes.jar "
			+ output.toJavaFile().getAbsolutePath();
// execute(command, DRY_RUN);
		L.d("jarCopy.size", jarCopy.getSize() / 1024f / 1024f + " Mb");
		execute(command, ACTUALLY_EXECUTE);

		final File src = jarOutput.child("src");
		src.makeFolder();
		final File decompiledJar = output.child("classes.jar");
		L.d("decompiledJar", decompiledJar);
		unZipIt(decompiledJar, src);
		decompiledJar.delete();
// arg.exit = true;
	}

	public static void unZipIt (final File zipFile, final File outputFolder) throws IOException {
		L.d("unzip", zipFile);
		final byte[] buffer = new byte[1024 * 1000];

		outputFolder.makeFolder();

		// get the zip file content
		final FileInputStream is = zipFile.newInputStream();
		is.open();
		final InputStream fis = is.toJavaInputStream();
		final ZipInputStream zis = new ZipInputStream(fis);
		// get the zipped file list entry
		ZipEntry ze = zis.getNextEntry();

		while (ze != null) {

			final String fileName = ze.getName();
			final RelativePath relative = Utils.newRelativePath(fileName);
			L.d("relative", relative);
// Sys.exit();
			final File outputFile = outputFolder.proceed(relative);
			L.d("        ", outputFile);

			if (ze.isDirectory()) {
				outputFile.makeFolder();

			} else {
				final ByteArrayOutputStream os = new ByteArrayOutputStream();
				int len;
				while ((len = zis.read(buffer)) > 0) {
					os.write(buffer, 0, len);
				}
				os.close();
				outputFile.writeBytes(os.toByteArray());
			}
			ze = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();
		is.close();

	}

	private static void execute (final String cmd, final boolean dryRun) throws IOException {
		L.d("running command", cmd);
		if (dryRun == DRY_RUN) {
			return;
		}
// Sys.exit();
		final ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
		builder.redirectErrorStream(true);
		final Process p = builder.start();
		final BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}
	}

	private static void writeBuildGradleRootFile (final File output) throws IOException {
		final File gradle = output.child("build.gradle");
		L.d("writing", gradle);
		gradle.writeString("buildscript {\r\n" + "    repositories {\r\n" + "        jcenter()\r\n" + "    }\r\n"
			+ "    dependencies {\r\n" + "        classpath 'com.android.tools.build:gradle:2.2.3'\r\n"
			+ "        classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'\r\n" + "    }\r\n" + "}\r\n" + "\r\n"
			+ "\r\n" + "allprojects {\r\n" + "\r\n" + "repositories {\r\n" + "          	 maven { url 'https://jitpack.io' }\r\n"
			+ "        	 mavenCentral()\r\n" + "}\r\n" + "    \r\n" + "apply plugin: \"java\"\r\n" + "apply plugin: \"maven\"\r\n"
			+ "\r\n" + "\r\n" + "sourceCompatibility = 1.6\r\n" + "\r\n"
			+ "[compileJava, compileTestJava]*.options*.encoding = 'UTF-8'\r\n" + "\r\n" + "sourceSets {\r\n" + "    main {\r\n"
			+ "        java {\r\n" + "            srcDirs = ['src/']\r\n" + "        }\r\n" + "        resources {\r\n"
			+ "            \r\n" + "        }\r\n" + "    }\r\n" + "}\r\n" + "\r\n" + "\r\n"
			+ "task sourcesJar(type: Jar, dependsOn: classes) {\r\n" + "    classifier = 'sources'\r\n"
			+ "    from sourceSets.main.allSource\r\n" + "}\r\n" + "\r\n" + "artifacts {\r\n" + "    archives sourcesJar\r\n"
			+ "}\r\n" + "\r\n" + "\r\n" + "}\r\n" + "\r\n" + "\r\n" + "");
	}
}
