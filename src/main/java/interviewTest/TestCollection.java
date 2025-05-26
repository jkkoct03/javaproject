package interviewTest;

import java.util.PriorityQueue;

public class TestCollection {
 
public static void main(String args[]) {
 
PriorityQueue<String> queue = new PriorityQueue<String>();
 
	System.out.println("add Operation in Queue: " + queue.add("Kumar")); //true
	 
	System.out.println("add Operation in Queue: " + queue.add("Hitesh")); //true
	 
	System.out.println("Elements in Queue:" + queue); //["Hitesh","Kumar"]
	 
	System.out.println("element Operation in Queue:" + queue.element());// 2
	 
	System.out.println("Elements in Queue:" + queue);// ["Hitesh","Kumar"]
	 
	System.out.println("peek Operation in Queue: " + queue.peek()); //"Kumar"
	 
	System.out.println("Elements in Queue: " +  queue);  // ["Hitesh","Kumar"]
	 
	System.out.println("offer Operation in Queue:" + queue.offer("Manoj")); //true
	 
	System.out.println("Elements in Queue:" + queue);// ["Manoj", "Hitesh","Kumar"]
	 
	System.out.println("remove Operation in Queue:" + queue.remove()); //true
	 
	System.out.println("Elements in Queue:" + queue);// ["Manoj", "Hitesh"]
	 
	System.out.println("poll Operation in Queue:" + queue.poll());// true
	 
	System.out.println("Elements in Queue: " + queue); // ["Manoj"]
}
}
