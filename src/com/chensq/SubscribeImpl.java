package com.chensq;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2016/11/27.
 */
public class SubscribeImpl extends UnicastRemoteObject implements ISubscribe {

    private int myid;

    public SubscribeImpl() throws RemoteException{}

    public SubscribeImpl(int myid) throws RemoteException{
        this.myid = myid;
    }

    @Override
    public void Update(String event) throws RemoteException {
        System.out.println(String.format("subscrber %d update event %s ",myid,event));
    }
}
