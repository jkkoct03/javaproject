package com.interview;

public class CloningTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person original = new Person("John", address);

        Person shallowCopy = original.shallowClone();

        // Deep clone
        Person deepCopy = original.deepClone();


        original.address.city = "Los Angeles";
        
        System.out.println("Original: " + original.address.city);       // Los Angeles
        System.out.println("Shallow Copy: " + shallowCopy.address.city); // Los Angeles (affected)
        System.out.println("Deep Copy: " + deepCopy.address.city);       // New York (not affected)
    }


}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow Clone
    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();  // default is shallow clone
    }

    // Deep Clone
    public Person deepClone() {
        Address clonedAddress = new Address(this.address.city);  // deep copy
        return new Person(this.name, clonedAddress);
    }
}

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}
