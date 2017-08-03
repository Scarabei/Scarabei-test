
package com.jfixby.scarabei.test;

import com.jfixby.scarabei.api.ScarabeiAPIVersion;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class VersionCheck {

	public static void main (final String[] args) {
		ScarabeiDesktop.deploy();
		L.d(ScarabeiAPIVersion.VERSION);

	}

}
