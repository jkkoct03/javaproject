package com.interview.sorting;

public class BubbleSorting {
    public static void main(String[] args) {
        int [] A = {32,3,5,45,6,7,7,83,25,54,656,755,21};
        sortBubble(A);
        for(int i: A){
            System.out.print(i+" ");
        }
    }

    private static void sortBubble(int[] a) {
         for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
         }
    }
}
