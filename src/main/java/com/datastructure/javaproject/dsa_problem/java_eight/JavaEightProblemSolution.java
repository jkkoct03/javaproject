package com.datastructure.javaproject.dsa_problem.java_eight;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaEightProblemSolution {
    public static void main(String[] args) {
      
       //Find the first non-repeated character in a String using Java 8 Stream API.
       String str = "dddaswiss";
       System.out.println(nonRepeatingCharachter(str));

       //Find duplicate elements in a list
    }


    static char nonRepeatingCharachter(String str) {
        Map<Character, Long> map = str.chars().mapToObj(c->(char)c)
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
        System.out.println(map.entrySet().stream().filter(e->e.getValue() == 1).findFirst().get().getKey());
        return map.entrySet().stream().filter(e->e.getValue() == 1).findFirst().get().getKey();
    }
}
