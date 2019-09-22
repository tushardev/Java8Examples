package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by tushar on 8/11/2018.
 */
public class StreamWithMap {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> list2 = Arrays.asList(2,4,6,8);
        List<Integer> list3 = Arrays.asList(3,5,7,9);

        List<List<Integer>> list = Arrays.asList(list1,list2,list3);
        System.out.println(list);

        /* Passing lambda function to map function */
        System.out.println("Printing Size by Lambda in map");
        list.stream()
                .map(l -> l.size())
                .forEach(System.out::println);

        /* create a function and pass to map method */
        System.out.println("Printing Size by function interface instance in map");
        Function<List<?>, Integer> size = List::size;

        /* Passing instance of function interface to map function */
        list.stream()
                .map(size)
                .forEach(System.out::println);


        /* create flat mapper now. Flatmapper returns Stream */
        Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();


        /* Print streams of lists by passing flat mapper to map method */
        System.out.println("Printing streams of lists by passing flat mapper in map");
        list.stream()
                .map(flatmapper)
                .forEach(System.out::println);


        /* Print streams of lists by passing flat mapper to flat map method */
        System.out.println("Printing streams of lists by passing flat mapper in flatmap");
        list.stream()
                .flatMap(flatmapper)
                .forEach(System.out::println);
    }
}

/* Above program shows use of map and flatmap functions on the streams.

In simple words, the map() is used to transform one object into other by applying a function.

It takes java.util.function.Function FI as input.




*/