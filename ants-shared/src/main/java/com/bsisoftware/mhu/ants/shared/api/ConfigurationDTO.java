package com.bsisoftware.mhu.ants.shared.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class ConfigurationDTO {

	@XmlElement(name="key")
	private String key;

	@XmlElement(name="value")
	private String value;
	
	private ConfigurationDTO() {}
	
	private ConfigurationDTO(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}
