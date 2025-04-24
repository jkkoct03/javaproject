package com.corejava.javastream;

import java.util.Arrays;
import java.util.List;

public class StreamAPIvsParellel {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Serial Stream:");
        numbers.stream().forEach(num -> {
            slowPrint(num);
        });

        System.out.println("Parallel Stream:");
        numbers.parallelStream().forEach(num -> {
            slowPrint(num);
        });
    }

    private static void slowPrint(int num) {
        try {
            Thread.sleep(1000); // wait 1 second
            System.out.println("Processed: " + num + " by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
