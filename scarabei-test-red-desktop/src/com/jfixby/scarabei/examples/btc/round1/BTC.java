
package com.jfixby.scarabei.examples.btc.round1;

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

class BTC {

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
		final BTC json = new BTC();
		final java.util.List<java.util.Map> list = Json.deserializeFromString(java.util.List.class, json.json);
		final List<BTC> btx = Collections.newList();
		for (final java.util.Map map : list) {
			final JsonString json_i = Json.serializeToString(map);
			L.d("json_i", json_i);
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

	public String json = "[\r\n" + "    {\r\n" + "        \"id\": \"bitcoin\", \r\n" + "        \"name\": \"Bitcoin\", \r\n"
		+ "        \"symbol\": \"BTC\", \r\n" + "        \"rank\": \"1\", \r\n" + "        \"price_usd\": \"4276.27\", \r\n"
		+ "        \"price_btc\": \"1.0\", \r\n" + "        \"24h_volume_usd\": \"2958240000.0\", \r\n"
		+ "        \"market_cap_usd\": \"70747303636.0\", \r\n" + "        \"available_supply\": \"16544162.0\", \r\n"
		+ "        \"total_supply\": \"16544162.0\", \r\n" + "        \"percent_change_1h\": \"0.56\", \r\n"
		+ "        \"percent_change_24h\": \"-5.91\", \r\n" + "        \"percent_change_7d\": \"-2.0\", \r\n"
		+ "        \"last_updated\": \"1504559079\", \r\n" + "        \"price_eur\": \"3593.20428782\", \r\n"
		+ "        \"24h_volume_eur\": \"2485708491.84\", \r\n" + "        \"market_cap_eur\": \"59446553837.0\"\r\n"
		+ "    }, \r\n" + "    {\r\n" + "        \"id\": \"ethereum\", \r\n" + "        \"name\": \"Ethereum\", \r\n"
		+ "        \"symbol\": \"ETH\", \r\n" + "        \"rank\": \"2\", \r\n" + "        \"price_usd\": \"304.959\", \r\n"
		+ "        \"price_btc\": \"0.0700733\", \r\n" + "        \"24h_volume_usd\": \"1753160000.0\", \r\n"
		+ "        \"market_cap_usd\": \"28797244262.0\", \r\n" + "        \"available_supply\": \"94429888.0\", \r\n"
		+ "        \"total_supply\": \"94429888.0\", \r\n" + "        \"percent_change_1h\": \"1.14\", \r\n"
		+ "        \"percent_change_24h\": \"-11.29\", \r\n" + "        \"percent_change_7d\": \"-11.82\", \r\n"
		+ "        \"last_updated\": \"1504559070\", \r\n" + "        \"price_eur\": \"256.246679094\", \r\n"
		+ "        \"24h_volume_eur\": \"1473120740.56\", \r\n" + "        \"market_cap_eur\": \"24197345247.0\"\r\n"
		+ "    }, \r\n" + "    {\r\n" + "        \"id\": \"bitcoin-cash\", \r\n" + "        \"name\": \"Bitcoin Cash\", \r\n"
		+ "        \"symbol\": \"BCH\", \r\n" + "        \"rank\": \"3\", \r\n" + "        \"price_usd\": \"526.324\", \r\n"
		+ "        \"price_btc\": \"0.120938\", \r\n" + "        \"24h_volume_usd\": \"339140000.0\", \r\n"
		+ "        \"market_cap_usd\": \"8716122812.0\", \r\n" + "        \"available_supply\": \"16560375.0\", \r\n"
		+ "        \"total_supply\": \"16560375.0\", \r\n" + "        \"percent_change_1h\": \"0.39\", \r\n"
		+ "        \"percent_change_24h\": \"-11.9\", \r\n" + "        \"percent_change_7d\": \"-12.02\", \r\n"
		+ "        \"last_updated\": \"1504559115\", \r\n" + "        \"price_eur\": \"442.252162184\", \r\n"
		+ "        \"24h_volume_eur\": \"284967811.24\", \r\n" + "        \"market_cap_eur\": \"7323861650.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ripple\", \r\n" + "        \"name\": \"Ripple\", \r\n"
		+ "        \"symbol\": \"XRP\", \r\n" + "        \"rank\": \"4\", \r\n" + "        \"price_usd\": \"0.206787\", \r\n"
		+ "        \"price_btc\": \"0.00004752\", \r\n" + "        \"24h_volume_usd\": \"229624000.0\", \r\n"
		+ "        \"market_cap_usd\": \"7929008031.0\", \r\n" + "        \"available_supply\": \"38343841883.0\", \r\n"
		+ "        \"total_supply\": \"99994523265.0\", \r\n" + "        \"percent_change_1h\": \"0.49\", \r\n"
		+ "        \"percent_change_24h\": \"-8.91\", \r\n" + "        \"percent_change_7d\": \"-5.95\", \r\n"
		+ "        \"last_updated\": \"1504559042\", \r\n" + "        \"price_eur\": \"0.1737560853\", \r\n"
		+ "        \"24h_volume_eur\": \"192945239.984\", \r\n" + "        \"market_cap_eur\": \"6662475863.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"litecoin\", \r\n" + "        \"name\": \"Litecoin\", \r\n"
		+ "        \"symbol\": \"LTC\", \r\n" + "        \"rank\": \"5\", \r\n" + "        \"price_usd\": \"67.2675\", \r\n"
		+ "        \"price_btc\": \"0.0154567\", \r\n" + "        \"24h_volume_usd\": \"894945000.0\", \r\n"
		+ "        \"market_cap_usd\": \"3550456504.0\", \r\n" + "        \"available_supply\": \"52781157.0\", \r\n"
		+ "        \"total_supply\": \"52781157.0\", \r\n" + "        \"percent_change_1h\": \"0.92\", \r\n"
		+ "        \"percent_change_24h\": \"-13.38\", \r\n" + "        \"percent_change_7d\": \"7.0\", \r\n"
		+ "        \"last_updated\": \"1504559045\", \r\n" + "        \"price_eur\": \"56.522593155\", \r\n"
		+ "        \"24h_volume_eur\": \"751991855.37\", \r\n" + "        \"market_cap_eur\": \"2983327884.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"nem\", \r\n" + "        \"name\": \"NEM\", \r\n" + "        \"symbol\": \"XEM\", \r\n"
		+ "        \"rank\": \"6\", \r\n" + "        \"price_usd\": \"0.279633\", \r\n"
		+ "        \"price_btc\": \"0.00006425\", \r\n" + "        \"24h_volume_usd\": \"9005490.0\", \r\n"
		+ "        \"market_cap_usd\": \"2516697000.0\", \r\n" + "        \"available_supply\": \"8999999999.0\", \r\n"
		+ "        \"total_supply\": \"8999999999.0\", \r\n" + "        \"percent_change_1h\": \"1.35\", \r\n"
		+ "        \"percent_change_24h\": \"-6.77\", \r\n" + "        \"percent_change_7d\": \"-0.35\", \r\n"
		+ "        \"last_updated\": \"1504559063\", \r\n" + "        \"price_eur\": \"0.2349661024\", \r\n"
		+ "        \"24h_volume_eur\": \"7567007.06034\", \r\n" + "        \"market_cap_eur\": \"2114694921.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"dash\", \r\n" + "        \"name\": \"Dash\", \r\n" + "        \"symbol\": \"DASH\", \r\n"
		+ "        \"rank\": \"7\", \r\n" + "        \"price_usd\": \"322.076\", \r\n"
		+ "        \"price_btc\": \"0.0740065\", \r\n" + "        \"24h_volume_usd\": \"41473700.0\", \r\n"
		+ "        \"market_cap_usd\": \"2427756809.0\", \r\n" + "        \"available_supply\": \"7537838.0\", \r\n"
		+ "        \"total_supply\": \"7537838.0\", \r\n" + "        \"percent_change_1h\": \"1.23\", \r\n"
		+ "        \"percent_change_24h\": \"-8.82\", \r\n" + "        \"percent_change_7d\": \"-9.84\", \r\n"
		+ "        \"last_updated\": \"1504559046\", \r\n" + "        \"price_eur\": \"270.629512216\", \r\n"
		+ "        \"24h_volume_eur\": \"34848940.0042\", \r\n" + "        \"market_cap_eur\": \"2039961503.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"iota\", \r\n" + "        \"name\": \"IOTA\", \r\n"
		+ "        \"symbol\": \"MIOTA\", \r\n" + "        \"rank\": \"8\", \r\n" + "        \"price_usd\": \"0.641762\", \r\n"
		+ "        \"price_btc\": \"0.00014746\", \r\n" + "        \"24h_volume_usd\": \"77539000.0\", \r\n"
		+ "        \"market_cap_usd\": \"1783796913.0\", \r\n" + "        \"available_supply\": \"2779530283.0\", \r\n"
		+ "        \"total_supply\": \"2779530283.0\", \r\n" + "        \"percent_change_1h\": \"-1.61\", \r\n"
		+ "        \"percent_change_24h\": \"-13.11\", \r\n" + "        \"percent_change_7d\": \"-25.4\", \r\n"
		+ "        \"last_updated\": \"1504559107\", \r\n" + "        \"price_eur\": \"0.5392507887\", \r\n"
		+ "        \"24h_volume_eur\": \"65153385.374\", \r\n" + "        \"market_cap_eur\": \"1498863897.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"monero\", \r\n" + "        \"name\": \"Monero\", \r\n"
		+ "        \"symbol\": \"XMR\", \r\n" + "        \"rank\": \"9\", \r\n" + "        \"price_usd\": \"110.922\", \r\n"
		+ "        \"price_btc\": \"0.0254877\", \r\n" + "        \"24h_volume_usd\": \"90853700.0\", \r\n"
		+ "        \"market_cap_usd\": \"1667797548.0\", \r\n" + "        \"available_supply\": \"15035769.0\", \r\n"
		+ "        \"total_supply\": \"15035769.0\", \r\n" + "        \"percent_change_1h\": \"1.9\", \r\n"
		+ "        \"percent_change_24h\": \"-9.73\", \r\n" + "        \"percent_change_7d\": \"-20.93\", \r\n"
		+ "        \"last_updated\": \"1504559050\", \r\n" + "        \"price_eur\": \"93.203985252\", \r\n"
		+ "        \"24h_volume_eur\": \"76341275.0842\", \r\n" + "        \"market_cap_eur\": \"1401393575.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"ethereum-classic\", \r\n" + "        \"name\": \"Ethereum Classic\", \r\n"
		+ "        \"symbol\": \"ETC\", \r\n" + "        \"rank\": \"10\", \r\n" + "        \"price_usd\": \"16.2671\", \r\n"
		+ "        \"price_btc\": \"0.00373783\", \r\n" + "        \"24h_volume_usd\": \"244304000.0\", \r\n"
		+ "        \"market_cap_usd\": \"1548612108.0\", \r\n" + "        \"available_supply\": \"95199028.0\", \r\n"
		+ "        \"total_supply\": \"95199028.0\", \r\n" + "        \"percent_change_1h\": \"0.99\", \r\n"
		+ "        \"percent_change_24h\": \"-13.93\", \r\n" + "        \"percent_change_7d\": \"3.15\", \r\n"
		+ "        \"last_updated\": \"1504559079\", \r\n" + "        \"price_eur\": \"13.6686910486\", \r\n"
		+ "        \"24h_volume_eur\": \"205280344.864\", \r\n" + "        \"market_cap_eur\": \"1301246102.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"neo\", \r\n" + "        \"name\": \"NEO\", \r\n" + "        \"symbol\": \"NEO\", \r\n"
		+ "        \"rank\": \"11\", \r\n" + "        \"price_usd\": \"23.0241\", \r\n"
		+ "        \"price_btc\": \"0.00529047\", \r\n" + "        \"24h_volume_usd\": \"181693000.0\", \r\n"
		+ "        \"market_cap_usd\": \"1151205000.0\", \r\n" + "        \"available_supply\": \"50000000.0\", \r\n"
		+ "        \"total_supply\": \"100000000.0\", \r\n" + "        \"percent_change_1h\": \"1.01\", \r\n"
		+ "        \"percent_change_24h\": \"-23.13\", \r\n" + "        \"percent_change_7d\": \"-39.54\", \r\n"
		+ "        \"last_updated\": \"1504559083\", \r\n" + "        \"price_eur\": \"19.3463684106\", \r\n"
		+ "        \"24h_volume_eur\": \"152670450.338\", \r\n" + "        \"market_cap_eur\": \"967318421.0\"\r\n" + "    }, \r\n"
		+ "    {\r\n" + "        \"id\": \"omisego\", \r\n" + "        \"name\": \"OmiseGO\", \r\n"
		+ "        \"symbol\": \"OMG\", \r\n" + "        \"rank\": \"12\", \r\n" + "        \"price_usd\": \"8.78988\", \r\n"
		+ "        \"price_btc\": \"0.00201973\", \r\n" + "        \"24h_volume_usd\": \"148993000.0\", \r\n"
		+ "        \"market_cap_usd\": \"864150894.0\", \r\n" + "        \"available_supply\": \"98312024.0\", \r\n"
		+ "        \"total_supply\": \"140245398.0\", \r\n" + "        \"percent_change_1h\": \"0.29\", \r\n"
		+ "        \"percent_change_24h\": \"-15.14\", \r\n" + "        \"percent_change_7d\": \"2.9\", \r\n"
		+ "        \"last_updated\": \"1504559114\", \r\n" + "        \"price_eur\": \"7.3858373081\", \r\n"
		+ "        \"24h_volume_eur\": \"125193752.138\", \r\n" + "        \"market_cap_eur\": \"726116615.0\"\r\n" + "    }\r\n"
		+ "]";

}
