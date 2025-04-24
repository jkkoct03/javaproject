package com.datastructure.javaproject.LambdaExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

interface IMyInterface {
  int getValue();
}

interface IMyInterface1 {
  boolean getFlag();
}

public class LambdaExpressionDemo {
  public static void main(String[] args) {
    // reference of the interface
    IMyInterface objRef;
    // Lambda expression
    objRef = () -> 7;
    System.out.println("Value is " + objRef.getValue());
    // Another lambda expression using the same interface reference
    objRef = () -> 7 * 5;
    System.out.println("Value is " + objRef.getValue());
    // This line will give compiler error as target type
    // can't be inferred

    IMyInterface1 objRef1;
    objRef1 = () -> 7 % 2 != 0;

    System.out.println(objRef1.getFlag());

    Predicate<Person> predicate1 = (Person p) -> p.getAge() >= 16;

    Predicate<Person> predicate2 = (Person p) -> p.getAge() >= 18;

    List<Person> listPerson = createList();
    listDrivers(listPerson, predicate1);
    listVoters(listPerson, predicate2);
  }

  private static void listVoters(List<Person> listPerson, Predicate<Person> predicate2) {
     List<Person> voterList = new ArrayList<>();
     for(Person p: listPerson) {
       if(predicate2.test(p)) {
        voterList.add(p);
       }
     }
     printList(voterList);
  }

  public static void listDrivers(List<Person> personList, Predicate<Person> pred) {
    List<Person> driverList = new ArrayList<Person>();
    for (Person person : personList) {
      if (pred.test(person)) {
        driverList.add(person);
      }
    }
    System.out.println("List of drivers ");
    printList(driverList);
  }

  // Method used for printing the lists
  private static void printList(List<Person> personList) {
    personList.forEach((p) -> System.out.print(" FirstName - " + p.getFirstName()
        + " LastName - " + p.getLastName() + " Age - " + p.getAge()));
    System.out.println("");
  }

  @FunctionalInterface
  interface IMyFunc {
    Person getRef(String firstName, String lastName, int age, char gender);
  }

  private static List<Person> createList() {
    List<Person> tempList = new ArrayList<Person>();
    // Constructor reference
    IMyFunc createObj = Person::new;
    Person person = createObj.getRef("Ram", "Tiwari", 50, 'M');
    tempList.add(person);
    person = createObj.getRef("Prem", "Chopra", 13, 'M');
    tempList.add(person);
    person = createObj.getRef("Tanuja", "Trivedi", 30, 'F');
    tempList.add(person);
    person = createObj.getRef("Manoj", "Sharma", 40, 'M');
    tempList.add(person);
    person = createObj.getRef("John", "Trevor", 70, 'M');
    tempList.add(person);
    person = createObj.getRef("Alicia", "Sliver", 17, 'F');
    tempList.add(person);
    System.out.println("List elements are - ");
    System.out.println(tempList);
    return tempList;
  }
}