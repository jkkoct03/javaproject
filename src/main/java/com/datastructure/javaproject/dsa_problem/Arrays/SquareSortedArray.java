package com.datastructure.javaproject.dsa_problem.Arrays;

import java.util.Arrays;

public class SquareSortedArray {
    public static void main(String[] args) {
        int [] A ={-7, -3, -2, 0, 1};
        squareSortedArray(A);
    }

    static void squareSortedArray(int [] A) {
        for(int i=0;i<A.length;i++) {
            A[i] = A[i]*A[i];
        }
        print(A);
        //Arrays.sort(A);

        int i=0, j=A.length-1;
        while(i<j) {
            System.out.println(A[i] + " --- " + A[j]);
            print(A);
            if(A[i] > A[j]) {
                swap(A, i, j);
                i++;
            } else {
                j--;
            }  
        }

        print(A);
    }

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static void print(int [] A) {
        for(int i=0;i<A.length;i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }
}
