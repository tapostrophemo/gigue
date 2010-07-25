package org.demo.models;

import java.util.List;

import org.gigue.Model;
import org.gigue.db.ResultRow;

public class Guestbook extends Model {

	public List<ResultRow> getGuests() {
//		this.db.select("name").orderBy("tstamp desc");
//		return this.db.get("guests").result();
		return null;
	}

	public void saveSignature(String name, String comment) {
//		this.db.insert("guests", GigueUtil.array(
//			"name", name,
//			"comment", comment));
	}
}

