
package com.jfixby.scarabei.red.desktop.test;

import org.junit.Test;

import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.util.BinaryCode;
import com.jfixby.scarabei.api.util.Utils;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class BitsTest {

	@Test
	public void test () {
		ScarabeiDesktop.deploy();
		for (int i = 0; i < 32 + 0 * 256 * 256; i++) {
			final BinaryCode bitform = Utils.binaryCodeOf(i, 4);
			L.d(i + "", bitform + " vs " + Integer.toBinaryString(i));
		}

	}

}
