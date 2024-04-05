/**
 * 
 */
package com.aircraft.maintenance.event.message.functions;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aircraft.maintenance.event.message.dto.CardsMessageDto;

/**
 * @author senthilvinayahammurugan
 *
 */
@Configuration
public class MessageFunctions {
	
	private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);
	
	@Bean
	public Function<CardsMessageDto, CardsMessageDto> emailmessage(){
		
		
		return cardsMessageDto -> {
		
			log.info("Sending email with the details"+ cardsMessageDto.toString());
			return cardsMessageDto;
		};
		
	}
	
	@Bean
	public Function<CardsMessageDto, String> smsmessage(){
		
		
		return cardsMessageDto -> {
		
			log.info("Sending SMS with the details"+ cardsMessageDto.toString());
			return cardsMessageDto.workCardNumber();
		};
		
	}

}
