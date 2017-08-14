import com.jfixby.scarabei.api.codecs.Codecs;
import com.jfixby.scarabei.api.codecs.JavaMethodCall;
import com.jfixby.scarabei.api.codecs.calls.io.CrossLanguageMethodCall;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class DecodeMethodCall {

	public static void main (final String[] args) {
		ScarabeiDesktop.deploy();

// final String test =
// "{\"methodName\":{\"value\":\"com.jfixby.scarabei.red.flutter.plugins.android.sys.SystemSettingsWrapper.listAllSettings\",\"type\":\"com.jfixby.scarabei.api.names.ID\"},\"methodArguments\":{\"value\":[],\"type\":\"List\"}}";
		Json.printPretty(Json.newJsonString(test));
		final CrossLanguageMethodCall map = Json.deserializeFromString(CrossLanguageMethodCall.class, test);
		L.d("map", map);
		final JavaMethodCall call = Codecs.decodeMethodCall(map);
		L.d("call", Json.serializeToString(call));
// final Object methodName = map.get("methodName");

// L.d("methodName", methodName.getClass());

	}

	static String test = "{\r\n" + "                     \"methodName\": {\r\n"
		+ "                       \"value\": \"abc.def.ght\",\r\n"
		+ "                       \"type\": \"com.jfixby.scarabei.api.names.ID\"\r\n" + "                     },\r\n"
		+ "                     \"arguments\": {\r\n" + "                       \"value\": [\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"x\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n" + "                             \"value\": \"1\",\r\n"
		+ "                             \"type\": \"int64\"\r\n" + "                           }\r\n"
		+ "                         },\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"y\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n" + "                             \"value\": \"3\",\r\n"
		+ "                             \"type\": \"int64\"\r\n" + "                           }\r\n"
		+ "                         },\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"z\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n"
		+ "                             \"value\": \"EARLY_DEVELOPMENT\",\r\n"
		+ "                             \"type\": \"com.jfixby.scarabei.api.sys.settings.ExecutionMode\"\r\n"
		+ "                           }\r\n" + "                         },\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"s\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n" + "                             \"value\": false,\r\n"
		+ "                             \"type\": \"Bool\"\r\n" + "                           }\r\n"
		+ "                         },\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"N\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n" + "                             \"value\": \"null\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           }\r\n"
		+ "                         },\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"L\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n" + "                             \"value\": [\r\n"
		+ "                               {\r\n" + "                                 \"value\": \"1\",\r\n"
		+ "                                 \"type\": \"int64\"\r\n" + "                               },\r\n"
		+ "                               {\r\n" + "                                 \"value\": \"2\",\r\n"
		+ "                                 \"type\": \"int64\"\r\n" + "                               },\r\n"
		+ "                               {\r\n" + "                                 \"value\": \"3\",\r\n"
		+ "                                 \"type\": \"int64\"\r\n" + "                               },\r\n"
		+ "                               {\r\n" + "                                 \"value\": \"S\",\r\n"
		+ "                                 \"type\": \"String\"\r\n" + "                               },\r\n"
		+ "                               null\r\n" + "                             ],\r\n"
		+ "                             \"type\": \"List\"\r\n" + "                           }\r\n"
		+ "                         },\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"LL\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n" + "                             \"value\": [\r\n"
		+ "                               {\r\n" + "                                 \"value\": [\r\n"
		+ "                                   {\r\n" + "                                     \"value\": \"a\",\r\n"
		+ "                                     \"type\": \"String\"\r\n" + "                                   },\r\n"
		+ "                                   {\r\n" + "                                     \"value\": \"s\",\r\n"
		+ "                                     \"type\": \"String\"\r\n" + "                                   },\r\n"
		+ "                                   {\r\n" + "                                     \"value\": \"d\",\r\n"
		+ "                                     \"type\": \"String\"\r\n" + "                                   },\r\n"
		+ "                                   null\r\n" + "                                 ],\r\n"
		+ "                                 \"type\": \"List\"\r\n" + "                               },\r\n"
		+ "                               {\r\n" + "                                 \"value\": \"EARLY_DEVELOPMENT\",\r\n"
		+ "                                 \"type\": \"com.jfixby.scarabei.api.sys.settings.ExecutionMode\"\r\n"
		+ "                               },\r\n" + "                               {\r\n"
		+ "                                 \"value\": \"abc.de\",\r\n"
		+ "                                 \"type\": \"com.jfixby.scarabei.api.names.ID\"\r\n"
		+ "                               },\r\n" + "                               {\r\n"
		+ "                                 \"value\": \"S\",\r\n" + "                                 \"type\": \"String\"\r\n"
		+ "                               },\r\n" + "                               null\r\n"
		+ "                             ],\r\n" + "                             \"type\": \"List\"\r\n"
		+ "                           }\r\n" + "                         },\r\n" + "                         {\r\n"
		+ "                           \"argumentName\": {\r\n" + "                             \"value\": \"id\",\r\n"
		+ "                             \"type\": \"String\"\r\n" + "                           },\r\n"
		+ "                           \"argumentValue\": {\r\n" + "                             \"value\": \"abc.def.ghk\",\r\n"
		+ "                             \"type\": \"com.jfixby.scarabei.api.names.ID\"\r\n" + "                           }\r\n"
		+ "                         }\r\n" + "                       ],\r\n" + "                       \"type\": \"List\"\r\n"
		+ "                     }\r\n" + "                   }";

}
