/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package olie.generic;

import org.apache.tools.ant.taskdefs.optional.clearcase.CCMklbtype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/11/27
 * Time: 14:08
 * Desc: 泛型类
 */
public class GenericClass {
}


class GC1<T> {
    T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    //compile fail
//    public static void sayHello(T t) {
//
//    }
}

