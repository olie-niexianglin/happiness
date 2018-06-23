package com.pattern.structure.bridge;

/**
 * Created by niexianglin on 2016/9/18 10:27
 * Class Description:
 */
public class BridgeTest {
    public static void main(String[] args) {
        //--------------- 多维度 继承 ------------------
        //如果现在有一个新的需求，需要添加一个五角形和黄色
        //那么需要添加一个黄色的三角形，红色的五角形，绿色的五角形和黄色的五角形四个类

        //--------------- 桥接模式 解耦 ----------------
        Color1 red = new Red();
        Shap1 triangle = new Triangle(red);
        triangle.applyColor();
        //新的需求 需要添加一个五角形和黄色：只需要添加两个类
        Color1 yellow = new Yellow();
        Shap1 pentagon = new Pentagon(yellow);
        pentagon.applyColor();

    }
}
//--------------------------------------------------多维度继承----------------------------------
//维度一
interface Shap{
   void sayShap();
}
//维度二
interface Color{
    void sayColor();
}
//红色三角形
class RedTriangle implements Shap,Color{
    @Override
    public void sayShap() {
        System.out.println("Triangle");
    }

    @Override
    public void sayColor() {
        System.out.println("Red");
    }
}
//绿色的三角形
class GreenTriangle implements Shap,Color{
    @Override
    public void sayShap() {
        System.out.println("Triangle");
    }

    @Override
    public void sayColor() {
        System.out.println("Green");
    }
}
//--------------------------------------------------利用桥接模式降维----------------------------------

abstract class Shap1{
    //Composition - implementor
    protected Color1 color;
    public Shap1(Color1 c){
        this.color=c;
    }
    abstract public void applyColor();
}
abstract class Color1{
    abstract void color();
}
class Triangle extends Shap1{
    public Triangle(Color1 c) {
        super(c);
    }
    @Override
    public void applyColor() {
        System.out.printf("i am Triangle with");
        this.color.color();
    }
}
class Red extends Color1{
    @Override
    void color() {
        System.out.println(" red ");
    }
}
//新的需求，需要添加一个五角形和黄色
class Yellow extends Color1{
    @Override
    void color() {
        System.out.println(" yellow ");
    }
}
class Pentagon extends Shap1{
    public Pentagon(Color1 c) {
        super(c);
    }
    @Override
    public void applyColor() {
        System.out.printf("i am pentagon with");
        this.color.color();
    }
}







