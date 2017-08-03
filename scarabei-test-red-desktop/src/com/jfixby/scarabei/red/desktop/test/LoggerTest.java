
package com.jfixby.scarabei.red.desktop.test;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.collections.Map;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class LoggerTest {

	public static void main (final String[] args) {
		ScarabeiDesktop.deploy();
// SystemSettings.setExecutionMode(ExecutionMode.PUBLIC_RELEASE);
		L.d("hello");
		L.d("hello", "xxx");
		L.e("hello");
		L.e("hello", "xxx");

		final List<String> list = Collections.newList();
		list.add("A");
		list.add("B");
		list.add("C");
		L.d("list", list);

		final Map<String, String> map = Collections.newMap();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");

		L.d("map", map);

		Again.again();
		Again.roll();
	}

	public static class Again {

		static void again () {
			L.d("hello");
			L.d("hello", "xxx");
			L.e("hello");
			L.e("hello", "xxx");

			final List<String> list = Collections.newList();
			list.add("A");
			list.add("B");
			list.add("C");
			L.d("list", list);

			final Map<String, String> map = Collections.newMap();
			map.put("A", "1");
			map.put("B", "2");
			map.put("C", "3");

			L.d("map", map);
		}

		public static void roll () {
			again();
		}

	}
}
