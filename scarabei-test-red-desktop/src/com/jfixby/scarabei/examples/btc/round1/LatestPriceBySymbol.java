
package com.jfixby.scarabei.examples.btc.round1;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.collections.Map;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.strings.Strings;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.examples.btc.coinmarket.Coinmarketcap;
import com.jfixby.scarabei.examples.btc.coinmarket.Entry;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class LatestPriceBySymbol {
	final static String bt = "BTC\r\n" + "BCH\r\n" + "DASH\r\n" + "ETH\r\n" + "ZEC\r\n" + "XMR\r\n" + "LTC\r\n" + "ETC\r\n"
		+ "OMG\r\n" + "EOS\r\n" + "MIOTA\r\n" + "XRP";

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.DEMO);

		final List<String> tags = Strings.split(bt, "\r\n");

		final List<Entry> top = Coinmarketcap.getRanking();
		final Map<String, Entry> btx = Collections.newMap();
		for (final Entry e : top) {
			btx.put(e.symbol, e);
		}
// L.d("btx", btx);
		for (final String t : tags) {
			final Entry val = btx.get(t);
			L.d(val.price_eur);
		}

	}

}
