package com.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tushar on 9/24/2018.
 */
public class StreamWithReduction {

    public static void main (String[] args) {

        /* Simple Reduction using lambda expression */
        List<Integer> list = Arrays.asList(10, 20, 20);

        Integer sum = list.stream().reduce(0, (i1, i2) -> i1+i2);
        Integer sum1 = list.stream().reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println(sum1);


        /* Corner case 1 - Empty Stream. Here Identity element will be returned as sum */
        List<Integer> list1 = Arrays.asList();

        Integer sumEmpty = list1.stream().reduce(0, Integer::sum);
        Integer sumEmpty1 = list1.stream().reduce(10, Integer::sum);

        System.out.println(sumEmpty);
        System.out.println(sumEmpty1);


         /* Corner case 2 - Stream with 1 element only. Here that one element combined with identity element will be the sum */
        List<Integer> list2 = Arrays.asList(10);

        Integer sumOne = list2.stream().reduce(0, Integer::sum);
        Integer sumOne1 = list2.stream().reduce(10, Integer::sum);

        System.out.println(sumOne);
        System.out.println(sumOne1);

    }
}
/* Here we have seen reduction operation. reduce method takes first argument as identity element.
Second argument is BinaryOperator. it expects 2 values to perform operation
Identity element will be used when stream is empty of has only one value
 */