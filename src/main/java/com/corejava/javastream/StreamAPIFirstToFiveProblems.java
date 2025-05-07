package com.corejava.javastream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIFirstToFiveProblems {

    // Given a string, find the first character that does not repeat using Java 8
    // Stream API.

    public static void main(String[] args) {
        String str = "jayaykklj";
        // Optional<Character> ch = str.chars().mapToObj(c -> (char)
        // c).collect().findFirst();
        // LinkedHashMap<Object, Long> map = str.chars().mapToObj(c -> (char)
        // c).collect(Collectors.groupingBy(c->c, LinkedHashMap::new,
        // Collectors.counting()));
        // System.out.println(map.entrySet().stream().filter(c->c.getValue() ==
        // 1).findFirst().get().getKey());

        // for(int i=0;i<str.length();i++){
        // if(str.indexOf(str.charAt(i))== str.lastIndexOf(str.charAt(i)))
        // System.out.println(str.charAt(i));
        // }

        Character ch = str.chars().mapToObj(c -> (char) c).filter(idx -> str.indexOf(idx) == str.lastIndexOf(idx))
                .findFirst().orElse(null);
        System.out.println(ch);

        // Given a list of integers, return a list containing only the even numbers
        // using Stream API.
        int[] A = { 1, 2, 4, 5, 7, 4, 8, 3, 37, 8, 9, 3, 6, 8, 10 };

        List<Integer> evenNumbers = Arrays.stream(A) // IntStream
                .filter(num -> num % 2 == 0)
                .boxed() // Convert int to Integer
                .collect(Collectors.toList());

        // System.out.println(evenNumbers);

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", 55000, 28),
                new Employee(2, "Bob", "IT", 85000, 32),
                new Employee(3, "Charlie", "IT", 120000, 45),
                new Employee(4, "David", "Sales", 40000, 25),
                new Employee(5, "Eva", "HR", 75000, 29),
                new Employee(6, "Frank", "IT", 200000, 38),
                new Employee(7, "Grace", "Finance", 99000, 41),
                new Employee(8, "Helen", "Sales", 65000, 31),
                new Employee(9, "Ian", "Finance", 100000, 39),
                new Employee(10, "Jack", "HR", 30000, 24),
                new Employee(11, "Ian", "Finance", 210000, 39));

        // Given a list of Employee objects, filter out the employees who earn more than
        // ₹100,000.

        List<Employee> empList = employees.stream().filter(sal -> sal.getSalary() > 100000)
                .collect(Collectors.toList());
        // System.out.println(empList);

        // Given a list of employees, group them by their department name using Stream.
        Map<String, List<Employee>> empListGroupByDepart = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
        // System.out.println(empListGroupByDepart);

        // Count the number of employees in each department.
        Map<String, Long> depCountOfEmp = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        // System.out.println(depCountOfEmp);

        // Sort the list of employees by salary in descending order
        List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println(sortedEmployees);

        // From a list of salaries, find the second highest salary using Stream API.
        Optional<Employee> secHighSalaryEmp = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .distinct().skip(1).findFirst();
        System.out.println(secHighSalaryEmp);

        // Calculate the average salary of all employees.
        double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);

        //Find the name of the employee with the highest salary
        Optional<Employee> sortedEmp = employees.stream().sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .findFirst();
                System.out.println(sortedEmp);
        //Convert a list of strings into a single comma-separated string
        String res = Arrays.asList("Jay", "Charleeeee", "Akhil").stream().collect(Collectors.joining(", "));
        System.out.println(res);
        //Given a List<List<Integer>>, flatten it to a single List<Integer> using Stream.
        List<Integer> result = Arrays.asList(Arrays.asList(1,2,3,4,5,6,7,8)).stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(result);
        // Count occurrences of each character in a string using Stream.
        String st = "My name is Jay and live in Bangalore";
        Map<Character, Long> returnFreq = st.chars().mapToObj(c->(char) c).filter(d->d != ' ').collect(Collectors.groupingBy(e->e, Collectors.counting()));
        System.out.println(returnFreq);
        //Remove duplicate elements from a list using Stream API
        int[] A1 = { 1, 2, 4, 5, 7, 4, 8, 3, 37, 8, 9, 3, 6, 8, 10 };
        //List<Integer> list = Arrays.asList(A1);
        List<Integer> uniqueList = Arrays.stream(A).boxed().distinct().collect(Collectors.toList());
        for(int i: uniqueList){
            System.out.print(i + " ");
        }

        // Partition a list of integers into two groups: odd and even numbers.
        Map<Boolean, List<Integer>> returnResulting = Arrays.stream(A).boxed().distinct().collect(Collectors.partitioningBy(e->e%2==0));
        System.out.println(returnResulting);

        //Given a list of strings, find all palindrome strings using Stream API
        
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee e = (Employee) o;
        return Double.compare(e.salary, salary) == 0 &&
                Objects.equals(name, e.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    // Optional: toString() for printing
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
