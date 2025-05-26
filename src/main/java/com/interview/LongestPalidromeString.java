package com.interview;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestPalidromeString {
    public static void main(String[] args) {
        String st = "cbab";
        System.out.print(longestPalidrome(st));
    }


    public static String longestPalidrome(String s) {
 
        StringBuilder sb = new StringBuilder(s); // append, reverse    
        Map<String, Integer>  map =  new HashMap<>();       
        //char[] ch = str.toCharArray();
        for (int i = 0; i < sb.length(); i++) {
          // StringBuilder sb1 = new StringBuilder();
           for (int j = i + 1; j <= sb.length(); j++) {
               String sub = sb.substring(i, j);
               String reversed = new StringBuilder(sub).reverse().toString();
                if (sub.equals(reversed)) {
                    map.put(sub, sub.length());
                }
           }
       }

       String maxPalindrome = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue))
       .map(Map.Entry::getKey)
       .orElse("");

       return maxPalindrome;

   }
}
