package com.chensq;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/11/27.
 */
public interface ISubject extends Remote {
    void Subscribe(ISubscribe subscriber) throws RemoteException;
    void Remove(ISubscribe subscriber) throws RemoteException;
    void Notify(String event) throws RemoteException;
}
