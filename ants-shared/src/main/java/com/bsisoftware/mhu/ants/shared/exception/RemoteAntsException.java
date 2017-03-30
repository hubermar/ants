package com.bsisoftware.mhu.ants.shared.exception;

public final class RemoteAntsException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;
	
	RemoteAntsException(int code, String message) {
		super(Integer.toString(code) + " - " + message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}

