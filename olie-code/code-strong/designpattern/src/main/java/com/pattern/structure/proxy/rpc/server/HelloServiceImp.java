package com.pattern.structure.proxy.rpc.server;

import com.pattern.structure.proxy.rpc.comm.HelloService;

/**
 * Created by niexianglin on 2016/8/19 20:54
 * Class Description:
 */
class HelloServiceImp implements HelloService {

    public Object sayHello() {
        return new String("Hello Olie");
    }
}
