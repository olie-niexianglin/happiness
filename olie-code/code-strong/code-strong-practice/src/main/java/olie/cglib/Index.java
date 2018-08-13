package olie.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/5 10:24
 * @Description:
 */
public class Index implements MethodInterceptor {


    private Object obj;

    public static void main(String[] args) throws Exception {
        Index cglibProxy = new Index();
        SuperClass proxy = (SuperClass) cglibProxy.createProxy(SuperClass.class);
        String result = proxy.sayHello(true);
        System.out.println(result);
    }



    public Object createProxy(Class target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);// 设置代理目标
        enhancer.setCallback(this);// 设置回调
        enhancer.setClassLoader(target.getClass().getClassLoader());
        return enhancer.create();
    }


    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;
        try {

            if (method.getName().equals("sayHello")) {

                before();

                result = proxy.invokeSuper(obj, args);

                after();
            }
        } catch (Exception e) {
            exception();
        } finally {
            beforeReturning();
        }
        return result;
    }


    private void before() {
        System.out.println("before method invoke");
    }

    private void after() {
        System.out.println("after method invoke");
    }

    private void exception() {
        System.out.println("method invoke exception");
    }

    private void beforeReturning() {
        System.out.println("before returning");
    }

}
