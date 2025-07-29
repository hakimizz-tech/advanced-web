package com.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// 3.develop the server program
public class Server {
    public static void main(String[] args) {
        try {
            HelloImpl obj = new HelloImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // Default RMI port
            registry.rebind("Hello", obj);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
