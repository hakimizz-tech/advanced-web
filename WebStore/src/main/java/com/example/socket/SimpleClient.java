package com.example.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class SimpleClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 6666;

        try (Socket socket = new Socket(hostname, port)) {

            //WHAT DATA WE ARE SENDING TO THE SERVER
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // WHAT DATA WE ARE RECEIVING FROM THE SERVER
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a message to the server
            String message = "Hello from client";
            System.out.println("Sending to server: " + message);
            out.println(message);

            // Read the response from the server
            String response = in.readLine();
            System.out.println("Received from server: " + response);

        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
