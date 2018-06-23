package com.pattern.structure.proxy.rpc.client;

import com.pattern.structure.proxy.rpc.comm.Invocation;
import com.pattern.structure.proxy.rpc.comm.Method;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.net.Socket;

/*
    JDK动态代理中 invoke 方法中定义 封装调用数据 发送数据 解析结果 的业务罗街
 */
public class ServiceInvocationHandler implements InvocationHandler{
    private String host;
    private int port;
    private Class service;
    public ServiceInvocationHandler(String host, int port, Class service) {
        this.host = host;
        this.port = port;
        this.service = service;
    }


    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args){
        //建立连接
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Invocation result = null;
        try {
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            //发送调用对象
            Invocation invocation = new Invocation();
            invocation.setInterfaces(service);
            if(args!=null){
                Class[] clazz = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    clazz[i] = args[i].getClass();
                }
                invocation.setMethod(new Method(method.getName(),clazz));
            }else{
                invocation.setMethod(new Method(method.getName(),null));
            }
            invocation.setParams(args);
            oos.writeObject(invocation);
            oos.flush();
            //解析调用结果
            ois = new ObjectInputStream(socket.getInputStream());
            result = (Invocation) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null)oos.close();
                if(ois!=null)ois.close();
                if(socket!=null&&!socket.isClosed()) socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //返回调用结果
        return result.getResult();
    }
}

