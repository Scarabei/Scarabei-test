import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;
import com.jfixby.scarabei.red.reflect.CrossLanguageCallAdaptor;

public class TestMethodCall {

	public static void main (final String[] args) throws ReflectiveOperationException {
		ScarabeiDesktop.deploy();

		final String methodCallString = "";
		final JsonString jsonInput = Json.newJsonString(methodCallString);

		final JsonString jsonResult = CrossLanguageCallAdaptor.processCrossLanguageMethodCall(jsonInput);

	}

}
