package com.pattern.behavior.state;

/**
 * Created by niexianglin on 2016/9/19 20:12
 * Class Description: 状态模式的核心思想，当对象的状态改变时，同时改变其行为，例如 QQ，有几种状态，在线，隐身，忙碌等，
 *                    每个状态对应不同的操作，而且你的好友也能看到你的状态，所以状态模式就两点：
 *                         可以通过改变状态来获得不同的行为
 *                         你的好友同时也能看到你的变化
 */
public class StateTest {
    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();
    }
}

class State{
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("execute the first opt!");
    }

    public void method2() {
        System.out.println("execute the second opt!");
    }
}

class Context{
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public void method(){
        if(state.getValue().equals("state1")){
            state.method1();
        }else if(state.getValue().equals("state2")){
            state.method2();
        }
    }
}






























