package interviewTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Test4 {
    public static void main(String[] args) {
        Student st1 = new Student(1, "A", 31);
        Student st2 = new Student(2, "B", 24);
        Student st3 = new Student(3, "C", 26);
        Student st4 = new Student(4, "D", 41);
        Student st5 = new Student(5, "E", 50);

        List<Student>  listStudent = Arrays.asList(st1,st2,st3,st4,st5);

        List<Student> sortStudent = listStudent.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        sortStudent.stream().map(st -> st).forEach(System.out::println);
        // for(Student s : sortStudent) {
        //     System.out.println(s.getName() + "  -- " + s.getAge());
        // }

        Optional<String> op2 = Optional.ofNullable(null);

        System.out.println("Optional 2: "+ op2);

        Map<Employee,Integer> map = new HashMap<>();

        Employee a1 = new Employee();

        a1.setName("ABCD");

        map.put(a1,10000);

        a1.setName("ABCDE");

        System.out.println(map.get(a1));

        String str = "asfAGafeYwev";
        str.chars().mapToObj(ch ->(char)ch).sorted(Comparator.comparing(ch ->(char)ch).reversed()).forEach(System.out::print);
    }


}

class Employee {

   private String name;

   private Double Salary;

   public String getName() {
    return name;
   }

   public void setName(String name) {
    this.name = name;
   }

   public Double getSalary() {
    return Salary;
   }

   public void setSalary(Double salary) {
    Salary = salary;
   }



}
class Student {
   private int id;
   private String name;
   private int age;

   
   public Student(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
}
   public int getId() {
    return id;
   }
   public void setId(int id) {
    this.id = id;
   }
   public String getName() {
    return name;
   }
   public void setName(String name) {
    this.name = name;
   }
   public int getAge() {
    return age;
   }
   public void setAge(int age) {
    this.age = age;
   }

   
}
