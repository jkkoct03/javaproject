package com.datastructure.javaproject.dsa_problem.Arrays;

public class SmallestSubarrayWithSum {
    public static int minSubArrayLen(int target, int[] arr) {
        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            while (windowSum >= target) {
                minLen = Math.min(minLen, end - start + 1); // 3-0
                windowSum -= arr[start++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("Smallest Length: " + minSubArrayLen(target, arr));
    }
}

