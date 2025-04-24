package com.datastructure.javaproject.dsa_problem.Arrays;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowSize {
    public static void main(String[] args) {
        int [] arr = {2, 3, 1, 2, 4, 3, 7};
        int target = 7;
        int min = Integer.MAX_VALUE;
        int count = 1;
        
    }

    static void bfApproch() {
        int [] arr = {7, 2, 3, 1, 2, 4, 3, 7};
        int target = 7;
        int min = Integer.MAX_VALUE;
        int count = 1;
        for(int i=0;i<arr.length;i++) {
            int sum = arr[i];
            if(sum >= target) {
                min = Math.min(min, count);
                sum = 0;
                break;
            }
            for(int j=i+1;j<arr.length;j++) {
                sum += arr[j];
                count++;
                if(sum >= target) {
                    min = Math.min(min, count);
                    sum = 0;
                    count = 1;
                    break;
                }
            }
        }

        System.out.println(min);
    }
}
