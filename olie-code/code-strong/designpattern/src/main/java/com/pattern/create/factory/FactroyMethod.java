package com.pattern.create.factory;

/**
 * Created by niexianglin on 2016/9/1 14:39
 * Class Description:
 */
public class FactroyMethod {
    public static void main(String[] args) {
        //突然有了一个新的需求，现在出现了一种新的幸福->青春
        //如果是简单工厂：那么必须修改简单工厂的 if else 或者 switch 逻辑，违背了“开闭原则”
        //但是换了工厂方法模式，就不会违背“开闭”原则，需要添加一个具体产品和具体工厂就好了
        HappinessFactory factory = new YouthFactory();
        Happiness happiness = factory.generateHappiness();
        happiness.sayHello2EveryOne();
    }
}

/*
    工厂方法包括以下三个要素
    1 抽象工厂
    2 抽象产品
    3 具体工厂
    4 具体产品
 */

//抽象产品
interface Happiness{
    void sayHello2EveryOne();
}
//抽象工厂
interface HappinessFactory{
    Happiness generateHappiness();
}
//具体产品->爱情
class Tendresse implements Happiness{
    public void sayHello2EveryOne() {
        System.out.println("Hello i am tendresse");
    }
}
//具体产品->亲情
class Familyffection implements Happiness{
    public void sayHello2EveryOne() {
        System.out.println("Hello i am familyaffection");
    }
}
//具体工厂->爱情工厂
class TendresseFactory implements HappinessFactory{
    public Happiness generateHappiness(){
        return new Tendresse();
    }
}
//具体工厂->亲情工厂
class FamilyffectionFactory implements HappinessFactory{
    public Happiness generateHappiness(){
        return new Familyffection();
    }
}
//////////////////////////////////////////////////////////新的需求
class Youth implements Happiness{
    public void sayHello2EveryOne() {
        System.out.println("Hello i am Youth");
    }
}
class YouthFactory implements HappinessFactory{
    public Happiness generateHappiness() {
        return new Youth();
    }
}

/////////////////////////////////////////////////////////新的需求