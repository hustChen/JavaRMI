package com.chensq;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/11/27.
 */
public class SubscribeClient {
    public static void main(String[] args) throws RemoteException {
        ISubscribe[] subscribes=new SubscribeImpl[3];
        for (int i=0;i<3;i++){
            subscribes[i]=new SubscribeImpl(i);
        }

        try {
            ISubject subject= (ISubject) Naming.lookup("rmi://127.0.0.1:8888/RSubject");
            for(ISubscribe subscribe:subscribes)
                subject.Subscribe(subscribe);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
