package com.interview;

import java.util.HashMap;
import java.util.Map;

class Student

{

    String name;

    int id;
 
    Student(String name, int id)

    {

        this.name = name;

        this.id = id;

    }
 
    @Override

    public int hashCode()

    {

        return this.id;

    }
 
    @Override

    public boolean equals(Object obj)

    {

        if(this == obj)

            return true;
 
        if(obj == null || obj.getClass()!= this.getClass())

            return false;
 
        Student Student = (Student) obj;

        return (Student.name.equals(this.name) && Student.id == this.id);

    }
 
    @Override

    public String toString() {

        return "Student: " + this.name + "@" + Integer.toHexString(hashCode());

    }

}
 
public class EqualAndOverrideConcept {

    public static void main(String[] args)

    {
 
        Student g1 = new Student("aditya", 1);

        Student g2 = new Student("aditya", 1);
 
        Map<Student, String> map = new HashMap<Student, String>();

        map.put(g1, "CSE");

        map.put(g2, "IT");
 
        for(Student student : map.keySet())

        {

            System.out.println("Key : " + student);

            System.out.println("Value : " + map.get(student));

        }

    }

}
