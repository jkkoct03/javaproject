package com.datastructure.javaproject.InterviewPreparations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
    /* public static void main(String[] args) {
       while(true){
            System.out.println("Hello World");
        }
        
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 2);
        mp.put(2, 3);
        mp.put(3, 2);
        mp.put(4, 1);


        List<Map.Entry<Integer, Integer>> al = new ArrayList<>(mp.entrySet());
        Collections.sort(al, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Entry<Integer, Integer> arg0, Entry<Integer, Integer> arg1) {
                if(arg0.getValue() < arg1.getValue()) {
                    return 1;
                } else if(arg0.getValue() > arg1.getValue()) {
                    return -1;
                } else {
                    return -arg0.getKey().compareTo(arg1.getKey());
                }
            }

        });


        System.out.println(al);





        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> val : mp.entrySet()) {
            list.add(val.getValue());
        }
        List<Map.Entry<Integer, Integer>> listOfMap = new ArrayList<>(mp.entrySet());
        listOfMap.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
      //  System.out.println(listOfMap);

       // Map<Integer, Integer> resMap = mp.entrySet().stream().sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder()).thenComparing(Map.Entry::getKey).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
      /* Map<Integer, Integer> resMap = mp.entrySet().stream()
       .sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
               .thenComparing(Map.Entry::getKey)) // Ensure correct order for equal values
       .collect(Collectors.toMap(
               Map.Entry::getKey, 
               Map.Entry::getValue, 
               (e1, e2) -> e1, 
               LinkedHashMap::new)); // Maintain insertion order after sorting

            System.out.println(resMap);  
    }*/


	public static void main(String[] args) 

	{

		new House("Coding");
        new House(null);

	}

   /* public static void main(String[] args) 
	{
		A a = new A();
		B b = new A();
	System.out.println(a.sing() + " " + b.sing());
	}*/
    
}


class A extends B
{
	public static String sing() 
	{
		return "fa";
	}
}

class B 
{
	public static String sing() 
	{
		return "la";
	}
}

class Building 

{

	Building() 

	{
        super();
		System.out.println("Coding-Building");

	}

	Building(String name) 

	{

		this();

		System.out.println("Coding-building: String Constructor" + name);

	}

}
 class House extends Building 

{

	House() 

	{
        super();
		System.out.println("Coding-House ");

	}

	House(String name) 

	{

		this();

		System.out.println("Coding-house: String Constructor" + name);

	}


}

