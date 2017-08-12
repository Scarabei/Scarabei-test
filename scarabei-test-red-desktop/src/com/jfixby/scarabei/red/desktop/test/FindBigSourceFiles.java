
package com.jfixby.scarabei.red.desktop.test;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.strings.Strings;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class FindBigSourceFiles {

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.DEMO);

		final File project = LocalFileSystem.newFile("D:\\DaaNuu\\van_mobile_app");
// final File project = LocalFileSystem.newFile("D:\\DaaNuu\\van_shared");
		final FilesList dartFiles = project.listAllChildren(file -> file.extensionIs("dart"));
// L.d("", dartFiles);
		final List<File> longFiles = Collections.newList();
		for (final File f : dartFiles) {
			final List<String> lines = Strings.split(f.readToString(), "\n");
			if (lines.size() > 150) {
// L.d("" + f.getName(), lines);

				longFiles.add(f);
			}

		}
		longFiles.sort( (x, y) -> {
			List<String> X = null;
			try {
				X = Strings.split(x.readToString(), "\n");
			} catch (final IOException e) {
				e.printStackTrace();
			}
			List<String> Y = null;
			try {
				Y = Strings.split(y.readToString(), "\n");
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return -Integer.compare(X.size(), Y.size());
		});
		for (final File f : longFiles) {
			final List<String> lines = Strings.split(f.readToString(), "\n");
			L.d(lines.size() + "", f);
		}

	}
}
