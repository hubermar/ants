package com.bsisoftware.mhu.ants.shared.api;

public interface AntsAPI {

	public static final String PATH_CONFIGS = "/configurations";
	public static final String PATH_LANDSCAPE = "/landscape";

	LandscapeDTO getLandscape();
	

}
