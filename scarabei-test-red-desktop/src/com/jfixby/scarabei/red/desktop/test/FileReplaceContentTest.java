
package com.jfixby.scarabei.red.desktop.test;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.sys.Sys;

public class FileReplaceContentTest {

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();
// final File inputFolder = LocalFileSystem.newFile("I");
		final File outputFolder = LocalFileSystem.newFile("O");

// final FileSystem fs = inputFolder.getFileSystem();
// fs.copyFolderContentsToFolder(inputFolder, outputFolder);

		final FilesList all = outputFolder.listAllChildren();
		final List<File> filesToFix = Collections.newList();
		for (final File f : all) {
			final String string = f.readToString();
			if (string.contains("/home/reyer")) {
				filesToFix.add(f);
			}
// string = string.replaceAll("/home/reyer/", "home/j/");
// f.writeString(string);
		}

		filesToFix.print("filesToFix");
		Sys.exit();
	}
}
