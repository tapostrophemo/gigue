package org.demo.models;

import org.gigue.Model;
import org.gigue.Gigue;
import org.gigue.db.ResultRow;
import java.util.List;

public class Guestbook extends Model {

	public List<ResultRow> getGuests() {
		this.db.select("name").orderBy("tstamp desc");
		return this.db.get("guests").result();
	}

	public void saveSignature(String name, String comment) {
		this.db.insert("guests", Gigue.array(
			"name", name,
			"comment", comment));
	}
}

