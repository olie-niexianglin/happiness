package com.pattern.behavior.mediator;

/**
 * Created by niexianglin on 2016/9/20 16:17
 * Class Description:  中介者模式（Mediator Pattren）是用来降低多个对象之间的通信复杂性，这种模式提供了一个中介类。
 *                     该类通常处理不同的通信，并支持松耦合，是代码易于维护。
 *
 *                     意图：用一个中介对象来封装一系列的对象交互，中介者使各个对象不需要明显地相互引用，从而使其耦合
 *                           松散，而且可以独立地改变它们之间的交互。
 *                     主要解决：对象与对象之间存在大量的关联关系，这样势必会导致系统的结构变得很复杂，同时若一个对象
 *                               发生改变，我们也需要跟踪与之相关联的对象，同时做出相应的处理。
 *
 *
 */
public class MediatorTest {
    public static void main(String[] args) {
        //一个房主、一个租房者、一个中介机构
        ConcreateMediator mediator = new ConcreateMediator();

        //房主和租房者只需要知道中介机构即可
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        Tenant tenant = new Tenant("李四", mediator);

        //中介结构要知道房主和租房者
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.constact("听说你那里有三室的房主出租.....");
        houseOwner.constact("是的!请问你需要租吗?");
    }
}

//抽象中介者
abstract class Mediator{
    public abstract void constact(String message,Person person);
}
//抽象同事
abstract class Person{
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
//具体同事
class HouseOwner extends Person{
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String message){
        mediator.constact(message,this);
    }
    public void reciveMessage(String message){
        System.out.println("HouseOwner:"+message);
    }
}
//具体同事
class Tenant extends Person{
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String message){
        mediator.constact(message,this);
    }
    public void reciveMessage(String message){
        System.out.println("Tenant:"+message);
    }
}

//具体中介者
class ConcreateMediator extends Mediator{
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void constact(String message, Person person) {
        if(person==tenant){
            tenant.reciveMessage(message);
        }else if(person==houseOwner){
            houseOwner.reciveMessage(message);
        }
    }
}










