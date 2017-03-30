package com.bsisoftware.mhu.ants.shared.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class ErrorDTO {

	@XmlElement(name="code")
	private int code;

	@XmlElement(name="message")
	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
