package com.datastructure.javaproject.dsa_problem.Arrays;


interface one {

    static void m1(){}
    default void  m2(){}
}

class Two implements one{} 

class Three implements one{}

public class TestFunction {
    public static void main(String[] args) {
        one test1 = new Two();
        one test2 = new Three();
        System.out.println(test1 instanceof one); //true
        System.out.println(test2 instanceof one); //true
        System.out.println(test1.getClass().equals(test2.getClass())); //false
        System.out.println(test1.getClass());
    }
}
