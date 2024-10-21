package com.xie;

import com.xie.common.Invocation;
import com.xie.protocol.HttpClient;
import com.xie.proxy.ProxyFactory;

import java.net.MalformedURLException;

public class Consumer {

    public static void main(String[] args) throws MalformedURLException {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("xie");
        System.out.println(result);

    }
}
