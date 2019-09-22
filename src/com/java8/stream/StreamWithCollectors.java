package com.java8.stream;

import com.java8.model.Person;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by tushar on 9/24/2018.
 */
public class StreamWithCollectors {

    public static void main(String[] args) {

        List<Person> list = new StreamWithCollectors().getPersonList();

        /* using Filter and reduction - Finding youngest among persons having age less then 5 */
       Optional<Person> youngestPerson =  list.stream()
                .filter(p -> p.getAge() < 5)
                .min(Comparator.comparing(Person::getAge));

        //System.out.println(youngestPerson);


        /* Collect Age wise list of persons in Map */
        Map<Integer, List<Person>> ageWiseMap = list.stream()
                .filter(p -> p.getAge() > 5)
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(ageWiseMap);


        /* downstream collector for post processing - getting age wise count*/
        Map<Integer, Long> ageWiseCountMap = list.stream()
                .collect(
                        Collectors.groupingBy(Person::getAge,
                                Collectors.counting()
                        )
                );

        System.out.println(ageWiseCountMap);


          /* downstream collector for getting age wise list of first names in separate list */
        Map<Integer, List<String>> ageWiseNameMap = list.stream()
                .collect(
                        Collectors.groupingBy(Person::getAge,
                                Collectors.mapping(Person::getFirstName, Collectors.toList()
                                )
                        )
                );

        System.out.println(ageWiseNameMap);


        /* Concatenate the last names into comma separated string age wise */
        Map<Integer, String> ageWiseNameStringMap = list.stream()
                .collect(
                        Collectors.groupingBy(Person::getAge,
                                Collectors.mapping(Person::getLastName, Collectors.joining(", ")
                                )
                        )
                );

        System.out.println(ageWiseNameStringMap);
    }


    /**
     * Populate the list for operation
     * @return
     */
    private List<Person> getPersonList() {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Tushar","Kadale",34));
        list.add(new Person("Pallavi","Kadale",29));
        list.add(new Person("Vedika","Kadale",02));
        list.add(new Person("Prachi","Trivedi",01));
        list.add(new Person("Prisha","Padghan",01));
        return list;
    }
}
