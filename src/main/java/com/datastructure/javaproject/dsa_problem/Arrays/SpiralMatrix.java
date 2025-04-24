package com.datastructure.javaproject.dsa_problem.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 }
        };

        System.out.println("Before Sprial Matrix: ");
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("After Sprial Matrix: ");
        sprialMatrix(arr, arr.length, arr[0].length);
    }

    private static void sprialMatrix(int[][] arr, int m, int n) {
        int rmin = 0, rmax = m - 1;
        int cmin = 0, cmax = n - 1;
        int count = 0;
        while (count < m * n) {
            // Top Boundry
            for (int col = cmin; col <= cmax && count<m*n; col++) {
                System.out.print(arr[rmin][col] + " ");
                count++;
            }
            rmin++;
            // Right Boundry
            for (int row = rmin; row <= rmax && count<m*n; row++) {
                System.out.print(arr[row][cmax] + " ");
                count++;
            }
            cmax--;
            // Bottom Boundry
            for (int col = cmax; col >= cmin && count<m*n; col--) {
                System.out.print(arr[rmax][col] + " ");
                count++;
            }
            rmax--;
            // Left Boundry
            for (int row = rmax; row <= rmin && count<m*n; row++) {
                System.out.print(arr[row][cmin] + " ");
                count++;
            }
            cmin++;
        }
    }
}
