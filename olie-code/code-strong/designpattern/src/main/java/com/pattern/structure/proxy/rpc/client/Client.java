package com.pattern.structure.proxy.rpc.client;


import com.pattern.structure.proxy.rpc.comm.HelloService;

public class Client{
    public static void main(String[] args) {
        HelloService service = ClientStub.CallService(HelloService.class,"127.0.0.1",8088);
        System.out.print(service.sayHello());
    }

}