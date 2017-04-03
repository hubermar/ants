package com.bsisoftware.mhu.ants.shared.util;

import java.nio.file.Paths;

public final class UriUtil {

	public static final String CONTEXT = "/ants";
	public static final String VERSION = "/v1";
	public static final String PREFIX = "/api";
	
	private UriUtil() {}
	
	public static String create(String path) {
		return Paths.get(CONTEXT, PREFIX, VERSION, path).toString();
	}
}
