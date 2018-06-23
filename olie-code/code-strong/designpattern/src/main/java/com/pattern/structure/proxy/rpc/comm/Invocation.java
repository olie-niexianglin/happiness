package com.pattern.structure.proxy.rpc.comm;

import java.io.Serializable;


//调用封装数据类
public class Invocation implements Serializable {
    private static final long serialVersionUID = 10001L;

    private Class interfaces;
    private Method method;
    private Object[] params;
    private Object result;

    public Class getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class interfaces) {
        this.interfaces = interfaces;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

