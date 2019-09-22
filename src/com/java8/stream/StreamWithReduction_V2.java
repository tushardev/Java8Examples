package com.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by tushar on 9/24/2018.
 */
public class StreamWithReduction_V2 {

    public static void main (String[] args) {

        /* Problem with max reduction operation by using identity value.
           As we have provided 0 as identity value it uses that while considering max value
           Expected result is -10 but it gives 0 */
        List<Integer> list = Arrays.asList(-10, -10);
        Integer maxVal = list.stream().reduce(0, Integer::max);
        //System.out.println(maxVal);

        /* Problem with identity value in max when stream is empty.
           When stream is empty we cannot have any value as max value but identity value is returned as max value
            This is not expected*/
        List<Integer> list2 = Arrays.asList();
        Integer maxEmpty = list2.stream().reduce(0, Integer::max);
        //System.out.println(maxEmpty);

        /* Solution is using reduce function which returns Optional object. We don't have to give identity value  */
        List<Integer> list3 = Arrays.asList(-10, -10, -20);
        Optional<Integer> max = list3.stream().reduce(Integer::max);
        //System.out.println(max);

        /* Reduce max operation for empty stream with Optional value */
        List<Integer> list4 = Arrays.asList();
        Optional<Integer> max1 = list4.stream().reduce(Integer::max);
        //System.out.println(max1);

        if(max1.isPresent()) {
            System.out.println("Result is not Empty");
        } else {
            System.out.println("Result is Empty");
        }


        /* Another option is using max function on stream. max function takes Comparator as argument
           and returns optional value */
        List<Integer> list5 = Arrays.asList(10, -10);
        Optional<Integer> maxFunVal = list5.stream().max(Comparator.naturalOrder());
        System.out.println(maxFunVal);

        if(maxFunVal.isPresent()) {
            System.out.println(maxFunVal.get());
        }
    }
}

/* Here we have done reduction operation to get max value without using identity element in reduce method
Also we have option of using max method which takes comparator as argument
*/