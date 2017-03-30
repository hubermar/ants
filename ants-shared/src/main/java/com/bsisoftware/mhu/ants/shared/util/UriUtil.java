package com.bsisoftware.mhu.ants.shared.util;

public final class UriUtil {

	public static final String CONTEXT = "/ants";
	public static final String VERSION = "/v1";
	public static final String PREFIX = "/api";
	
	public static final String PATH_CONFIGS = "/configurations";
	
	private UriUtil() {}
	
	public static String create(String path) {
		return CONTEXT + PREFIX + VERSION + path;
	}
}
