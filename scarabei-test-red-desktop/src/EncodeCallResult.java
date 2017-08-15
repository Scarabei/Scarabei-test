import java.util.ArrayList;

import com.jfixby.scarabei.api.codecs.Codecs;
import com.jfixby.scarabei.api.codecs.io.EncodedObject;
import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.Map;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.names.Names;
import com.jfixby.scarabei.api.sys.Sys;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.red.reflect.JavaMethodCallResult;

public class EncodeCallResult {

	public static void main (final String[] args) {
		ScarabeiDesktop.deploy();
		final Map<Object, Object> test = Collections.newMap();
		test.putAll(Sys.getSystemInfo());
		test.put("ki", 5);
		test.put("kf", 6f);
		test.put("ks", "asdasd");
		test.put("kID", Names.newID("asdasd.adasd"));
		test.put("Null", null);
		final ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(ExecutionMode.DEMO);
		list.add(null);
		list.add("asd");

		test.put("L", list);
		L.d("info", test);
		final JavaMethodCallResult result = new JavaMethodCallResult();
		result.error = new Exception("");
		result.success = true;
		result.result = Sys.getSystemInfo();
		Codecs.encode(result);

		final EncodedObject encodeed = Codecs.encode(test);
// final EncodedObject encodeed = Codecs.encode(null);
		final JsonString enc = Json.serializeToString(encodeed);
		L.d("encodeed", enc.toString().replaceAll("\n", ""));
// Json.printPretty(Json.newJsonString(test));
// final CrossLanguageMethodCall map = Json.deserializeFromString(CrossLanguageMethodCall.class, test);
// L.d("map", map);
// final JavaMethodCall call = Codecs.decodeMethodCall(map);
// L.d("call", Json.serializeToString(call));

	}
}
