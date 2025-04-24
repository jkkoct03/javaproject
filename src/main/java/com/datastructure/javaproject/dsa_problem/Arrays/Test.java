package com.datastructure.javaproject.dsa_problem.Arrays;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
        int [] A = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int target = 11;
        int[] R = uniqueCount(A);

        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        

            String str = "My name is Jay";//each character frequency

            String [] s = str.split(" ");

            Map<Character, Long> frequencyChar = Stream.of(s).collect(Collectors.groupingBy(e->e, Collectors.counting()));
            System.out.println(frequencyChar);
        }

    public static int[] uniqueCount(int[] A) {
        int i=0, j=1;
        while(i<j && j < A.length) {
            if(A[i] != A[j]) {
                A[i] = A[j];
                i++;
            } 
            j++;
        }

        return A;
    }    

    public static int[] targetSum(int[] A, int target) {
    int i=0, j=A.length-1;
    while(i<j){
        int sum = A[i] + A[j];      
        if(sum == target) {
            return new int[] {i,j};
        } else if(sum > target) {
            j--;
        } else if(sum <target) {
            i++;
        }
    }

     return new int[] {0,0};
   }




















    // public int[] solve1(int[][] A) {
    //     Stack<Integer> st = new Stack<>();
    //     int[] arr = new int[A.length];
    //     Map<Integer, Integer> freq = new HashMap<>();
    //     Map<Integer, Stack<Integer>> group = new HashMap<>();
    //     int maxFreq = 0;
    //     for(int i=0;i<A.length;i++) {
    //         if(A[i][0] == 1) {
    //             int f = freq.getOrDefault(A[i][1], 0) + 1;
    //             freq.put(A[i][1], f);
    //             group.computeIfAbsent(f, z -> new Stack<>()).push(A[i][1]);
    //             maxFreq = Math.max(maxFreq, f);
    //             arr[i] = -1;
    //         } else {
    //           int popped = group.get(maxFreq).pop();
    //           freq.put(popped, freq.get(popped) - 1);
    //           if (group.get(maxFreq).isEmpty()) {
    //             maxFreq--;
    //           }
    //           arr[i] = popped;
    //         }
    //     }
    //     return arr;
    // }

    // public static int solve(String A) {
    //     Stack<Character> st = new Stack<>();
    //     char[] ch = A.toCharArray();
    //     for(int i=0;i<ch.length;i++) {
    //         if(!st.empty() && ch[i] == ')') {
    //             if(st.peek() == '(')
    //                 st.pop();
    //             else {
    //                 return 0;
    //             }    
    //         } else if(!st.empty() && ch[i] == '}') {
    //             if(st.peek() == '{')
    //                 st.pop();
    //             else {
    //                 return 0;
    //             }    
    //         } else if(!st.empty() && ch[i] == ']' ) {
    //             if(st.peek() == '[') 
    //                 st.pop();
    //             else {
    //                 return 0;
    //             }    
    //         } else {
    //             st.push(ch[i]);
    //         }    
    //     }
    //     if(st.empty()) {
    //         return 1;
    //     }

    //     return 0;
    // }
}