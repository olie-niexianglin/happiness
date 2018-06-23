
package com.pattern.behavior.command;

/**
 * Created by niexianglin on 2016/9/18 21:37
 * Class Description:
 */
public class CommandTest {
    public static void main(String[] args) {
        //创建接受者
        Receiver receiver = new Receiver();
        //创建命令
        Command command = new ConcreteCommand(receiver);
        //创建命令发起者
        Invoker invoker = new Invoker(command);
        //发起命令
        invoker.action();
    }
}
//命令接受者
class Receiver{
    //真正执行命令的方法
    public void action(){
        System.out.println("执行操作");
    }
}
//抽象命令角色
interface Command{
    void execute();
}
//具体命令
class ConcreteCommand implements Command{
    //持有相应接收者对象
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
    }
}
//命令发起者角色
class Invoker{
    private Command command = null;

    public Invoker(Command command) {
        this.command = command;
    }
    public void action(){
        command.execute();
    }
}









