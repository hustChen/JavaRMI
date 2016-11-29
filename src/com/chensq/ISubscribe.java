package com.chensq;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/11/27.
 */
public interface ISubscribe extends Remote {
    void Update(String event) throws RemoteException;
}
