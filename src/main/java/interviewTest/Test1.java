package interviewTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student1 {
    public int id;
    public String name;
 
    public Student1(String name, int id) {
        this.name = name; 
        this.id = id;
    }
 
    public int hashCode() {
        return this.id;
    }
 
    public String toString() {
        return "Student: " + this.name + "@" + Integer.toHexString(hashCode());
    }
 
}
 
public class Test1 {
 
    public static void main(String[] args) {

   String name = "Jay Kishan Kumar";
        String[] n = name.split(" ");
      //  List<String> list = Arrays.asList(n);
        name.chars().mapToObj(ch -> (char) ch).forEach(System.out::println);
        Map<String,Integer> map = Arrays.stream(name.split(" ")).collect(Collectors.toMap(Function.identity(), String::length));
        
        System.out.println(map);


    // HashSet<Student1> studentList = new HashSet<>();
 
    // Student1 st1 = new Student1("Nimit", 1);
    // Student1 st2 = new Student1("Rahul", 3);
    // Student1 st3 = new Student1("Nimit", 1);
    // studentList.add(st1);
    // studentList.add(st2);
    // studentList.add(st3);
 
    // System.out.println(studentList.size()); // 2
 
    // st1.id = 3;
    // System.out.println(studentList.size());  // 2
   }
}
