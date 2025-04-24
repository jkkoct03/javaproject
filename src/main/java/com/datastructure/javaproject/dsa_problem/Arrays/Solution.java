package com.datastructure.javaproject.dsa_problem.Arrays;

import java.util.HashMap;
import java.util.Map;

import scala.collection.mutable.Stack;

class Solution {
    
    Stack<Map<Integer, Integer>> minStack = new Stack<>();
    public void push(int x) {
         Map<Integer, Integer> minStackMap = new HashMap<>();
        if(minStack.isEmpty()) {
            minStackMap.put(x, x);
        } else {
            int currentMin = minStack.top().values().iterator().next(); // get previous min
            minStackMap.put(x, Math.min(x, currentMin));
        }
        minStack.push(minStackMap);
        System.out.println(minStack);
    }

    public void pop() {
        if(minStack.isEmpty())
            return;
        minStack.pop();    
    }

    public int top() {
        if(minStack.isEmpty())
            return 0;
        else {
            Map<Integer, Integer> val =   minStack.top();
            System.out.println(val);
            return 0;
        }
   
    }

    public int getMin() {
         if(minStack.isEmpty())
            return 0;
        else {
            Map<Integer, Integer> val =   minStack.top();
            System.out.println(val);
            return 1;
        }
    }
}

