package com.pattern.behavior.proxy.rpc.comm;

import java.io.Serializable;

/**
 * Created by niexianglin on 2016/8/19 20:55
 * Class Description:
 */ //定义Method对象，因为java.lang.reflect。Method类没有实现serializable接口，无法序列化
public class Method implements Serializable {
    private static final long serialVersionUID = 1001L;
    private String methodName;
    private Class[] params;

    public Method(String methodName, Class[] params) {
        this.methodName = methodName;
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParams() {
        return params;
    }

    public void setParams(Class[] params) {
        this.params = params;
    }


}
