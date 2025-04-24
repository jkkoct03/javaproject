package com.interview.sorting;

public class InsertionSorting {
    public static void main(String[] args) {
        int [] A = {63,22,67,1,4,6,9,34,56,24,64,98};
        insertionSort(A);
        for(int i: A) {
            System.out.print(i+" ");
        }
    }

    private static void insertionSort(int[] a) {
        for(int i=1;i<a.length;i++) {
            int temp = a[i];
            int j = i-1;
            while(j>=0 && a[j] > temp) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
}
