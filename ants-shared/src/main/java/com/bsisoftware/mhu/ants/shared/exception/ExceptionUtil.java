package com.bsisoftware.mhu.ants.shared.exception;

import org.slf4j.Logger;

public final class ExceptionUtil {

	private ExceptionUtil() {}
	
	public static FatalAntsException fatal(Logger logger, String message, Throwable cause) {
		logger.error(message, cause);
		return new FatalAntsException(message, cause);
	}

	public static AntsRemoteException remote(Logger logger, int code, String message) {
		logger.error(Integer.toString(code) + " - " + message);
		return new AntsRemoteException(code, message);
	}

}
