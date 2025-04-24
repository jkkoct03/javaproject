package com.interview.stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);

        st.pop();
        st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // Exception in thread "main" java.util.EmptyStackException
        // whenever no element on stack then and try to pop out then it will throw java.util.EmptyStackException
        st.pop();
        // peek() is top element return but not remove for stack
        if(3 == st.peek()){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        // if you are using search() then either return same value or -1;
        System.out.println(st.search(6));
        System.out.println(st);
    }
}
