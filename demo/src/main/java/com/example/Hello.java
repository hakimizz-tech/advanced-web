package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

//1. create a remote interface
public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}
