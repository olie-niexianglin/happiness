package com.pattern.behavior.proxy;

/**
 * Created by niexianglin on 2016/8/19 16:46
 * Class Description:
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        BeProxy beProxy = new BeProxy();
        Prxoy prxoy = new Prxoy(beProxy);
        prxoy.sayHello();
    }
}


interface CommonFeature{
    public void sayHello();
}
 /*
    代理对象(Proxy)：需要持有被代理对象的引用，这样才能使用被代理对象(BeProxy)的方法
 */
class Prxoy implements CommonFeature{
    private BeProxy beProxy;

    public Prxoy(BeProxy beProxy) {
        this.beProxy = beProxy;
    }


    public void sayHello() {
        System.out.println("i am the BeProxy");
        this.beProxy.sayHello();
    }
}
/*
   被代理对象(BeProxy)
*/
class BeProxy implements CommonFeature{

    public void sayHello() {
        System.out.println("i am the Proxy");
    }
}

