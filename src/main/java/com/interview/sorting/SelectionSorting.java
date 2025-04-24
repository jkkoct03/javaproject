package com.interview.sorting;

public class SelectionSorting {
    public static void main(String[] args) {
        int [] A = {63,22,67,1,4,6,9,34,56,24,64,98};
        selectionSort(A);
        for(int i: A) {
            System.out.print(i+" ");
        }
    }

    private static void selectionSort(int [] A) {
        for(int i=0;i<A.length-1;i++){
            int min = i;
            for(int j=i+1;j<A.length;j++) {
                if(A[min]>A[j]) {
                   min = j;
                }
            }
            int temp =A[i];
            A[i] = A[min];
            A[min] = temp;
        }

    }

}
