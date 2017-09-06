
package com.jfixby.scarabei.examples.btc.round2;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.EditableCollection;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.collections.Set;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.json.Json;
import com.jfixby.scarabei.api.json.JsonString;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.strings.Strings;
import com.jfixby.scarabei.api.sys.settings.ExecutionMode;
import com.jfixby.scarabei.api.sys.settings.SystemSettings;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

class BTC2 {

	private static Comparator<BTC2> by24HGrowth = new Comparator<BTC2>() {

		@Override
		public int compare (final BTC2 o1, final BTC2 o2) {
			return o1.percent_change_24h.compareTo(o2.percent_change_24h) * 0;
		}
	};
	String id;
	String symbol;
	int rank;
	BigDecimal price_usd;
	BigDecimal market_cap_usd;
	BigDecimal price_eur;
	BigDecimal market_cap_eur;
	BigDecimal percent_change_24h = BigDecimal.valueOf(Integer.MIN_VALUE);
	BigDecimal BD_100 = BigDecimal.valueOf(100);

	public String toCSV () {
		return this.rank + "	" + this.id + "	" + this.symbol + "	" + this.price_eur + "	" + this.market_cap_eur + "	"
			+ this.percent_change_24h.divide(this.BD_100) + "	" + 1;
	}

	public String toCSV (final double amount) {
		return this.rank + "	" + this.id + "	" + this.symbol + "	" + this.price_eur + "	" + this.market_cap_eur + "	"
			+ this.percent_change_24h.divide(this.BD_100) + "	" + amount;
	}

	@Override
	public String toString () {
		return "BTC2 [id=" + this.id + ", symbol=" + this.symbol + ", rank=" + this.rank + ", price_usd=" + this.price_usd
			+ ", market_cap_usd=" + this.market_cap_usd + ", price_eur=" + this.price_eur + ", market_cap_eur=" + this.market_cap_eur
			+ " percent_change_24h=" + this.percent_change_24h + "]";
	}

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();
		SystemSettings.setExecutionMode(ExecutionMode.DEMO);
		final File inputFile = LocalFileSystem.ApplicationHome().child("btc").child("update.json");
		final String jsonString = inputFile.readToString();
		final java.util.List<java.util.Map> list = Json.deserializeFromString(java.util.List.class, jsonString);
		final List<BTC2> btx = Collections.newList();
		for (final java.util.Map map : list) {
			final JsonString json_i = Json.serializeToString(map);
// L.d("json_i", json_i);
			final BTC2 btc = Json.deserializeFromString(BTC2.class, json_i);
			if (btc.percent_change_24h.doubleValue() > 0 || true) {
				btx.add(btc);
// L.d(btc.toCSV());
			}
		}
		final List<BTC2> top = btx.copy();
		final EditableCollection<BTC2> tail = top.splitAt(11);
		L.d(" top", top);
		L.d("tail", tail);
		tail.sort(by24HGrowth);
		int index = 0;
		final int topRank = 40;
		Set<String> exchange = karaken();
		exchange = bitfinex();
		for (final BTC2 c : tail) {
			if (index <= topRank) {
				if (pass(c, exchange)) {
					L.d(c.toCSV());
				} else {
					L.d(c.toCSV(0));
				}
			} else {
				break;
			}
			index++;
		}
// L.d("by24HGrowth", btx);

	}

	private static boolean pass (final BTC2 c, final Set<String> karaken) {
		if (!karaken.contains(c.symbol)) {
			return false;
		}
		return c.percent_change_24h.doubleValue() > 0 || true;
	}

	public static final Set<String> bitfinex () {
		final String bt = "BTC\r\n" + "BCH\r\n" + "DASH\r\n" + "ETH\r\n" + "ZEC\r\n" + "XMR\r\n" + "LTC\r\n" + "ETC\r\n" + "OMG\r\n"
			+ "EOS\r\n" + "MIOTA\r\n" + "XRP";
		final List<String> tags = Strings.split(bt, "\r\n");
		final Set<String> bitfinex = Collections.newSet(tags);
		return bitfinex;
	}

	static public Set<String> karaken () {
		final String kr = "Yes. You can trade Bitcoin(XBT), Ethereum (ETH), Monero (XMR), Dash (DASH), Litecoin (LTC), Ripple (XRP), Stellar/Lumens (XLM), Ethereum Classic (ETC), Augur REP tokens (REP), ICONOMI (ICN), Melon (MLN), Zcash (ZEC), Dogecoin (XDG), Tether (USDT), Gnosis (GNO), and EOS (EOS)";
		final List<String> lefts = Strings.split(kr, "\\)");
		final Set<String> karaken = Collections.newSet();
		for (final String l : lefts) {
			final List<String> sm = Strings.split(l, "\\(");
// L.d("", );
			final String s = sm.getLast();
			karaken.add(s);
		}
		return karaken;

	}

	private BigDecimal marketPrice () {
		return this.price_eur;
	}

}
