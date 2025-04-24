package com.datastructure.javaproject.dsa_problem.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
       int [] A = {4,7,3,7,7,3,4,4,7,7,7,7,7};
       int n = A.length;
       System.out.println(majorityElement(A, n));
    }

    private static int majorityElement(int[] a, int n) {
        int candidate = a[0];
        int increament = 1;
        for(int i=1;i<n;i++) {
            if(candidate == a[i]) {
                increament++;
            } else {
                increament--;
            }
            if(increament == 0) {
                candidate = a[i];
                increament = 1;
            }
        }
        increament = 0;
        for(int i=0;i<n;i++) {
            if(candidate ==a[i]) {
                increament++;
            }
        }
        if(increament > n/2) {
            return candidate;
        } else {
            return -1;
        }
    }


}
