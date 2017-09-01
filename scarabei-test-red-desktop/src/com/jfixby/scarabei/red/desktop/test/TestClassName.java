
package com.jfixby.scarabei.red.desktop.test;

import org.junit.Test;

import com.jfixby.scarabei.api.java.Int;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.reflect.Reflections;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class TestClassName {

	@Test
	public void test () {
		ScarabeiDesktop.deploy();
		final Int[] array = new Int[10];
		L.d("", Reflections.nameOf(array.getClass()));

	}

}
