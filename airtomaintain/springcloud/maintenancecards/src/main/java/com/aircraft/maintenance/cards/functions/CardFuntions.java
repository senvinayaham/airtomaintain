/**
 * 
 */
package com.aircraft.maintenance.cards.functions;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aircraft.maintenance.cards.service.IWorkCardsService;


/**
 * @author senthilvinayahammurugan
 *
 */
@Configuration
public class CardFuntions {
	
	
	private static final Logger log = LoggerFactory.getLogger(CardFuntions.class);
	
	@Bean
	public Consumer<String> updateCommunication(IWorkCardsService iWorkCardsService){
		
		return workCardNumber -> {
			log.info("Updating Communication status for the workcard: "+workCardNumber);
			iWorkCardsService.updateCommunicationStatus(workCardNumber);
		};
	}
}
