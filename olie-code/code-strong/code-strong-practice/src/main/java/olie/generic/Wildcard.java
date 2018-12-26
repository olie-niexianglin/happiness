package olie.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/11/27
 * Time: 15:24
 * Desc: 泛型通配符
 */
public class Wildcard {


}

class Question {

    // 虽然Object类是所有类的父类,
    // 但是List<Object>跟其他泛型的List如List<String>, List<Integer>不存在继承关系, 因此会报错.
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
//        List<String> l1 = new ArrayList<>();
//        l1.add("aa");
//        l1.add("bb");
//        l1.add("cc");
//        printList(l1);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(11);
//        l2.add(22);
//        l2.add(33);
//        printList(l2);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        try {
            System.out.println(sdf.parse("2019-01-0 03:00:00").getTime() + "");
            System.out.println(sdf.parse("2019-01-0 04:00:00").getTime() + "");
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}

class A {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        addNumbers(list1);
        System.out.println(list1);
        List<Number> list2 = new ArrayList<>();
        addNumbers(list2);
        System.out.println(list2);
        List<Double> list3 = new ArrayList<>();
        // addNumbers(list3); // 编译报错
    }
}

