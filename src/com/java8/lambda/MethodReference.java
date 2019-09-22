package com.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(100,1,10);
		List<Integer> list2 = Arrays.asList(100,1,10);
		
		/* Printing String using Consumer FI and Regular Lambda expression */
		Consumer<String> cl = s -> System.out.println(s);
		cl.accept("Tushar");
		
		
		/* Printing String using Consumer FI and Method Reference */
		Consumer<String> cmi = System.out::println;
		cmi.accept("Pallavi");
		
		
		/* Printing sorted list using FI and comparator and regular lambda expression */
		Comparator<Integer> comp1 = (i1, i2) -> Integer.compare(i1, i2);
		list1.sort(comp1);
		
		Consumer<List<Integer>> car = s -> System.out.println(s);
		car.accept(list1);
		
		
		/* Printing sorted list using FI and comparator and method reference */
		Comparator<Integer> comp2 = Integer::compare;
		list2.sort(comp2);
		
		Consumer<List<Integer>> car2 = System.out::println;
		car2.accept(list2);
	}
	
}

/***
 * We have 2 options to write lambda expression. Second one is using Method Reference.
 * As Lambda Expression type is functional interface - we can take it in FI type variable.
 * Then we can invoke methods on FI
 * Explore java.util.function package for more FIs.
 * 
 * In last example - comparator will compare list in regular order.
 * In order to sort in reverse order either write lambda expression with arguments OR reverse the list after sorting
 * 
 */
