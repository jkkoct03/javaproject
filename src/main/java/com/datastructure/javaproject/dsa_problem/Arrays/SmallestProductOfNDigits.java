package com.datastructure.javaproject.dsa_problem.Arrays;

import java.util.Scanner;
// Smallest number with digits product of n
public class SmallestProductOfNDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    
    private static int solution(int N) {
        String digits = "";
        for (int i = 9; i > 1; i--) {
            while (N % i == 0) {
                N = N / i;
                digits = i + digits;
            }
        }
        if(N != 1) {
           return -1;
        } else {
            return Integer.parseInt(digits);
        }
    }

}
