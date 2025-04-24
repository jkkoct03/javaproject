package com.datastructure.javaproject.InterviewPreparations;

import java.io.*;
import java.net.*;

public class ThreadLeakServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();  // Creates a new thread for each request
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Simulate processing but forget to release resources
            while (true) {
                String input = in.readLine();
                if (input == null || input.equalsIgnoreCase("exit")) break;
                out.println("Echo: " + input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 🔴 BUG: The thread never terminates properly, leading to a thread leak!
    }
}

