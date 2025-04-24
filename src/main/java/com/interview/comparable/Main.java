package com.interview.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Alice", 85));
        students.add(new Student(1, "Bob", 95));
        students.add(new Student(2, "Charlie", 85));

        System.out.println("👉 Natural Order (rollNo):");
        Collections.sort(students);
        students.forEach(System.out::println);

        System.out.println("\n👉 Custom Order (marks):");
        students.sort(Comparator.comparingInt(s -> s.marks));
        students.forEach(System.out::println);

        System.out.println("\n👉 Custom Order (marks DESC, then name):");
        students.sort(Comparator.<Student>comparingInt(e->e.marks)
                .reversed()
                .thenComparing(p->p.marks)
         );
        students.forEach(System.out::println);
    }
}


class Student implements Comparable<Student> {
    int rollNo;
    String name;
    int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // 1️⃣ Comparable (Natural Order by rollNo)
    @Override
    public int compareTo(Student other) {
        return this.rollNo - other.rollNo;
    }

    // 2️⃣ equals() based on rollNo
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNo == student.rollNo;
    }

    // 3️⃣ hashCode() consistent with equals
    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + marks;
    }
}

