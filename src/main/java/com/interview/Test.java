package com.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    //You are given a list of integers representing stock prices on consecutive days. 
    //Your task is to implement a method `maxProfit()` to find the maximum profit that can be achieved by buying and selling stocks on these days. 
    //However, you are allowed to make at most 
    //one transaction (i.e., buy one and sell one share of the stock), and you cannot sell a stock before you buy one.

    public static void main(String[] args) {
	    int[] stockPrices = new int[]{7, 1, 5, 3, 6, 4};
	    //Expected answer is : 5
	    
	    int maxProfit = getMaxProfit(stockPrices);
		System.out.println("Max profit is : "+maxProfit);

         List<String> words = Arrays.asList("cat", "dog", "apple","apple","apple", "cat", "bat", "car", "elephant");

        Map<Integer, List<String>> groupedByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
            System.out.println(groupedByLength);

        // Map<Character, List<String>> groupedByAlphabet = words.stream()
        //     .sorted(Comparator.comparing(e -> e)).collect(Collectors.groupingBy(word -> word.charAt(word.length()-1), Collectors.collectingAndThen(                          // Then...
        //     Collectors.toList(),                               // Collect to list
        //     list -> list.stream()
        //                  .sorted()                             // Sort the list
        //                  .collect(Collectors.toList()))));
        Map<Character, List<String>> groupedByAlphabet = words.stream()
            .collect(Collectors.groupingBy(
                word -> word.charAt(0), // Group by last character
                Collectors.collectingAndThen(
                    Collectors.toList(),                // Collect group
                    list -> list.stream()
                                .sorted()              // Sort group alphabetically
                                .collect(Collectors.toList())
                )
            ));
            System.out.println(groupedByAlphabet);

        //remove duplicate
        List<String> uniqueElement =  words.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueElement);

        // give duplicate elements
        List<String> duplicateElement =  words.stream().filter(ele -> Collections.frequency(words, ele) > 1).collect(Collectors.toList());
        System.out.println(duplicateElement);
	}
	
	static int getMaxProfit(int[] stockPrices){
        int max = 0;
        for(int i=1;i<stockPrices.length;i++) {
                max = Math.max(max, stockPrices[i] - stockPrices[i-1]);
        }
	    return max;
	}
}
