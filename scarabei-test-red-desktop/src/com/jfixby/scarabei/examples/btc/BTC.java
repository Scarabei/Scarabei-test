
package com.jfixby.scarabei.examples.btc;

import java.io.IOException;
import java.math.BigDecimal;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class BTC {

	String id;
	String symbol;
	int rank;
	BigDecimal price_usd;
	BigDecimal market_cap_usd;
	BigDecimal price_eur;
	BigDecimal market_cap_eur;

	public String toCSV () {
		return this.rank + "	" + this.id + "	" + this.symbol + "	" + this.price_eur + "	" + this.market_cap_eur;
	}

	@Override
	public String toString () {
		return "BTC [id=" + this.id + ", symbol=" + this.symbol + ", rank=" + this.rank + ", price_usd=" + this.price_usd
			+ ", market_cap_usd=" + this.market_cap_usd + ", price_eur=" + this.price_eur + ", market_cap_eur=" + this.market_cap_eur
			+ "]";
	}

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.DEMO);
		final java.util.List<java.util.Map> list = Json.deserializeFromString(java.util.List.class, json);
		final List<BTC> btx = Collections.newList();
		for (final java.util.Map map : list) {
			final JsonString json_i = Json.serializeToString(map);
// L.d("json_i", json_i);
			final BTC btc = Json.deserializeFromString(BTC.class, json_i);
			btx.add(btc);
			L.d(btc.toCSV());

		}

// L.d("btx", btx);

// final HttpURL url = Http.newURL("https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=100");
// L.d("url", url);
// final HttpCallParams params = Http.newCallParams();
// params.setURL(url);
// params.setMethod(METHOD.GET);
// params.setUseAgent(true);
// final HttpCall call = Http.newCall(params);
// final HttpCallExecutor exe = Http.newCallExecutor();
// final HttpCallProgress result = exe.execute(call);
// final String data = result.readResultAsString("utf-8");
// L.d("data", data);

	}

	public static String json = "[\r\n" + "    {\r\n" + "        \"id\": \"bitcoin\", \r\n" + "        \"name\": \"Bitcoin\", \r\n"
		+ "        \"symbol\": \"BTC\", \r\n" + "        \"rank\": \"1\", \r\n" + "        \"price_usd\": \"4662.41\", \r\n"
		+ "        \"price_btc\": \"1.0\", \r\n" + "        \"24h_volume_usd\": \"2202840000.0\", \r\n"
		+ "        \"market_cap_usd\": \"77120224449.0\", \r\n" + "        \"available_supply\": \"16540850.0\", \r\n"
		+ "        \"total_supply\": \"16540850.0\", \r\n" + "        \"percent_change_1h\": \"0.22\", \r\n"
		+ "        \"percent_change_24h\": \"-0.91\", \r\n" + "        \"percent_change_7d\": \"6.97\", \r\n"
		+ "        \"last_updated\": \"1504427070\", \r\n" + "        \"price_eur\": \"3930.38831795\", \r\n"
		+ "        \"24h_volume_eur\": \"1856983105.8\", \r\n" + "        \"market_cap_eur\": \"65011963609.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ethereum\", \r\n" + "        \"name\": \"Ethereum\", \r\n"
		+ "        \"symbol\": \"ETH\", \r\n" + "        \"rank\": \"2\", \r\n" + "        \"price_usd\": \"359.659\", \r\n"
		+ "        \"price_btc\": \"0.0766868\", \r\n" + "        \"24h_volume_usd\": \"1295750000.0\", \r\n"
		+ "        \"market_cap_usd\": \"33952198492.0\", \r\n" + "        \"available_supply\": \"94401081.0\", \r\n"
		+ "        \"total_supply\": \"94401081.0\", \r\n" + "        \"percent_change_1h\": \"0.8\", \r\n"
		+ "        \"percent_change_24h\": \"-0.81\", \r\n" + "        \"percent_change_7d\": \"6.83\", \r\n"
		+ "        \"last_updated\": \"1504427363\", \r\n" + "        \"price_eur\": \"303.190738705\", \r\n"
		+ "        \"24h_volume_eur\": \"1092310771.25\", \r\n" + "        \"market_cap_eur\": \"28621533568.0\"\r\n"
		+ "    }, \r\n" + "    {\r\n" + "        \"id\": \"bitcoin-cash\", \r\n" + "        \"name\": \"Bitcoin Cash\", \r\n"
		+ "        \"symbol\": \"BCH\", \r\n" + "        \"rank\": \"3\", \r\n" + "        \"price_usd\": \"590.844\", \r\n"
		+ "        \"price_btc\": \"0.126398\", \r\n" + "        \"24h_volume_usd\": \"235944000.0\", \r\n"
		+ "        \"market_cap_usd\": \"9783128482.0\", \r\n" + "        \"available_supply\": \"16557888.0\", \r\n"
		+ "        \"total_supply\": \"16557888.0\", \r\n" + "        \"percent_change_1h\": \"0.6\", \r\n"
		+ "        \"percent_change_24h\": \"-0.79\", \r\n" + "        \"percent_change_7d\": \"-2.57\", \r\n"
		+ "        \"last_updated\": \"1504427098\", \r\n" + "        \"price_eur\": \"498.07853778\", \r\n"
		+ "        \"24h_volume_eur\": \"198899612.28\", \r\n" + "        \"market_cap_eur\": \"8247128395.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ripple\", \r\n" + "        \"name\": \"Ripple\", \r\n"
		+ "        \"symbol\": \"XRP\", \r\n" + "        \"rank\": \"4\", \r\n" + "        \"price_usd\": \"0.232368\", \r\n"
		+ "        \"price_btc\": \"0.00004955\", \r\n" + "        \"24h_volume_usd\": \"243678000.0\", \r\n"
		+ "        \"market_cap_usd\": \"8909881851.0\", \r\n" + "        \"available_supply\": \"38343841883.0\", \r\n"
		+ "        \"total_supply\": \"99994523265.0\", \r\n" + "        \"percent_change_1h\": \"0.58\", \r\n"
		+ "        \"percent_change_24h\": \"-0.6\", \r\n" + "        \"percent_change_7d\": \"13.92\", \r\n"
		+ "        \"last_updated\": \"1504427341\", \r\n" + "        \"price_eur\": \"0.1958850622\", \r\n"
		+ "        \"24h_volume_eur\": \"205419335.61\", \r\n" + "        \"market_cap_eur\": \"7510985851.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"litecoin\", \r\n" + "        \"name\": \"Litecoin\", \r\n"
		+ "        \"symbol\": \"LTC\", \r\n" + "        \"rank\": \"5\", \r\n" + "        \"price_usd\": \"81.0996\", \r\n"
		+ "        \"price_btc\": \"0.0172921\", \r\n" + "        \"24h_volume_usd\": \"968784000.0\", \r\n"
		+ "        \"market_cap_usd\": \"4278817521.0\", \r\n" + "        \"available_supply\": \"52760032.0\", \r\n"
		+ "        \"total_supply\": \"52760032.0\", \r\n" + "        \"percent_change_1h\": \"1.14\", \r\n"
		+ "        \"percent_change_24h\": \"0.72\", \r\n" + "        \"percent_change_7d\": \"45.08\", \r\n"
		+ "        \"last_updated\": \"1504427343\", \r\n" + "        \"price_eur\": \"68.366557302\", \r\n"
		+ "        \"24h_volume_eur\": \"816680068.08\", \r\n" + "        \"market_cap_eur\": \"3607021776.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"nem\", \r\n" + "        \"name\": \"NEM\", \r\n" + "        \"symbol\": \"XEM\", \r\n"
		+ "        \"rank\": \"6\", \r\n" + "        \"price_usd\": \"0.314908\", \r\n"
		+ "        \"price_btc\": \"0.00006714\", \r\n" + "        \"24h_volume_usd\": \"8514690.0\", \r\n"
		+ "        \"market_cap_usd\": \"2834172000.0\", \r\n" + "        \"available_supply\": \"8999999999.0\", \r\n"
		+ "        \"total_supply\": \"8999999999.0\", \r\n" + "        \"percent_change_1h\": \"0.24\", \r\n"
		+ "        \"percent_change_24h\": \"2.64\", \r\n" + "        \"percent_change_7d\": \"16.2\", \r\n"
		+ "        \"last_updated\": \"1504427357\", \r\n" + "        \"price_eur\": \"0.2654658695\", \r\n"
		+ "        \"24h_volume_eur\": \"7177841.09655\", \r\n" + "        \"market_cap_eur\": \"2389192825.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"dash\", \r\n" + "        \"name\": \"Dash\", \r\n" + "        \"symbol\": \"DASH\", \r\n"
		+ "        \"rank\": \"7\", \r\n" + "        \"price_usd\": \"368.768\", \r\n"
		+ "        \"price_btc\": \"0.0786289\", \r\n" + "        \"24h_volume_usd\": \"49099900.0\", \r\n"
		+ "        \"market_cap_usd\": \"2776982523.0\", \r\n" + "        \"available_supply\": \"7530432.0\", \r\n"
		+ "        \"total_supply\": \"7530432.0\", \r\n" + "        \"percent_change_1h\": \"0.68\", \r\n"
		+ "        \"percent_change_24h\": \"0.19\", \r\n" + "        \"percent_change_7d\": \"-3.01\", \r\n"
		+ "        \"last_updated\": \"1504427347\", \r\n" + "        \"price_eur\": \"310.86958016\", \r\n"
		+ "        \"24h_volume_eur\": \"41390970.2005\", \r\n" + "        \"market_cap_eur\": \"2340982382.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"iota\", \r\n" + "        \"name\": \"IOTA\", \r\n"
		+ "        \"symbol\": \"MIOTA\", \r\n" + "        \"rank\": \"8\", \r\n" + "        \"price_usd\": \"0.761123\", \r\n"
		+ "        \"price_btc\": \"0.00016282\", \r\n" + "        \"24h_volume_usd\": \"40799000.0\", \r\n"
		+ "        \"market_cap_usd\": \"2115564428.0\", \r\n" + "        \"available_supply\": \"2779530283.0\", \r\n"
		+ "        \"total_supply\": \"2779530283.0\", \r\n" + "        \"percent_change_1h\": \"-1.22\", \r\n"
		+ "        \"percent_change_24h\": \"2.78\", \r\n" + "        \"percent_change_7d\": \"-17.2\", \r\n"
		+ "        \"last_updated\": \"1504427091\", \r\n" + "        \"price_eur\": \"0.6416228834\", \r\n"
		+ "        \"24h_volume_eur\": \"34393353.005\", \r\n" + "        \"market_cap_eur\": \"1783410235.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"monero\", \r\n" + "        \"name\": \"Monero\", \r\n"
		+ "        \"symbol\": \"XMR\", \r\n" + "        \"rank\": \"9\", \r\n" + "        \"price_usd\": \"128.425\", \r\n"
		+ "        \"price_btc\": \"0.0273828\", \r\n" + "        \"24h_volume_usd\": \"88658600.0\", \r\n"
		+ "        \"market_cap_usd\": \"1930054932.0\", \r\n" + "        \"available_supply\": \"15028654.0\", \r\n"
		+ "        \"total_supply\": \"15028654.0\", \r\n" + "        \"percent_change_1h\": \"0.58\", \r\n"
		+ "        \"percent_change_24h\": \"-1.98\", \r\n" + "        \"percent_change_7d\": \"-3.02\", \r\n"
		+ "        \"last_updated\": \"1504427349\", \r\n" + "        \"price_eur\": \"108.261632875\", \r\n"
		+ "        \"24h_volume_eur\": \"74738756.507\", \r\n" + "        \"market_cap_eur\": \"1627026658.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ethereum-classic\", \r\n" + "        \"name\": \"Ethereum Classic\", \r\n"
		+ "        \"symbol\": \"ETC\", \r\n" + "        \"rank\": \"10\", \r\n" + "        \"price_usd\": \"19.8485\", \r\n"
		+ "        \"price_btc\": \"0.00424613\", \r\n" + "        \"24h_volume_usd\": \"358235000.0\", \r\n"
		+ "        \"market_cap_usd\": \"1888603294.0\", \r\n" + "        \"available_supply\": \"95150933.0\", \r\n"
		+ "        \"total_supply\": \"95150933.0\", \r\n" + "        \"percent_change_1h\": \"0.14\", \r\n"
		+ "        \"percent_change_24h\": \"-3.67\", \r\n" + "        \"percent_change_7d\": \"27.11\", \r\n"
		+ "        \"last_updated\": \"1504427073\", \r\n" + "        \"price_eur\": \"16.7321862575\", \r\n"
		+ "        \"24h_volume_eur\": \"301990313.825\", \r\n" + "        \"market_cap_eur\": \"1592083134.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"neo\", \r\n" + "        \"name\": \"NEO\", \r\n" + "        \"symbol\": \"NEO\", \r\n"
		+ "        \"rank\": \"11\", \r\n" + "        \"price_usd\": \"31.5027\", \r\n"
		+ "        \"price_btc\": \"0.00671704\", \r\n" + "        \"24h_volume_usd\": \"70831300.0\", \r\n"
		+ "        \"market_cap_usd\": \"1575135000.0\", \r\n" + "        \"available_supply\": \"50000000.0\", \r\n"
		+ "        \"total_supply\": \"100000000.0\", \r\n" + "        \"percent_change_1h\": \"-0.04\", \r\n"
		+ "        \"percent_change_24h\": \"-3.37\", \r\n" + "        \"percent_change_7d\": \"-16.92\", \r\n"
		+ "        \"last_updated\": \"1504427373\", \r\n" + "        \"price_eur\": \"26.5566185865\", \r\n"
		+ "        \"24h_volume_eur\": \"59710431.7435\", \r\n" + "        \"market_cap_eur\": \"1327830929.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"omisego\", \r\n" + "        \"name\": \"OmiseGO\", \r\n"
		+ "        \"symbol\": \"OMG\", \r\n" + "        \"rank\": \"12\", \r\n" + "        \"price_usd\": \"10.6717\", \r\n"
		+ "        \"price_btc\": \"0.00228297\", \r\n" + "        \"24h_volume_usd\": \"67672200.0\", \r\n"
		+ "        \"market_cap_usd\": \"1049156427.0\", \r\n" + "        \"available_supply\": \"98312024.0\", \r\n"
		+ "        \"total_supply\": \"140245398.0\", \r\n" + "        \"percent_change_1h\": \"-2.97\", \r\n"
		+ "        \"percent_change_24h\": \"-2.16\", \r\n" + "        \"percent_change_7d\": \"31.06\", \r\n"
		+ "        \"last_updated\": \"1504427096\", \r\n" + "        \"price_eur\": \"8.9961897415\", \r\n"
		+ "        \"24h_volume_eur\": \"57047326.239\", \r\n" + "        \"market_cap_eur\": \"884433622.0\"\r\n" + "    }\r\n"
		+ "]";

}
