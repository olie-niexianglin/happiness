/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package olie.generic;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/11/27
 * Time: 14:08
 * Desc: 泛型方法
 */
public class GernericMethod {

}


/**
 * 泛型方法
 */
class GM1<T> {


    public static void main(String[] args) {
        GM1<String> temp = new GM1<String>();

        //两个 T 一点关系没
        temp.sayHello(new Object());
    }
    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    // <T> 仅仅是用来标识该方法是一个泛型方法，跟其所在类是否是泛型没任何关系
    public <T> void sayHello(T content) {
        System.out.printf(content.toString());

    }

}


class GM2 {

    //根据返回值推断泛型类型
    protected <T> T getObject(String content) {
        return (T)getInstance();
    }

    private Object getInstance() {
        return new Object();
    }
}

class GM3 {
    //根据返回值推断泛型类型
    protected <T> T getObject(String content) {
        return (T)getInstance();
    }
    private Object getInstance() {
        return new Object();
    }
    public static void main(String[] args) {


        GM3 gm3 = new GM3();
        Integer hello = gm3.getObject("hello");

        String world = gm3.getObject("world");
    }
}




