
package com.jfixby.scarabei.red.desktop.test;

import java.io.IOException;

import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class FixDartImports {

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();

// final File folder = LocalFileSystem.newFile("D:\\ScarabeiDart\\ScarabeiDart");
		final File folder = LocalFileSystem.newFile("D:\\DaaNuu\\van_mobile_app");
		final FilesList dartFiles = folder.listAllChildren(file -> file.extensionIs("dart"));
		dartFiles.print("dartFiles");

		for (final File file : dartFiles) {
			final String data = file.readToString();
			final String result = data.replaceAll("import 'package:scarabei_api/", "import 'package:scarabei/");
			if (!result.equals(data)) {
				L.d("file to fix", file);
			}
// file.writeString(result);
		}

	}

}
