package org.gigue.util;

import java.util.HashMap;
import java.util.Map;

import org.gigue.exceptions.GigueException;


public class GigueUtil {

	static final String ARGUMENTS_REQUIRED = "arguments required";
	static final String ARGUMENT_PAIRS_REQUIRED = "argument pairs required";

	public static Map<String, Object> map(Object... keyValuePairs) {
		if (keyValuePairs.length == 0) {
			throw new GigueException(ARGUMENTS_REQUIRED);
		}
		if (keyValuePairs.length % 2 != 0) {
			throw new GigueException(ARGUMENT_PAIRS_REQUIRED);
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		String key = null;
		Object value = null;
		int i = 0;
		for (Object obj : keyValuePairs) {
			if (i == 0) {
				key = (String) obj;
				value = null;
			}
			if (i == 1) {
				value = obj;
				map.put(key, value);
			}
			i++;
		}
		return map;
	}
}
