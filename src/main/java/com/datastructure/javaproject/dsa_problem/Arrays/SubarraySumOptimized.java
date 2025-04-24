package com.datastructure.javaproject.dsa_problem.Arrays;

import java.util.HashMap;

public class SubarraySumOptimized {
    public static int countSubarrays(int[] arr, int S) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0, count = 0;

        // Initialize with sum 0 (to handle case where subarray starts at index 0)
        prefixSumMap.put(0, 1);

        for (int num : arr) {
            prefixSum = prefixSum + num; // Compute prefix sum
            
            // If (prefixSum - S) exists in map, add its frequency to count
            if (prefixSumMap.containsKey(prefixSum - S)) {
                count += prefixSumMap.get(prefixSum - S);
            }
            
            // Update the map with the current prefixSum
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int S = -10;
        System.out.println("Number of subarrays: " + countSubarrays(arr, S));
    }
}

