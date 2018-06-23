package com.pattern.structure.adapter;

/**
 * Created by niexianglin on 2016/9/3 10:01
 * Class Description:
 */
public class AdapterTest {
    public static void main(String[] args) {
        Finlan2Chian_SocketAdapter finlan2Chian_socketAdapter = new Finlan2Chian_SocketAdapter();
        finlan2Chian_socketAdapter.setChinaSocket(new ChinaSocket() {
            public void sayHello2XingFu() {
                System.out.println("Hello xiaoXingFu i am China Socket Successful Connection");
            }
        });
        OlieHotel hotel = new OlieHotel(finlan2Chian_socketAdapter);
        hotel.charge();












    }
}

/*
     Adapter定义
    将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。
    适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。


    举例上下文：小幸福发了工资，想着去芬兰玩一把，看看诺基亚的起源地是一个怎样的国度
    9.12：出发
    9.13：到达了芬兰格思兰国际机场
    9.13：到达 Olie 国际酒店
          来到酒店的第一件事，就是给亲朋好友报个平安，刚拿起电话却发现手机没电了，擦，还好带了充电器，立马去充电。
          找到插座之后，小幸福发现有点不对喽，这里的插座接口为什么是圆型的呢？我们国家的插座接口都是扁平型的，这可如何是好呢？
          不知所措中………………

          OlieHotel hotel = new OlieHotel(new OlieSocket());
          hotel.charge();

          现在的问题是，小幸福的充电器无法插入到 OlieHotel 的 OlieSocket 插座中，也就无法执行上述的操作，因为他需要下面的形式
          OlieHotel hotel = new OlieHotel(new ChinaSocket());
          hotel.charge();
          即，小幸福希望 OlieHotel 中可以有一个 中国标准的插座，这样就可以和自己的充电线联系起来了

          问题描述：
          目前可用的资源：芬兰式插座
          目前遇到的问题：中国式充电线无法连接到芬兰式插座上去，即无法直接利用旧的接口

          小幸福投入到思考中去了：
          噔噔……，如果有一个转接口不久好了吗？把手机充电线插入到转接器上，转接器插入到不好用的 Finland 插座上去，哈哈，真聪明

     9.13 来打酒店前台，索要转接线 Finlan2China
     9.13 可以充电了，哈哈，真聪明，立马打电话给亲朋好友…………幸福中。

 */

/*
    芬兰的插座接口：规定了Finland所有插座的标准
 */
interface FinlandSocket{
    void sayHello2XingFu();
}
/*
    Olie酒店里的插座：这是小幸福必须使用的Finland式插座，因为这里是Finland。
 */
class OlieSocket implements FinlandSocket{
    public void sayHello2XingFu() {
        System.out.println("Hello xiaoXingFu i am Finland Socket Successful Connection");
    }
}





/*
    中国的插座：定了中国所有插座的标准
 */
interface ChinaSocket{
    void sayHello2XingFu();
}


/*
    OlieHotel:
 */
class OlieHotel{
    //拥有Feland插座
    FinlandSocket finlandSocket;
    public OlieHotel(FinlandSocket socket) {
        this.finlandSocket = socket;
    }
    //提供充电功能
    public void charge(){
        finlandSocket.sayHello2XingFu();
    }
}

/*
    适配器:是时候出场了，不然小幸福该着急哭了。
 */
//实现 FinlandSocket 原接口
//现在通过Finlan2Chian_SocketAdapter想访客提供充电服务
class Finlan2Chian_SocketAdapter implements FinlandSocket{

    //组合 China式 插座
    private ChinaSocket chinaSocket;

    public void setChinaSocket(ChinaSocket chinaSocket) {
        this.chinaSocket = chinaSocket;
    }

    //而在小幸福看来，我的手机充电线是插在中国式插口上的，有中国式插口提供充电
    public void sayHello2XingFu() {
        chinaSocket.sayHello2XingFu();
    }
}








