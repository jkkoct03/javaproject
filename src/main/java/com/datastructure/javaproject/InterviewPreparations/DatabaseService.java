package com.datastructure.javaproject.InterviewPreparations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnectionManager {
    private static final ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        } catch (SQLException e) {
            throw new RuntimeException("Error creating DB connection", e);
        }
    });

    public static Connection getConnection() {
        return connectionThreadLocal.get();
    }

    public static void closeConnection() {
        try {
            connectionThreadLocal.get().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionThreadLocal.remove(); // Prevent memory leaks
        }
    }
}

public class DatabaseService {
    public static void main(String[] args) throws InterruptedException {
        InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("Hello World");
        System.out.println(threadLocal.get());

        Thread chilThread = new Thread(() -> {
            System.out.println(threadLocal.get());
        });

        chilThread.start();
        Object obj = new Object();
        synchronized (obj) {
            obj.wait();
        }
        // Runnable task = () -> {

        // Connection connection = DatabaseConnectionManager.getConnection();
        // System.out.println(Thread.currentThread().getName() + " got DB Connection: "
        // + connection);
        // DatabaseConnectionManager.closeConnection();
        // };

        // Thread thread1 = new Thread(task, "Thread-1");
        // Thread thread2 = new Thread(task, "Thread-2");

        // thread1.start();
        // thread2.start();
    }
}
