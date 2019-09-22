package com.java8.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/***
 ** Created by Tushar on 30/1/19
 **/
public class OptionalTest {

    public static void main(String[] args) {

        Stream<Integer> ints = Stream.of(1,2,3,4);
        Optional minInt = ints.min(Comparator.comparing(Integer::byteValue));

        /* Call isPresent and pass an function which will process the value if present */
        minInt.ifPresent(System.out::println);


        Stream<Integer> emptyInts = Stream.empty();
        Optional emptyInt = emptyInts.min(Comparator.comparing(Integer::byteValue));

        emptyInt.ifPresent(System.out::println);


        Stream<String> nameStr = Stream.of("Tushar", "Kadale");
        Optional<String> str = nameStr.findFirst();

        List<String> nameList = new ArrayList<>();

        /* If optional value is present add it in list. It will return Optional boolean value based on result */
        Optional<Boolean> isAdded = str.map(nameList::add);

        isAdded.ifPresent(System.out::println);

        System.out.println("----Printing The Name List----");
        nameList.stream().forEach(System.out::println);


        Stream<String> jobStr = Stream.of("Developer", "QA", "Support");

        Predicate<String> predicate = s -> s.length() > 15;
        Stream<String> filList = jobStr.filter(predicate);

        Optional<String> firstJob = filList.findFirst();

        /* If the optional object don't have any value then return something default */
        String value = firstJob.orElse("No Jobs Filtered");

        System.out.println("---Printing Filtered Job----");
        System.out.println(value);

    }

}