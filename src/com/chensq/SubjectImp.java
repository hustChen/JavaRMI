package com.chensq;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
public class SubjectImp extends UnicastRemoteObject implements ISubject {

    List<ISubscribe> subscribeList;

    public SubjectImp() throws RemoteException{
        subscribeList=new ArrayList<>();
    }

    @Override
    public void Subscribe(ISubscribe subscriber) throws RemoteException{
        subscribeList.add(subscriber);
    }

    @Override
    public void Remove(ISubscribe subscriber) throws RemoteException{
        subscribeList.remove(subscriber);
    }

    @Override
    public void Notify(String event) {
        for(ISubscribe subscribe:subscribeList){
            try {
                subscribe.Update(event);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
