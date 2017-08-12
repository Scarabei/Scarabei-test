
package com.jfixby.scarabei.red.desktop.test;

import java.io.IOException;

import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.file.LocalFileSystemComponent;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class ListFiles {

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();

		final LocalFileSystemComponent fileSystem = LocalFileSystem.invoke();

// fileSystem.ROOT().child("[SHIT]").listDirectChildren()//
// .print("root" + " direct");
//
// fileSystem.ROOT().child("[SHIT]").listAllChildren()//
// .print("root" + " all");

	}

}
