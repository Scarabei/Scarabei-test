
package com.jfixby.scarabei.examples.db;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collection;
import com.jfixby.scarabei.api.db.Entry;
import com.jfixby.scarabei.api.db.Table;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.names.Names;
import com.jfixby.scarabei.red.db.simple.SimpleDB;
import com.jfixby.scarabei.red.db.simple.SimpleDBConfig;
import com.jfixby.scarabei.red.db.simple.SimpleTableSpecs;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class StupidDBTest {

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();
// SystemSettings.setExecutionMode(ExecutionMode.DEMO);

		final SimpleDBConfig cfg = new SimpleDBConfig();
		cfg.dbName = Names.newID("test.db");
		cfg.storageFolder = LocalFileSystem.ApplicationHome().child("dbFolder");
		cfg.readFromStorage = true;
		final SimpleDB db = new SimpleDB(cfg);
// db.drop();
		final String table1name = "table1";
		{
			final SimpleTableSpecs specs = db.newTableSpecs();

			specs.tableName = table1name;
			specs.addColumn("x");
			specs.addColumn("y");
			specs.addColumn("z");
// final SimpleTable newTable = db.newTable(specs);
		}
		final Table table1 = db.getTable(table1name);
		{
			final Collection<Entry> all = table1.listAll();
			L.d("all", all);
		}

		final Entry e = table1.newEntry();
		e.setValue("x", "1");
		e.setValue("y", "sdfsdfsdf");
		table1.addEntry(e);
		{
			final Collection<Entry> all = table1.listAll();
			L.d("all", all);
		}
// table1.clear();
		final Collection<Entry> good = table1.findEntries("y", "sdfsdfsdf");
		L.d("good", good);
		{
			final Collection<Entry> all = table1.listAll();
			L.d("all", all);
		}
	}

}
