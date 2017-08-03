
package com.jfixby.scarabei.red.desktop.test;

import java.io.IOException;

import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class GenFile {

	public static void main (String[] args) throws IOException {
		ScarabeiDesktop.deploy();
		File test_file = LocalFileSystem.ApplicationHome().child("testFile.101M");
		test_file.writeBytes(new byte[1024 * 1024 * 101]);

	}
}
