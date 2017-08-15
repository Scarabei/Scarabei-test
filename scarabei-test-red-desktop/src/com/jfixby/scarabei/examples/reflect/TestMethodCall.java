
package com.jfixby.scarabei.examples.reflect;

import java.io.IOException;

import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.red.reflect.CrossLanguageCallAdaptor;

public class TestMethodCall {

	public static void main (final String[] args) throws ReflectiveOperationException {
		ScarabeiDesktop.deploy();
// com.jfixby.scarabei.api.sys.Sys.getSystemInfo();

		final String methodCallString = "{\r\n" + "                     \"value\": {\r\n"
			+ "                       \"methodName\": {\r\n"
			+ "                         \"value\": \"com.jfixby.scarabei.examples.reflect.TestMethodCall.test\",\r\n"
			+ "                         \"type\": \"com.jfixby.scarabei.api.names.ID\"\r\n" + "                       },\r\n"
			+ "                       \"arguments\": {\r\n" + "                         \"value\": [],\r\n"
			+ "                         \"type\": \"List\"\r\n" + "                       }\r\n" + "                     },\r\n"
			+ "                     \"type\": \"MethodCall\"\r\n" + "                   }";
		final JsonString jsonInput = Json.newJsonString(methodCallString);

		final JsonString jsonResult = CrossLanguageCallAdaptor.processCrossLanguageMethodCall(jsonInput);

	}

	public static void test () throws IOException {
		throw new IOException("hello");
	}

}
