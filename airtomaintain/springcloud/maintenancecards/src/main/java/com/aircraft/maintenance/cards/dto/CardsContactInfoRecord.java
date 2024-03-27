/**
 * 
 */
package com.aircraft.maintenance.cards.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author senthilvinayahammurugan
 *
 */
@ConfigurationProperties(prefix="partsandtools")
public record CardsContactInfoRecord(String message, Map<String, String> contactDetails, List<String> onCallSupport) {

}
