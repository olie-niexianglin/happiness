package com.pattern.structure.flyweight;

import java.util.HashMap;

/**
 * Created by niexianglin on 2016/9/18 14:29
 * Class Description:享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提供性能。
 *                   主要解决：在有大量对象时，有可能会造成内存溢出，我们把其中共同的不同抽象出来，如果有相同的业务请求
 *                             直接返回内存中已有的对象，避免重新创建。
 *                   何时使用：系统中有大量对象
 *                             这些对象消耗大量内存
 *                             这些对象的状态大部分可以外部化
 *                             这些对象可以按照内藴（内蕴状态是存储在享元对象内部并且不会随环境的改变而改变）状态分为很多组，
 *                             当把外藴对象从对象中踢出来时，每一组对象都可以用一个对象替代。
 *                   如何解决: 用唯一标识码判断，如果内存中有，则返回这个唯一标识的对象。
 *                   关键代码: 用 HashMap存储这些对象。
 *                   应用实例: Java 中的String,如果有则返回，如果没有则创建一个字符串保存在字符串缓存池里、
 *                   模式有点: 大大减少对象的创建，降低系统的内存。
 *                   使用场景: 系统中有大量相似的对象，需要缓冲池的场景。
 *                   注意事项: 注意划分外部状态和内部状态，否则可能引起线程安全问题。
 */
public class FlyweightTest {
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color){
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }
}

class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}