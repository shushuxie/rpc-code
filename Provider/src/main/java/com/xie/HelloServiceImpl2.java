package com.xie;

public class HelloServiceImpl2 implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
