
package com.jfixby.scarabei.red.desktop.test;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.sys.Sys;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class FileReplaceContentTest {

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();
// final File inputFolder = LocalFileSystem.newFile("I");
		final File outputFolder = LocalFileSystem.newFile("D:\\ScarabeiDart\\ScarabeiDart");

// final FileSystem fs = inputFolder.getFileSystem();
// fs.copyFolderContentsToFolder(inputFolder, outputFolder);

		final FilesList all = outputFolder.listAllChildren(file -> {
			final String name = file.getName();
// L.d("name", name);
			final boolean starts = name.startsWith(".git");
			if (starts) {
// L.d("name", name);
			}
			return !file.getAbsoluteFilePath().getRelativePath().steps().contains(".git");

		});
// all.print("all");
// Sys.exit();
		final List<File> filesToFix = Collections.newList();
		for (final File f : all) {
			if (f.getName().contains("reyer")) {
				filesToFix.add(f);
				continue;
			}

			if (f.isFile()) {
				final String string = f.readToString();
				if (string.contains("reyer") || string.contains("Reyer")) {
					filesToFix.add(f);
				}
				continue;
			}

		}

		filesToFix.print("filesToFix");
		Sys.exit();

		for (int i = 0; i < filesToFix.size(); i++) {
			final File f = filesToFix.getElementAt(i);
			final String ame = f.getName();
			if (ame.contains("reyer")) {
				final String new_name = ame.replaceAll("reyer", "red");
				L.d("rename", f);
				L.d("  from", ame);
				L.d("    to", new_name);
// f.rename(new_name);
			}
			if (f.isFile()) {
				String string = f.readToString();
				if (!(string.contains("reyer") || string.contains("Reyer"))) {
					continue;
				}

				string = string.replaceAll("reyer", "red");
				string = string.replaceAll("Reyer", "Red");
				L.d("write", f);
				f.writeString(string);
			}
		}

	}
}
