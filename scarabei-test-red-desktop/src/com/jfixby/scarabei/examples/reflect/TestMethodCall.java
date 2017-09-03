
package com.jfixby.scarabei.examples.reflect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.jfixby.scarabei.api.codecs.Codecs;
import com.jfixby.scarabei.api.codecs.io.EncodedObject;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.names.ID;
import com.jfixby.scarabei.api.names.Names;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.red.reflect.CrossLanguageCallAdaptor;

public class TestMethodCall {

	public static void main (final String[] args) throws ReflectiveOperationException {
		ScarabeiDesktop.deploy();
// com.jfixby.scarabei.api.sys.Sys.getSystemInfo();

		final HashMap<ID, Object> mapping = new HashMap<>();
		final HashMap mpp = new HashMap();
		mpp.put("d", new ArrayList());
		mapping.put(Names.newID("k1"), "sdf");
		mapping.put(Names.newID("k2"), mpp);
		mapping.put(Names.newID("k3"), new ArrayList());
		EncodedObject json = Codecs.encode(mapping);
		final JsonString jsonString = Json.serializeToString(json);
// L.d("jsonString", jsonString);
		json = Json.deserializeFromString(EncodedObject.class, jsonString);
		final Map<ID, String> map = Codecs.decode(json);
// L.d("input", mapping);
// L.d("output", map);
// Sys.exit();

		final String methodCallString = "{\r\n" + "   \"value\": {\r\n" + "     \"methodName\": {\r\n"
			+ "       \"value\": \"io.reyer.mobile.api.localdb.LocalDB.readDocuments\",\r\n"
			+ "       \"type\": \"com.jfixby.scarabei.api.names.ID\"\r\n" + "     },\r\n" + "     \"arguments\": {\r\n"
			+ "       \"value\": [\r\n" + "         {\r\n" + "           \"value\": {\r\n" + "             \"argumentName\": {\r\n"
			+ "               \"value\": \"collectionName\",\r\n" + "               \"type\": \"String\"\r\n" + "             },\r\n"
			+ "             \"argumentValue\": {\r\n" + "               \"value\": \"cacheInfo\",\r\n"
			+ "               \"type\": \"String\"\r\n" + "             }\r\n" + "           },\r\n"
			+ "           \"type\": \"MethodCallArgument\"\r\n" + "         },\r\n" + "         {\r\n"
			+ "           \"value\": {\r\n" + "             \"argumentName\": {\r\n" + "               \"value\": \"IDs\",\r\n"
			+ "               \"type\": \"String\"\r\n" + "             },\r\n" + "             \"argumentValue\": {\r\n"
			+ "               \"value\": [\r\n" + "                 {\r\n" + "                   \"value\": \"*\",\r\n"
			+ "                   \"type\": \"String\"\r\n" + "                 }\r\n" + "               ],\r\n"
			+ "               \"type\": \"List\"\r\n" + "             }\r\n" + "           },\r\n"
			+ "           \"type\": \"MethodCallArgument\"\r\n" + "         }\r\n" + "       ],\r\n"
			+ "       \"type\": \"List\"\r\n" + "     }\r\n" + "   },\r\n" + "   \"type\": \"MethodCall\"\r\n" + " }";
		final JsonString jsonInput = Json.newJsonString(methodCallString);
// L.stackTraceToString(e)
		final JsonString jsonResult = CrossLanguageCallAdaptor.processCrossLanguageMethodCall(jsonInput);

		L.d(jsonResult.toString().replaceAll("\n", ""));
		L.d(jsonResult.toString());

	}

	public static Object test () throws IOException {
		throw new IOException("hello");
// return Sys.getSystemInfo();

	}

}
