package com.bsisoftware.mhu.ants.shared.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class ConfigurationsDTO {
	
	@XmlElement(name="configurations")
	private ConfigurationDTO[] configurations;

	public ConfigurationDTO[] getConfigurations() {
		return configurations;
	}
}
