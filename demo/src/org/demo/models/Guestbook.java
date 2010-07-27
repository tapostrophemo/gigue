package org.demo.models;

import java.util.List;

import org.gigue.db.ResultRow;
import org.gigue.framework.Model;
import org.gigue.util.GigueUtil;

public class Guestbook extends Model {

	public List<ResultRow> getGuests() {
		this.db.select("name").orderBy("tstamp desc");
		return this.db.get("guests").result();
	}

	public void saveSignature(String name, String comment) {
		this.db.insert("guests", GigueUtil.map(
			"name", name,
			"comment", comment));
	}
}
