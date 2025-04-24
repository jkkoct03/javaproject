package com.datastructure.javaproject.interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        
    }
}

@FunctionalInterface
interface InnerInterfaceTest1 extends InnerInterfaceTest2 {
    public void m1();
}

@FunctionalInterface
interface InnerInterfaceTest2 {
    public void m1();

    default void m2() {

    }

    default void m3() {
        
    }
}
