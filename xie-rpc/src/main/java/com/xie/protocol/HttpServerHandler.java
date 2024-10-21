package com.xie.protocol;

import com.xie.common.Invocation;
import com.xie.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        // 处理请求 接口、方法、参数
        try {
            Invocation invocation = (Invocation)new ObjectInputStream(req.getInputStream()).readObject();
            String interFaceName = invocation.getInterFaceName();
            Class classImpl= LocalRegister.get(interFaceName,"1.0");
            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
            String result = (String)method.invoke(classImpl.newInstance(), invocation.getParameters());

            IOUtils.write(result,resp.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
}
