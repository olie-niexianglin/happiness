package com.pattern.behavior.memento;

/**
 * Created by niexianglin on 2016/9/18 21:45
 * Class Description:    主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，
 *                       通俗的讲下：假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，
 *                       类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作。
 */
public class MementoTest {
    public static void main(String[] args) {
        //创建原始类
        Original original = new Original("Hello");

        //创建备忘录
        Storage storage = new Storage(original.createMemento());

        //修改原始类数据
        original.setValue("World");

        //还原原始类数据
        original.restoreMemento(storage.getMemento());

        System.out.println(original.getValue());

    }
}

class Original{
    private String value;
    public String getValue(){
        return this.value;
    }
    public void setValue(String value){
        this.value = value;
    }
    public Original(String value){
        this.value = value;
    }
    public Memento createMemento(){
        return new Memento(this.value);
    }
    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}
class Memento{
    private String value;
    public Memento(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Storage{
    private Memento memento;
    public Storage(Memento memento){
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}


















