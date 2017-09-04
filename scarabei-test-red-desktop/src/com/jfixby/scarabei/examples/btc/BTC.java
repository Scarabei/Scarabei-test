
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

		for (final java.util.Map map : list) {
			final JsonString json_i = Json.serializeToString(map);
// L.d("json_i", json_i);
			final BTC btc = Json.deserializeFromString(BTC.class, json_i);
			btx.add(btc);
			L.d(btc.marketPrice());

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

	private BigDecimal marketPrice () {
		return this.price_eur;
	}

	public static String json = "[\r\n" + "    {\r\n" + "        \"id\": \"bitcoin\", \r\n" + "        \"name\": \"Bitcoin\", \r\n"
		+ "        \"symbol\": \"BTC\", \r\n" + "        \"rank\": \"1\", \r\n" + "        \"price_usd\": \"4536.43\", \r\n"
		+ "        \"price_btc\": \"1.0\", \r\n" + "        \"24h_volume_usd\": \"1964380000.0\", \r\n"
		+ "        \"market_cap_usd\": \"75040831185.0\", \r\n" + "        \"available_supply\": \"16541825.0\", \r\n"
		+ "        \"total_supply\": \"16541825.0\", \r\n" + "        \"percent_change_1h\": \"0.76\", \r\n"
		+ "        \"percent_change_24h\": \"0.2\", \r\n" + "        \"percent_change_7d\": \"3.9\", \r\n"
		+ "        \"last_updated\": \"1504469673\", \r\n" + "        \"price_eur\": \"3824.664133\", \r\n"
		+ "        \"24h_volume_eur\": \"1656168778.0\", \r\n" + "        \"market_cap_eur\": \"63266924772.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ethereum\", \r\n" + "        \"name\": \"Ethereum\", \r\n"
		+ "        \"symbol\": \"ETH\", \r\n" + "        \"rank\": \"2\", \r\n" + "        \"price_usd\": \"343.2\", \r\n"
		+ "        \"price_btc\": \"0.0751445\", \r\n" + "        \"24h_volume_usd\": \"1090380000.0\", \r\n"
		+ "        \"market_cap_usd\": \"32401616204.0\", \r\n" + "        \"available_supply\": \"94410304.0\", \r\n"
		+ "        \"total_supply\": \"94410304.0\", \r\n" + "        \"percent_change_1h\": \"-0.05\", \r\n"
		+ "        \"percent_change_24h\": \"2.21\", \r\n" + "        \"percent_change_7d\": \"0.49\", \r\n"
		+ "        \"last_updated\": \"1504469668\", \r\n" + "        \"price_eur\": \"289.35192\", \r\n"
		+ "        \"24h_volume_eur\": \"919299378.0\", \r\n" + "        \"market_cap_eur\": \"27317802621.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"bitcoin-cash\", \r\n" + "        \"name\": \"Bitcoin Cash\", \r\n"
		+ "        \"symbol\": \"BCH\", \r\n" + "        \"rank\": \"3\", \r\n" + "        \"price_usd\": \"602.247\", \r\n"
		+ "        \"price_btc\": \"0.131864\", \r\n" + "        \"24h_volume_usd\": \"332810000.0\", \r\n"
		+ "        \"market_cap_usd\": \"9972487624.0\", \r\n" + "        \"available_supply\": \"16558800.0\", \r\n"
		+ "        \"total_supply\": \"16558800.0\", \r\n" + "        \"percent_change_1h\": \"0.62\", \r\n"
		+ "        \"percent_change_24h\": \"5.46\", \r\n" + "        \"percent_change_7d\": \"-3.02\", \r\n"
		+ "        \"last_updated\": \"1504469712\", \r\n" + "        \"price_eur\": \"507.7544457\", \r\n"
		+ "        \"24h_volume_eur\": \"280592111.0\", \r\n" + "        \"market_cap_eur\": \"8407804315.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ripple\", \r\n" + "        \"name\": \"Ripple\", \r\n"
		+ "        \"symbol\": \"XRP\", \r\n" + "        \"rank\": \"4\", \r\n" + "        \"price_usd\": \"0.226266\", \r\n"
		+ "        \"price_btc\": \"0.00004954\", \r\n" + "        \"24h_volume_usd\": \"197229000.0\", \r\n"
		+ "        \"market_cap_usd\": \"8675907727.0\", \r\n" + "        \"available_supply\": \"38343841883.0\", \r\n"
		+ "        \"total_supply\": \"99994523265.0\", \r\n" + "        \"percent_change_1h\": \"0.55\", \r\n"
		+ "        \"percent_change_24h\": \"1.7\", \r\n" + "        \"percent_change_7d\": \"11.8\", \r\n"
		+ "        \"last_updated\": \"1504469643\", \r\n" + "        \"price_eur\": \"0.1907648646\", \r\n"
		+ "        \"24h_volume_eur\": \"166283769.9\", \r\n" + "        \"market_cap_eur\": \"7314657805.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"litecoin\", \r\n" + "        \"name\": \"Litecoin\", \r\n"
		+ "        \"symbol\": \"LTC\", \r\n" + "        \"rank\": \"5\", \r\n" + "        \"price_usd\": \"77.4036\", \r\n"
		+ "        \"price_btc\": \"0.0169477\", \r\n" + "        \"24h_volume_usd\": \"731173000.0\", \r\n"
		+ "        \"market_cap_usd\": \"4084379553.0\", \r\n" + "        \"available_supply\": \"52767307.0\", \r\n"
		+ "        \"total_supply\": \"52767307.0\", \r\n" + "        \"percent_change_1h\": \"1.16\", \r\n"
		+ "        \"percent_change_24h\": \"2.84\", \r\n" + "        \"percent_change_7d\": \"25.55\", \r\n"
		+ "        \"last_updated\": \"1504469646\", \r\n" + "        \"price_eur\": \"65.25897516\", \r\n"
		+ "        \"24h_volume_eur\": \"616451956.3\", \r\n" + "        \"market_cap_eur\": \"3443540401.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"nem\", \r\n" + "        \"name\": \"NEM\", \r\n" + "        \"symbol\": \"XEM\", \r\n"
		+ "        \"rank\": \"6\", \r\n" + "        \"price_usd\": \"0.297886\", \r\n"
		+ "        \"price_btc\": \"0.00006522\", \r\n" + "        \"24h_volume_usd\": \"7458010.0\", \r\n"
		+ "        \"market_cap_usd\": \"2680974000.0\", \r\n" + "        \"available_supply\": \"8999999999.0\", \r\n"
		+ "        \"total_supply\": \"8999999999.0\", \r\n" + "        \"percent_change_1h\": \"0.41\", \r\n"
		+ "        \"percent_change_24h\": \"-0.29\", \r\n" + "        \"percent_change_7d\": \"8.49\", \r\n"
		+ "        \"last_updated\": \"1504469667\", \r\n" + "        \"price_eur\": \"0.2511476866\", \r\n"
		+ "        \"24h_volume_eur\": \"6287848.231\", \r\n" + "        \"market_cap_eur\": \"2260329179.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"dash\", \r\n" + "        \"name\": \"Dash\", \r\n" + "        \"symbol\": \"DASH\", \r\n"
		+ "        \"rank\": \"7\", \r\n" + "        \"price_usd\": \"352.629\", \r\n"
		+ "        \"price_btc\": \"0.0772089\", \r\n" + "        \"24h_volume_usd\": \"38025700.0\", \r\n"
		+ "        \"market_cap_usd\": \"2657338735.0\", \r\n" + "        \"available_supply\": \"7535792.0\", \r\n"
		+ "        \"total_supply\": \"7535792.0\", \r\n" + "        \"percent_change_1h\": \"0.69\", \r\n"
		+ "        \"percent_change_24h\": \"4.6\", \r\n" + "        \"percent_change_7d\": \"-3.33\", \r\n"
		+ "        \"last_updated\": \"1504469649\", \r\n" + "        \"price_eur\": \"297.3015099\", \r\n"
		+ "        \"24h_volume_eur\": \"32059467.67\", \r\n" + "        \"market_cap_eur\": \"2240402288.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"iota\", \r\n" + "        \"name\": \"IOTA\", \r\n"
		+ "        \"symbol\": \"MIOTA\", \r\n" + "        \"rank\": \"8\", \r\n" + "        \"price_usd\": \"0.741602\", \r\n"
		+ "        \"price_btc\": \"0.00016238\", \r\n" + "        \"24h_volume_usd\": \"31943200.0\", \r\n"
		+ "        \"market_cap_usd\": \"2061305217.0\", \r\n" + "        \"available_supply\": \"2779530283.0\", \r\n"
		+ "        \"total_supply\": \"2779530283.0\", \r\n" + "        \"percent_change_1h\": \"0.68\", \r\n"
		+ "        \"percent_change_24h\": \"10.66\", \r\n" + "        \"percent_change_7d\": \"-19.58\", \r\n"
		+ "        \"last_updated\": \"1504469704\", \r\n" + "        \"price_eur\": \"0.6252446462\", \r\n"
		+ "        \"24h_volume_eur\": \"26931311.92\", \r\n" + "        \"market_cap_eur\": \"1737886428.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"monero\", \r\n" + "        \"name\": \"Monero\", \r\n"
		+ "        \"symbol\": \"XMR\", \r\n" + "        \"rank\": \"9\", \r\n" + "        \"price_usd\": \"121.734\", \r\n"
		+ "        \"price_btc\": \"0.0266539\", \r\n" + "        \"24h_volume_usd\": \"90841700.0\", \r\n"
		+ "        \"market_cap_usd\": \"1829753619.0\", \r\n" + "        \"available_supply\": \"15030752.0\", \r\n"
		+ "        \"total_supply\": \"15030752.0\", \r\n" + "        \"percent_change_1h\": \"0.86\", \r\n"
		+ "        \"percent_change_24h\": \"-2.39\", \r\n" + "        \"percent_change_7d\": \"-7.44\", \r\n"
		+ "        \"last_updated\": \"1504469649\", \r\n" + "        \"price_eur\": \"102.6339354\", \r\n"
		+ "        \"24h_volume_eur\": \"76588637.27\", \r\n" + "        \"market_cap_eur\": \"1542665277.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ethereum-classic\", \r\n" + "        \"name\": \"Ethereum Classic\", \r\n"
		+ "        \"symbol\": \"ETC\", \r\n" + "        \"rank\": \"10\", \r\n" + "        \"price_usd\": \"18.8659\", \r\n"
		+ "        \"price_btc\": \"0.00413073\", \r\n" + "        \"24h_volume_usd\": \"248360000.0\", \r\n"
		+ "        \"market_cap_usd\": \"1795395560.0\", \r\n" + "        \"available_supply\": \"95166176.0\", \r\n"
		+ "        \"total_supply\": \"95166176.0\", \r\n" + "        \"percent_change_1h\": \"1.19\", \r\n"
		+ "        \"percent_change_24h\": \"1.1\", \r\n" + "        \"percent_change_7d\": \"17.77\", \r\n"
		+ "        \"last_updated\": \"1504469678\", \r\n" + "        \"price_eur\": \"15.90584029\", \r\n"
		+ "        \"24h_volume_eur\": \"209392316.0\", \r\n" + "        \"market_cap_eur\": \"1513697996.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"neo\", \r\n" + "        \"name\": \"NEO\", \r\n" + "        \"symbol\": \"NEO\", \r\n"
		+ "        \"rank\": \"11\", \r\n" + "        \"price_usd\": \"30.1055\", \r\n"
		+ "        \"price_btc\": \"0.00659167\", \r\n" + "        \"24h_volume_usd\": \"46152500.0\", \r\n"
		+ "        \"market_cap_usd\": \"1505275000.0\", \r\n" + "        \"available_supply\": \"50000000.0\", \r\n"
		+ "        \"total_supply\": \"100000000.0\", \r\n" + "        \"percent_change_1h\": \"1.06\", \r\n"
		+ "        \"percent_change_24h\": \"-4.57\", \r\n" + "        \"percent_change_7d\": \"-21.54\", \r\n"
		+ "        \"last_updated\": \"1504469689\", \r\n" + "        \"price_eur\": \"25.38194705\", \r\n"
		+ "        \"24h_volume_eur\": \"38911172.75\", \r\n" + "        \"market_cap_eur\": \"1269097352.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"omisego\", \r\n" + "        \"name\": \"OmiseGO\", \r\n"
		+ "        \"symbol\": \"OMG\", \r\n" + "        \"rank\": \"12\", \r\n" + "        \"price_usd\": \"10.182\", \r\n"
		+ "        \"price_btc\": \"0.00222937\", \r\n" + "        \"24h_volume_usd\": \"68112500.0\", \r\n"
		+ "        \"market_cap_usd\": \"1001013028.0\", \r\n" + "        \"available_supply\": \"98312024.0\", \r\n"
		+ "        \"total_supply\": \"140245398.0\", \r\n" + "        \"percent_change_1h\": \"-0.7\", \r\n"
		+ "        \"percent_change_24h\": \"0.04\", \r\n" + "        \"percent_change_7d\": \"22.73\", \r\n"
		+ "        \"last_updated\": \"1504469711\", \r\n" + "        \"price_eur\": \"8.5844442\", \r\n"
		+ "        \"24h_volume_eur\": \"57425648.75\", \r\n" + "        \"market_cap_eur\": \"843954084.0\"\r\n" + "    }\r\n"
		+ "]";

}
