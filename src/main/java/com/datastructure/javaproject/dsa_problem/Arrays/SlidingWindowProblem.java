package com.datastructure.javaproject.dsa_problem.Arrays;

public class SlidingWindowProblem {
    public static void main(String[] args) {
       int arr[] = {5, -5, -3, -2, 8, 7, 6, 4, -1};
       int K = 3;
       System.out.println(slidingWindowSol(arr, K, arr.length));
      //slidingWindowSol(arr, K, arr.length);
    }

    private static int slidingWindowSol(int[] arr, int k, int n) {

        int [] preSum = new int[n];
        int max = 0;
        preSum[0] = arr[0];
        for(int i=1;i<n;i++) {
            preSum[i] = preSum[i-1] + arr[i];
        }

        // for(int num : preSum) {
        //     System.out.print( num +" ");
        // }

        for(int i=0;i<n-k-1;i++) {
            max = Math.max(max, preSum[i+k] - preSum[i]);
        }

        return max;
        // int max = 0;
        // int sum = 0;

        // for(int i=0;i<k;i++) {
        //     sum += arr[i];
        // }
        // max = sum;

        // for(int i=k;i<n;i++) {
        //     sum += arr[i]-arr[i-k];
        //     max = Math.max(max, sum);
        // }

        // return max;

        // int max = 0;
        // for(int i=0;i<n-k;i++){
        //     int j=i; // 0
        //     int sum = 0;
        //     while(j < i+k){ // 0+3-1= 2
        //         sum = sum + arr[j++];
        //     }
        //     max = Math.max(max, sum);
        // }

        // return max;
    }

    
}
