package com.xie.common;

import java.io.Serializable;

public class Invocation implements Serializable {

    private String InterFaceName;
    private String methodName;
    private Class[] parameterTypes;
    private Object[] parameters;

    public Invocation(String interFaceName, String methodName, Class[] parameterTypes, Object[] parameters) {
        InterFaceName = interFaceName;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.parameters = parameters;
    }

    public String getInterFaceName() {
        return InterFaceName;
    }

    public void setInterFaceName(String interFaceName) {
        InterFaceName = interFaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
