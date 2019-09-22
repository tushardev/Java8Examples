package com.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaPracticeTwo {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("**", "****", "*", "***");
		List<String> listLambda = Arrays.asList("**", "****", "*", "***");
		List<String> listLambda1 = Arrays.asList("**", "****", "*", "***");
		
		/* Without Lambda */
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		list.sort(comp);
		System.out.println(list);
		
		
		/* With Lambda */
		Comparator<String> compLambda = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());
		listLambda.sort(compLambda);
		System.out.println(listLambda);
		
		
		/* Lambda without argument type */
		Comparator<String> compLambda1 = (o1, o2) -> Integer.compare(o1.length(), o2.length());
		listLambda1.sort(compLambda1);
		System.out.println(listLambda1);

	}

}

/*** Here we have 2 arguments 
 * Also no need to give type of argument
 * */
 