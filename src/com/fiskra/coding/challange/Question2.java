package com.fiskra.coding.challange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
/**
 * To find fibonacci numbers, memoization technique is considered when space is concern.
 * 
 * @author fiskra
 *
 */
public class Question2 {
	
public static Map<Integer,Integer> fiboMap = new HashMap<Integer, Integer>(); 
	
	public static void main(String[] args) {
	   
	   System.out.println(fibonacciAverage(5)); // What should this print?
		
	}

	/**
	 * First convert list to Intstream and then call average.
	 * @param n
	 * @return
	 */
	public static OptionalDouble fibonacciAverage(int n) {
		fibonacci(n);
		List<Integer> values = new ArrayList<Integer>(fiboMap.values());
		
		return values.stream().mapToInt(Integer::intValue).average();
	}
	
	// fib (n) = fib(n-1) + fib(n-2);
	
	public static int fibonacci(int n){
		if(n == 1)
			return 1;
		if(n == 0)
			return 1;
		
		if(fiboMap.containsKey(n))
			return fiboMap.get(n);
		
		fiboMap.put(n, fibonacci(n-1)+fibonacci(n-2));
		return fiboMap.get(n);
		
	}

}
