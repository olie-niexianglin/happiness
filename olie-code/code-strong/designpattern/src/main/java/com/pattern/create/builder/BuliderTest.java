package com.pattern.create.builder;

/**
 * Created by niexianglin on 2016/9/16 20:42
 * Class Description: 构建模式：将系统中的一些不经常变化的构组建成一些经常变化的产品
 *                    应用实例：去肯德基，汉堡，可乐，薯条，炸鸡翅等是不变的，而其组合是经常变化的，组合成所谓的套餐。
 */
public class BuliderTest {
    public static void main(String[] args) {

        //创建导演类和Audi的建造者
        AudiBulider bulider = new AudiBulider();
        Director director = new Director(bulider);

        // 利用指挥类获得汽车而不是自己获得汽车
        Car car = director.construct();
        //开车
        car.drive();
    }
}
interface Car{
    void drive();
}
class Audi implements Car{
    public void drive(){
        System.out.println("come on ");
    }
}
//抽象创建者：定义产品的创建方式和返回方式
abstract class Bulider{
    public abstract void buildEngine();
    public abstract void buildSteeringWheel();
    public abstract Car getCar();
}
//具体创建者
class AudiBulider extends Bulider{

    @Override
    public void buildEngine() {
        System.out.println("builder audi engin");
    }

    @Override
    public void buildSteeringWheel() {
        System.out.println("builder audi steeringwheel");
    }

    @Override
    public Car getCar() {
        return new Audi();
    }
}
//指挥者
class Director {
    private Bulider bulider;
    public Director(Bulider bulider){
        this.bulider = bulider;
    }
    public Car construct(){
        bulider.buildSteeringWheel();
        bulider.buildEngine();
        return bulider.getCar();
    }
}