
package com.jfixby.scarabei.examples.reflect;

import java.io.IOException;

import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.sys.Sys;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.red.reflect.CrossLanguageCallAdaptor;

public class TestMethodCall {

	public static void main (final String[] args) throws ReflectiveOperationException {
		ScarabeiDesktop.deploy();
// com.jfixby.scarabei.api.sys.Sys.getSystemInfo();

		final String methodCallString = "{\r\n" + "   \"value\": {\r\n" + "     \"methodName\": {\r\n"
			+ "       \"value\": \"com.jfixby.scarabei.api.sys.settings.SystemSettings.setStringParameter\",\r\n"
			+ "            \"type\": \"com.jfixby.scarabei.api.names.ID\"\r\n" + "          },\r\n"
			+ "          \"arguments\": {\r\n" + "            \"value\": [\r\n" + "              {\r\n"
			+ "                \"value\": {\r\n" + "                  \"argumentName\": {\r\n"
			+ "                    \"value\": \"com.daanuu.app.api_daanuu_url\",\r\n"
			+ "                    \"type\": \"String\"\r\n" + "                  },\r\n"
			+ "                  \"argumentValue\": {\r\n" + "                    \"value\": \"com.daanuu.app.api_daanuu_url\",\r\n"
			+ "                    \"type\": \"com.jfixby.scarabei.api.names.ID\"\r\n" + "                  }\r\n"
			+ "                },\r\n" + "                \"type\": \"MethodCallArgument\"\r\n" + "              },\r\n"
			+ "              {\r\n" + "                \"value\": {\r\n" + "                  \"argumentName\": {\r\n"
			+ "                    \"value\": \"https://devel-api.daanuu.com\",\r\n" + "                    \"type\": \"String\"\r\n"
			+ "                  },\r\n" + "                  \"argumentValue\": {\r\n"
			+ "                    \"value\": \"https://devel-api.daanuu.com\",\r\n" + "                    \"type\": \"String\"\r\n"
			+ "                                                                                                                    }\r\n"
			+ "                                                                                                                  },\r\n"
			+ "                \"type\": \"MethodCallArgument\"\r\n" + "              }\r\n" + "            ],\r\n"
			+ "            \"type\": \"List\"\r\n" + "          }\r\n" + "        },\r\n" + "        \"type\": \"MethodCall\"\r\n"
			+ "                                                                                                        }";
		final JsonString jsonInput = Json.newJsonString(methodCallString);

		final JsonString jsonResult = CrossLanguageCallAdaptor.processCrossLanguageMethodCall(jsonInput);

		L.d(jsonResult.toString().replaceAll("\n", ""));

	}

	public static Object test () throws IOException {
// throw new IOException("hello");
		return Sys.getSystemInfo();

	}

}
