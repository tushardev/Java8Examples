package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by tushar on 9/23/2018.
 */
public class StreamWithConsumers {

    public static void main(String[] args) {

        List<String> sourceList = Arrays.asList("Tushar", "Pallavi", "Vedika");
        List<String> targetList = new ArrayList<>();

        /* Write a consumer to populate target list by provided element */
       Consumer<String> c1 = s -> targetList.add(s);

        /* Write a consumer to print the elements provided */
        Consumer<String> c2 = s -> System.out.println(s);

        /* Create a stream on Source List and pass the consumers with chaining */
        sourceList.stream().forEach(c1.andThen(c2));

        System.out.println("<-------------------------->");

        /* Lets confirm that above operation has added elements in Target List */
        targetList.forEach(c2);

    }
}

/* We have defined Consumers to perform 2 operations.
Then we have created a stream on Source and passed these consumers to foreach operation.
The operations will be performed on each element of source and we will get desired result
 */

