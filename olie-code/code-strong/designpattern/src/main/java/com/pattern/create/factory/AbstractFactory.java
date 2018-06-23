package com.pattern.create.factory;

/**
 * Created by niexianglin on 2016/8/23 10:51
 * Class Description:
 */
/*
    产品等级结构 ：产品等级结构即产品的继承结构，如一个抽象类是电视机，其子类有海尔电视机、海信电视机、TCL电视机，
    则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机是其子类。

    产品族 ：在抽象工厂模式中，产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品，
    如海尔电器工厂生产的海尔电视机、海尔电冰箱，海尔电视机位于电视机产品等级结构中，海尔电冰箱位于电冰箱产品等级结构中。

    开闭原则的倾斜性（增加新的工厂和产品族容易，增加新的产品等级结构麻烦）
 */
public class AbstractFactory {
    public static void main(String[] args) {
//        ProductamilyFactory haier = new HaierFactory();
//        Television television = haier.generateTelevision();
//        television.sayHello();
        /*
            如果现在又出现新的需求，需要一个长虹产品族，那么该怎么做呢？
            添加一个 ChangHongFactory 和 三个具体产品，满足开闭原则

            如果现在需要添加一个洗衣机产品该怎么做呢？
            抽象工厂需要改变
            每个具体工厂需要改变
            添加一个洗衣机抽象产品
            每一个具体工厂都需要添加一个洗衣机具体产品

            相比较而言，增加一个产品族生产工厂更容易一些，所以在使用抽象工厂模式时，需要仔细分析哪一个维度是经常变化的，
            把经常变化的部分抽象为 产品族工厂，因为添加一个产品族工厂相对较为简单

         */
    }
}

/*
    抽象工厂模式设计三类角色
    1 产品族抽象工厂
    2 具体工厂
    3 各等级抽象产品
    4 各等级具体产品
 */
//------------------------------------------------------
//各等级抽象产品
//冰箱
interface Refrigerator{
    void sayHello();
}
//电视
interface Television{
    void sayHello();
}
//空调
interface AirConditioner{
    void sayHello();
}
//------------------------------------------------------
//各等级具体产品
//冰箱
class HaierRefrigerator implements Refrigerator{
    public void sayHello() {
        System.out.println("Hello i am Haier Refrigerator");
    }
}
//电视
class HaierTelevision implements Television{
    public void sayHello() {
        System.out.println("Hello i am Haier Television");
    }
}
//空调
class HaierAirConditioner implements AirConditioner{
    public void sayHello() {
        System.out.println("Hello i am Haier AirConditioner");
    }
}

//冰箱
class HisenseRefrigerator implements Refrigerator{
    public void sayHello() {
        System.out.println("Hello i am Hisense Refrigerator");
    }
}
//电视
class HisenseTelevision implements Television{
    public void sayHello() {
        System.out.println("Hello i am Hisense Television");
    }
}
//空调
class HisenseAirConditioner implements AirConditioner{
    public void sayHello() {
        System.out.println("Hello i am Haier HisenseConditioner");
    }
}
//------------------------------------------------------
//产品族抽象工厂
interface ProductamilyFactory{
    Refrigerator generateRefrigerator();
    Television generateTelevision();
    AirConditioner generateAirConditioner();
}
//------------------------------------------------------
//具体产品族工厂
class HaierFactory implements ProductamilyFactory{
    public Refrigerator generateRefrigerator() {
        return new HaierRefrigerator();
    }

    public Television generateTelevision() {
        return new HaierTelevision();
    }

    public AirConditioner generateAirConditioner() {
        return  new HaierAirConditioner();
    }
}

class HisenseFactory implements ProductamilyFactory{
    public Refrigerator generateRefrigerator() {
        return new HisenseRefrigerator();
    }

    public Television generateTelevision() {
        return new HisenseTelevision();
    }

    public AirConditioner generateAirConditioner() {
        return  new HisenseAirConditioner();
    }
}

