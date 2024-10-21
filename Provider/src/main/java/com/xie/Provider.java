package com.xie;

import com.xie.common.URL;
import com.xie.protocol.HttpServer;
import com.xie.register.LocalRegister;
import com.xie.register.MapRemoteRegister;

public class Provider {

    public static void main(String[] args) {
        // todo 启动优化
        // 本地注册
//        LocalRegister.register(HelloService.class.getName(),"1.0", HelloServiceImpl.class);
//        LocalRegister.register(HelloService.class.getName(),"2.0", HelloServiceImpl2.class);
//        LocalRegister.registerClass();

        // 远程注册中心注册
        URL url = new URL("localhost",8000);
        MapRemoteRegister.register(HelloService.class.getName(),url);
        // Netty tomcat socket 网络请求
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8000);


    }
}
