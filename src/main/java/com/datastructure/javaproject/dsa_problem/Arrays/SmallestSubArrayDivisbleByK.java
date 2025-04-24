package com.datastructure.javaproject.dsa_problem.Arrays;

import java.util.HashMap;

public class SmallestSubArrayDivisbleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, 1);  // Handle case where prefixSum itself % k == 0

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            int mod = prefixSum % k;

            // Handle negative mods (Java's % can be negative)
            if (mod < 0) mod += k;

            count += modMap.getOrDefault(mod, 0);
            modMap.put(mod, modMap.getOrDefault(mod, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println("Number of subarrays divisible by " + k + ": " + subarraysDivByK(arr, k));
    }
}
