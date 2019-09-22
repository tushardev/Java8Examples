package com.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamResult {

	public static void main(String[] args) {
		
		Consumer<String> c1 = s -> System.out.println(s);
		
		List<String> newList = new ArrayList<>();
		
		/* create stream using static method of Stream interface */
		Stream<String> stream1 = Stream.of("one","two","three","four","five");
		
		/* create stream using static method of Stream interface */
		Stream<String> stream2 = Stream.of("one","two","three","four","five");
		
		/* create predicate using lambda expression */
		Predicate<String> p3 = s -> s.length() > 3;
		
		/* create another predicate using equality static method of Predicate interface*/
		Predicate<String> p4 = Predicate.isEqual("three");
		
		
		/* Here all operations on stream are intermediate. Hence no operation will be triggered */
		stream1.peek(c1).filter(p3.or(p4)).peek(newList::add);
		
		System.out.println("Intermediate Operations Test");
		System.out.println("Size of new list: " + newList.size());
		
		
		/* Here we have foreach as final operation which will trigger the data processing on stream */
		stream2.peek(c1).filter(p3.or(p4)).forEach(newList::add);
		
		System.out.println("Final Opearation Test");
		System.out.println("Size of new list: " + newList.size());
		
	}

}

/****
 * We have performed two types of operations on Stream. first was all operations were intermediatery.
 * It didnt triggered the data processing.
 * But when we add final operation - data processing is triggered.
 * 
 * intermediatery operations return another stream. We can chain intermediatery operations to refine data.
 * In the end we have to provide final operation to trigger all the chained operations to get the result.
 */

