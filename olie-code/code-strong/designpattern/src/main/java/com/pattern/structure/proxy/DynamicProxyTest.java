package com.pattern.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by niexianglin on 2016/8/19 16:57
 * Class Description:
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        BeProxys beProxys = new BeProxys();
        /*
            生成代理对象的源代码，注意需要在 cmd 中执行
            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
         */
        MyInvocationHandler mh = new MyInvocationHandler(beProxys);
        CommonFeatures proxy = (CommonFeatures) Proxy.newProxyInstance(beProxys.getClass().getClassLoader(),beProxys.getClass().getInterfaces(),mh);
        proxy.sayHello();

    }
}
 /*
    InvocationHandler:将额外的业务逻辑编写在InvocationHandler中
 */
class MyInvocationHandler implements InvocationHandler{
     /*
       持有被代理的对象
      */
     private CommonFeatures beproxy;

     public MyInvocationHandler(CommonFeatures beproxy) {
         this.beproxy = beproxy;
     }
     /*
            proxy:JDK生成的代理对象 method:被代理的方法 args:被代理方法的参数
      */

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理的逻辑
        System.out.println("i am the proxy:"+proxy.getClass().getName());
        return method.invoke(beproxy,args);
    }
}

interface CommonFeatures {
    public void sayHello();
}
/*
   被代理对象(BeProxy)
*/
class BeProxys implements CommonFeatures{

    public void sayHello() {
        System.out.println("i am the Proxy");
    }
}
/*
    JDk 生成的 $Proxy0 代理类如下
    public final class $Proxy0 extends Proxy implements CommonFeatures{
        private static Method m1;

        static{
            try{
                m1 = Class.forName("com.pattern.prxoy.CommonFeatures").getMethod("sayHello",null)});
            }catch(Exception ex){

            }
        }

        public $Proxy0(InvocationHandler var1){
            super(var1);
        }
        public final void sayHello(){
            super.h.invoke(this,m1,null);
        }

    }
 */