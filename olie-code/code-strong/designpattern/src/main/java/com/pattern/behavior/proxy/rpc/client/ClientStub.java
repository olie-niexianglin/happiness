package com.pattern.behavior.proxy.rpc.client;

import java.lang.reflect.Proxy;

//建立连接 封装调用数据 发送数据 解析结果
public class ClientStub {
    public static <T> T CallService(Class<T> service, String host, int port) {
        T proxy = (T) Proxy.newProxyInstance(ClientStub.class.getClassLoader(),new Class[] {service},new ServiceInvocationHandler(host,port,service));
        return proxy;
    }
}
