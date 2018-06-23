package com.pattern.structure.decorator;

/**
 * Created by niexianglin on 2016/9/14 20:37
 * Class Description:
 */
public class DecoratorTest {
    public static void main(String[] args) {
        MyLife myLife = new MyLife();
        myLife.day();
        LoverLife loverLife = new LoverLife(myLife);
        loverLife.day();

        FamilyAffectionLife familyAffectionLife = new FamilyAffectionLife(loverLife);
        familyAffectionLife.day();
    }
}
//公共的抽象接口
interface Life{
    void day();
}
//具体类
class MyLife implements Life{
    @Override
    public void day() {
        System.out.println("go to work.");
    }
}
//装饰器抽象类，为具体抽象类提供一些共有的属性和操作。
abstract class LifeDecorator implements Life{
    protected Life myLife;

    public LifeDecorator(Life myLife) {
        this.myLife = myLife;
    }
    public void day(){
        this.myLife.day();
    }
}
//具体的装饰类，可以为 Life 生活类添加一些丰富的活动
class LoverLife extends LifeDecorator{
    public LoverLife(Life myLife) {
        super(myLife);
    }
    public void day(){
        System.out.println("add some lover to life.");
        super.day();
    }
}
//具体的装饰类，可以为 Life 生活类添加一些丰富的活动
class FamilyAffectionLife extends LifeDecorator{
    public FamilyAffectionLife(Life myLife) {
        super(myLife);
    }
    public void day(){
        System.out.println("add some family affection to life.");
        super.day();
    }
}