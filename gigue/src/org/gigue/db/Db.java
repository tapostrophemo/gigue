package org.gigue.db;

import java.util.List;
import java.util.Map;

public class Db {

	public Db select(String columnNames) {
		return this;
	}

	public Db get(String tableName) {
		return this;
	}

	public Db orderBy(String columnNames) {
		return this;
	}

	public List<ResultRow> result() {
		return null;
	}

	public boolean insert(String tableName, Map<String, Object> columnValueMap) {
		return false;
	}
}
