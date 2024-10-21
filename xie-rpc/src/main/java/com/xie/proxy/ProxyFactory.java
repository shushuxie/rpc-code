package com.xie.proxy;

import com.xie.common.Invocation;
import com.xie.common.URL;
import com.xie.loadbalance.LoadBalance;
import com.xie.protocol.HttpClient;
import com.xie.register.MapRemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

public class ProxyFactory {

   public static <T> T getProxy(Class interfaceClass) {

       Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(),
               new Class[]{interfaceClass},
               new InvocationHandler() {
                   @Override
                   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       Invocation invocation = new Invocation(interfaceClass.getName(),
                               method.getName(),
                               method.getParameterTypes(),
                               args);
                       HttpClient httpClient = new HttpClient();
                       // 服务发现
                       List<URL> urls = MapRemoteRegister.get(interfaceClass.getName());
                       // 负载均衡
                       URL url = LoadBalance.random(urls);
                       // 服务调用
                       String result= httpClient.send(url.getHostname(), url.getPort(), invocation);
                       return result;
                   }
               });
       return (T) proxyInstance;

   }

}
