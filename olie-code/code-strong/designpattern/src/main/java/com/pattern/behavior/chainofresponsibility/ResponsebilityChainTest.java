package com.pattern.behavior.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by niexianglin on 2016/9/15 10:30
 * Class Description:
 */
public class ResponsebilityChainTest {
    public static void main(String[] args) {
        //创建待处理对象
        Request requet = new Request("sa333333A");

        //创建处理结果对象
        Response response = new Response();

        //创建责任链对象
        HandlerChain handlerChain = new HandlerChain();

        //向责任链中添加具体处理对象
        handlerChain.addHandler(new LengthHandler());
        handlerChain.addHandler(new CapitalHandler());

        //开始处理待处理对象
        boolean ss = handlerChain.doHandler(requet,response);

        //打印处理结果
        for(String result : response.getResults()){
            System.out.println(result);
        }


    }
}

//被处理的责任对象

class Request{

    private String name;
    public String getName() {
        return name;
    }
    public Request(String name) {
        this.name = name;
    }

}
//被处理后的结果类 辅助理解
class Response{
    private List<String> results;

    public Response() {
        this.results = new ArrayList<String>();
    }

    public List<String> getResults() {
        return results;
    }

    public void addResults(String result){
        this.results.add(result);
    }
}
//责任链类
class HandlerChain{
    private int currentHandler=-1;
    private List<Handler> handlers = new ArrayList<Handler>();
    public void addHandler(Handler handler){
        handlers.add(handler);
    }

    public boolean doHandler(Request request, Response response) {
        if(this.handlers.size()>0){
            currentHandler++;
            if(currentHandler<this.handlers.size()){
                if(!this.handlers.get(currentHandler).doHandler(request,response,this)){
                    return false;
                }
            }
        }
        return true;
    }
}

//抽象责任
interface Handler {
    boolean doHandler(Request request,Response response,HandlerChain handlerChain);
}
//具体责任 -- 长度检查
class LengthHandler implements Handler{

    public boolean doHandler(Request request,Response response, HandlerChain handlerChain) {
        System.out.println("the handler of lengthhandler before");
        if(request.getName().length()>10){
            response.addResults("请求长度大于十，不合理.");
            return false;
        }
        handlerChain.doHandler(request,response);
        System.out.println("the handler of lengthhandler after");
        return true;
    }
}
//具体责任 -- 过滤是否有大写字母
class CapitalHandler implements Handler{

    public boolean doHandler(Request request,Response response, HandlerChain handlerChain) {
        System.out.println("the handler of CapitalHandler before");
        if(request.getName().length()>3){
            response.addResults("请求数据中存在大写字母，不合理");
            return false;
        }
        handlerChain.doHandler(request,response);
        System.out.println("the handler of CapitalHandler after");
        return true;
    }
}
