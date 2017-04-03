package com.bsisoftware.mhu.ants.shared.exception;

public final class AntsRemoteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code;
	
	AntsRemoteException(int code, String message) {
		super(Integer.toString(code) + " - " + message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}

