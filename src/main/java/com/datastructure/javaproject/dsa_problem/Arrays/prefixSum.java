package com.datastructure.javaproject.dsa_problem.Arrays;

public class prefixSum {
    public static void main(String[] args) {
        int[] A = { 3, -2, 8, -5, 4, 0, 1 }; // 3, 1, 9
        for (int a : A) {
            System.out.print(a + " ");
        }

        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        
    }
}
