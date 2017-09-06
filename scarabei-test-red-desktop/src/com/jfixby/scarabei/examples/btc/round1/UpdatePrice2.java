
package com.jfixby.scarabei.examples.btc.round1;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.collections.Map;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.strings.Strings;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class UpdatePrice2 {
	final static String bt = "BTC\r\n" + "BCH\r\n" + "DASH\r\n" + "ETH\r\n" + "ZEC\r\n" + "XMR\r\n" + "LTC\r\n" + "ETC\r\n"
		+ "OMG\r\n" + "EOS\r\n" + "MIOTA\r\n" + "XRP";

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.DEMO);
		final List<String> tags = Strings.split(bt, "\r\n");

		final File inputFile = LocalFileSystem.ApplicationHome().child("btc").child("update.json");
		final String jsonString = inputFile.readToString();
		final java.util.List<java.util.Map> list = Json.deserializeFromString(java.util.List.class, jsonString);
		final Map<String, BTC> btx = Collections.newMap();
		for (final java.util.Map map : list) {
			final JsonString json_i = Json.serializeToString(map);
			final BTC btc = Json.deserializeFromString(BTC.class, json_i);
			btx.put(btc.symbol, btc);
		}
// L.d("btx", btx);
		for (final String t : tags) {
			final BTC val = btx.get(t);
// L.d(t, val.price_eur);
			L.d(t, val);
		}

	}

}
