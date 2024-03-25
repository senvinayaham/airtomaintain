/**
 * 
 */
package com.aircraft.maintenance.partsandtools.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author senthilvinayahammurugan
 *
 */
@ConfigurationProperties(prefix="partsandtools")
@Getter
@Setter
public class PartsAndToolsContactInfo {
	
	private String message;
	private Map<String, String> contactDetails;
	private List<String> onCallSupport;

}
