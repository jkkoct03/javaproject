package com.interview;

import java.util.ArrayList;
import java.util.List;

public class ImmutableTest {
    
    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("SST");
        Person1 p = new Person1("Rahul", subjects);
        System.out.println(p.getName() + " " + p.getSubject().get(0));
        // p.getSubject().add("Science");
        System.out.println(p.getName() + " " + p.getSubject().get(1));
    
    }
    
}

final class  Person1{
    private final String name;
    List<String> subjects = new ArrayList<>();

    public Person1(String name,List<String> subjects){
        super();
        this.name = name;
        this.subjects = new ArrayList<>(subjects);
    }

    public String getName() {
        return name;
    }

    public List<String> getSubject() {
        return new ArrayList<>(subjects);
    }

}

// final can't override