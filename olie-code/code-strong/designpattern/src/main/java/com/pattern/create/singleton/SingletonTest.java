package com.pattern.create.singleton;

/**
 * Created by niexianglin on 2016/9/14 18:27
 * Class Description:
 */
public class SingletonTest {
    public static void main(String[] args) {

    }
}
/*
    饿汉式—singleton
    所谓饿汉式，就是在类加载时完成singleton实例的初始化，多线程安全。
    在外部用例试图使用 getInstance 方法获取对象时，引起Singleton类的加载，引起静态成员变量 INSTANCE 的初始化。
    而且同一个类加载只会加 Singleton 一次。
 */
class Singleton {
    private Singleton(){}
    private static final Singleton INSTANCE = new Singleton();;
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
/*
    懒汉式—singleton
    所谓懒汉式，就是在外部用例发出请求时，才会被动创建实例。
    1 double check lock — 多线程几乎安全，在另一篇文章中介绍过 dcl 不一定是多线程安全的。
 */
class Singleton1 {
    private Singleton1(){}
    private static Singleton1 instance;
    public static Singleton1 getInstance() {
        if(instance==null){           //step1
            synchronized (Singleton1.class) {
                if(instance==null){   //step2
                    instance = new  Singleton1();
                }
            }
        }
        return instance;
    }
}

/*
    懒汉式:内部类实现 — 多线程几乎安全，内部类实现结合了饿汉式思想。
 */
class Singleton2 {
    private Singleton2() {}
    private static class InnerSingleton{
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static final Singleton2 getInstance() {
        return InnerSingleton.INSTANCE;
    }
}