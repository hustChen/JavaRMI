package com.chensq;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Administrator on 2016/11/27.
 */
public class SubjectServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        ISubject subject=new SubjectImp();
//        ISubscribe[] subscribes=new SubscribeImpl[3];
//        for(int i=0;i<3;i++) {
//            subscribes[i] = new SubscribeImpl(i);
//        }

        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://127.0.0.1:8888/RSubject",subject);
        System.out.println(">>>>>>Info:远程Subject注册成功，在8088端口");
        int i=0;
        while(true){
            try {
                Thread.sleep(2000);
                subject.Notify("envent id: "+i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
