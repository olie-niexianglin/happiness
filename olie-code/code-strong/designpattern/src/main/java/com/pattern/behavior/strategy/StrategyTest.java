package com.pattern.behavior.strategy;

import java.util.*;

/**
 * Created by niexianglin on 2016/9/1 14:41
 * Class Description:learn for Strategy Pattern
 */

/*
    Strategy Pattern:
        策略模式定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。
        策略模式让算法独立于使用它的客户而独立变化。

    策略模式的编写步骤
        1．对策略对象定义一个公共接口。 Comparator
        2．编写策略类，该类实现了上面的公共接口。 SortByAge  SortByName
        3．在使用策略对象的类中保存一个对策略对象的引用。
        4．在使用策略对象的类中，实现对策略对象的set和get方法（注入）或者使用构造方法完成赋值
 */
public class StrategyTest {
    public static void main(String[] args) {
        Comparator<Person> comparator = new SortByAge();
        Comparator<Person> comparator1 = new SortByName();
        List<Person> list = new ArrayList<Person>();

        list.add(new Person(1,"1"));
        list.add(new Person(2,"2"));
        list.add(new Person(11,"3"));
        list.add(new Person(4,"4"));
        list.add(new Person(8,"5"));
        list.add(new Person(6,"6"));

        SomeServiceAboutPerson service = new SomeServiceAboutPerson();
        //service.setComparator(comparator);
        service.setComparator(comparator1);
        service.setPersonList(list);

        service.concreteMethod();
    }
}


/*
    Comparator 是抽象接口,定义抽象算法
 */
 /*
    SortByAge  具体算法
 */
class SortByAge implements Comparator<Person>{

    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }
}
/*
    SortByName 具体算法
 */
class SortByName implements Comparator<Person>{
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

/*
    具体使用类
 */
class SomeServiceAboutPerson{
    private Comparator<Person> comparator;
    private List<Person> personList ;

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void setComparator(Comparator<Person> comparator) {
        this.comparator = comparator;
    }

    public void concreteMethod(){
        Collections.sort(personList, comparator);
        System.out.println(Arrays.toString(personList.toArray()));
    }
}
















class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}