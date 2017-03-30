package com.bsisoftware.mhu.ants.shared.exception;

public final class FatalAntsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	FatalAntsException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
