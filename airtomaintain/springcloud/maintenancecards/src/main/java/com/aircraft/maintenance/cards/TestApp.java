/**
 * 
 */
package com.aircraft.maintenance.cards;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author senthilvinayahammurugan
 *
 */
public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> values = Arrays.asList(1,2,4,5,3,9);
		
		Stream<Integer> temp = values.stream()
								.filter(e -> e > 3)
								.filter(e -> e % 3 == 0)
								.map(e -> e * 2);
		
		System.out.println("Out put value:::"+ temp.findFirst().get());
		

	}

}
