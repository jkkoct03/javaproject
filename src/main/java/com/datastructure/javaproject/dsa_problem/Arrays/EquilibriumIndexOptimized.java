package com.datastructure.javaproject.dsa_problem.Arrays;

public class EquilibriumIndexOptimized {
    public static int findEquilibrium(int[] arr) {
        int totalSum = 0, leftSum = 0;
        
        // Step 1: Compute total sum of the array
        for (int num : arr) {
            totalSum += num; // 37
        }

        // Step 2: Traverse the array to check equilibrium condition
        for (int i = 0; i < arr.length; i++) {
            // Compute right sum by subtracting arr[i] from total sum
            int rightSum = totalSum - leftSum - arr[i];
            // Check if left sum equals right sum
            if (leftSum == rightSum) {
                return i; // Found equilibrium index
            }

            // Update left sum
            leftSum += arr[i]; // leftSum = leftSum+arr[i]
            System.out.println("");
        }

        return -1; // No equilibrium index found
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println("Equilibrium Index: " + findEquilibrium(arr));
    }
}

