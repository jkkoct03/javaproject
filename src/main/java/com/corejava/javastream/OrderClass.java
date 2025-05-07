package com.corejava.javastream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Order {

  private String orderId;
  private String customerName;
  private double amount;
  private String status; // e.g., "NEW", "IN_PROGRESS", "DELIVERED", "CANCELLED"

  public Order(String orderId, String customerName, double amount, String status) {
    this.orderId = orderId;
    this.customerName = customerName;
    this.amount = amount;
    this.status = status;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
    
}

public class OrderClass {
  public static void main(String[] args) {
    List<Order> orders = Arrays.asList( 
        new Order("O1", "AliceP", 250.0, "DELIVERED"),
        new Order("O2", "Bob", 150.0, "CANCELLED"),
        new Order("O3", "AliceK", 300.0, "DELIVERED"),
        new Order("O4", "Bob", 200.0, "DELIVERED"),
        new Order("O5", "Charlie", 100.0, "NEW")
    );
     
   List<Order> lo =  orders.stream().filter(order -> order.getStatus().equals("DELIVERED")).sorted(Comparator.comparing(Order::getAmount).reversed()).collect(Collectors.toList());

   for(Order or: lo) {
     System.out.println(or.getCustomerName());
   }

   Map<String,List<Order>> mo =  orders.stream().filter(order -> order.getStatus().equals("DELIVERED")).collect(Collectors.groupingBy(Order::getCustomerName, Collectors.toList()));
   System.out.println(mo);
   
    Double sum =  orders.stream().filter(order -> "DELIVERED".equals(order.getStatus())).collect(Collectors.summingDouble(Order::getAmount));
    System.out.println(sum);

    Map<String, Double> sumByCustomer = orders.parallelStream().filter(order -> "DELIVERED".equals(order.getStatus())).collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingDouble(Order::getAmount)));
    System.out.println(sumByCustomer);
  }

}
