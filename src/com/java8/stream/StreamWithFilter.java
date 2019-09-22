package com.java8.stream;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamWithFilter {

	public static void main(String[] args) {
		
		/* Use below consumer at all places to print the string */
		Consumer<String> c1 = s -> System.out.println(s);
		
		/* create stream using static method of Stream interface */
		Stream<String> firstStream = Stream.of("one","two","three","four","five");
		
		/* below code will print the stream. It will also close the stream i.e. you can not use this stream further */
		firstStream.forEach(c1);


		
		/* create new stream */
		Stream<String> stream = Stream.of("one","two","three","four","five");
		
		/* create predicate using lambda expression */
		Predicate<String> p1 = s -> s.length() > 3;
		
		/* Filter the stream using above predicate. Chain next operation of printing on result of filtered stream */
		stream.filter(p1).forEach(c1);
		


		/* create new stream */
		Stream<String> streamNew = Stream.of("one","two","three","four","five");
		
		/* create predicate using lambda expression */
		Predicate<String> p3 = s -> s.length() > 3;
		
		/* create another predicate using equality static method of Predicate interface*/
		Predicate<String> p4 = Predicate.isEqual("three");
		
		/* Filter the stream by chaining 2 predicates with "and" method. Chain next operation of printing on result of filtered stream */
		streamNew.filter(p3.and(p4)).forEach(c1);
		
		
	}

}













