package com.example;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

// 2. implement the remote object
public class HelloImpl extends UnicastRemoteObject implements Hello {

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}
