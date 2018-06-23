package com.pattern.behavior.template;

/**
 * Created by niexianglin on 2016/9/2 16:49
 * Class Description:
 */
public class TemplateTest {
    public static void main(String[] args) {
        MakeAfternoonTea makeAfternoonTea = new MakeTea();
        MakeAfternoonTea makeAfternoonTea1 = new MakeCoffee();

        makeAfternoonTea.makeAfternoonTea_Template();
        makeAfternoonTea1.makeAfternoonTea_Template();
    }
}


//模板基类
abstract class MakeAfternoonTea{

    //模板方法，定义了方案执行的具体步骤
    public final void makeAfternoonTea_Template(){
        //模板方法中定义了基本流程
        boilWater();
        addBeverage();
        cup();
        if(hookMethod()){
            addCondiments();
        }
    }
    //1 烧水--->公用方法
    public  void boilWater(){
        System.out.println("i am boiling the water");
    }
    //2 放作料--抽象方法：如果下午茶吃的是咖啡，那么就需要放入咖啡，如果下午茶吃茶，那么就需要放入绿茶
    protected abstract void addBeverage();

    //3 倒入茶杯中 ---> 公用方法
    public void cup(){
        System.out.println("i am pour the water into the cup");
    }
    //4 加入作料--抽象方法：如果下午吃茶吃的是咖啡，那么需要加入咖啡伴侣，如果下午茶吃茶，那么就需要放一点柠檬
    protected abstract void addCondiments();

    //5 钩子方法--饮品中是否加入作料，由用户来确定
    public boolean hookMethod(){
        return true;
    }

}

//具体子类 MakeTea:制作绿茶
class MakeTea extends MakeAfternoonTea{
    @Override
    protected void addBeverage() {
        System.out.println("i am add the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("i am add the lemon");
    }

}

//具体子类 MakeTea:制作绿茶
class MakeCoffee extends MakeAfternoonTea{
    @Override
    protected void addBeverage() {
        System.out.println("i am add the coffee");
    }

    @Override
    protected void addCondiments() {
        System.out.println("i am add the coffee-mate");
    }

    //用户可以选择重写或者不重写钩子方法
    @Override
    public boolean hookMethod() {
        return false;
    }
}
