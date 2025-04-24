package com.datastructure.javaproject.dsa_problem.Arrays;

public class SubarraySumBruteForce {
    public static int countSubarrays(int[] arr, int S) {
        int n = arr.length, count = 0;
        
        // Iterate over all possible starting points
        for (int i = 0; i < n; i++) {
            int sum = 0;
            System.out.println("");
            // Iterate over all possible end points
            for (int j = i; j < n; j++) {
                sum += arr[j];
                // If subarray sum equals S, count it
                if (sum == S) {
                    System.out.print(i + " -- " + j + " ");
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 4, -10, 5}; 
                  // 1, 3, 6, 10, 15, 16, 20, 10, 15
        int S = 5;
        System.out.println("Number of subarrays: " + countSubarrays(arr, S));
    }
}
