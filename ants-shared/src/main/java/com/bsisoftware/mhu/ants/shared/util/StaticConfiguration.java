package com.bsisoftware.mhu.ants.shared.util;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsisoftware.mhu.ants.shared.exception.ExceptionUtil;

public final class StaticConfiguration {

	public static final String SERVER_PORT = "serverPort";
	public static final String FIELD_SIZE = "fieldSize";
	public static final String NBR_FOOD = "nbrFood";
	public static final String NBR_ANTS = "nbrAnts";

	private static final Logger LOG = LoggerFactory.getLogger(StaticConfiguration.class);
	private static final String PROP_FILENAME = "ants.properties";
	private static final Properties CONFIG = new Properties();

	static {
		try {
			InputStream stream = ClassLoader.getSystemResourceAsStream(PROP_FILENAME);
			CONFIG.load(stream);
		} catch (Exception e) {
			throw ExceptionUtil.fatal(LOG, "Failed to load CONFIG from " + PROP_FILENAME, e);
		}
	}

	public static String getString(String key) {
		return getMandatory(key);
	}

	public static String getString(String key, String defaultValue) {
		return getOptional(key, defaultValue);
	}

	public static int getInt(String key) {
		return Integer.parseInt(getMandatory(key));
	}

	public static int getInt(String key, int defaultValue) {
		return Integer.parseInt(getOptional(key, Integer.toString(defaultValue)));
	}
	
	public static double getDouble(String key) {
		return Double.parseDouble(getMandatory(key));
	}

	public static double getDouble(String key, double defaultValue) {
		return Double.parseDouble(getOptional(key, Double.toString(defaultValue)));
	}

	private static String getMandatory(String key) {
		String value = CONFIG.getProperty(key);
		if (value == null) {
			throw ExceptionUtil.fatal(LOG, "Missing mandatory config [" + key + "]", null);
		}
		return value;
	}

	private static String getOptional(String key, String defaultValue) {
		String value = CONFIG.getProperty(key);
		return value == null ? defaultValue : value;
	}

	private StaticConfiguration() {
	}
}
