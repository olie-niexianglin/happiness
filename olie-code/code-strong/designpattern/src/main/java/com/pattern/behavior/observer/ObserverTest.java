package com.pattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niexianglin on 2016/9/14 21:30
 * Class Description:
 */
public class ObserverTest {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(new ConcreteObserver("1"));
        subject.addObserver(new ConcreteObserver("2"));
        subject.addObserver(new ConcreteObserver("3"));
        subject.addObserver(new ConcreteObserver("4"));
        subject.change("Hello World");
    }
}
//抽象主体
abstract class Subject{
    //订阅者集合
    List<Observer> observers = new ArrayList<Observer>();
    protected void addObserver(Observer observer){
       this.observers.add(observer);
    }
    protected void removeObserver(int index){
        this.observers.remove(index);
    }
    protected void notifyAllObservers(String newState){
        for(Observer observer:observers){
            observer.update(newState);
        }
    }
}
//具体主体
class ConcreteSubject extends Subject{
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public void change(String newState){
        this.state = newState;
        this.notifyAllObservers(newState);
    }
}
//抽象观察者
interface Observer{
    void update(String newState);
}
//具体观察者
class ConcreteObserver implements Observer{
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String newState) {
        System.out.println("Observer of "+ this.name +" get the change of BeObserver: "+newState);
    }
}
//----------------------------------- 拉模式 -------------------------

