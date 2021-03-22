package com.example.transapp_back2;

import java.lang.reflect.Method;

public interface TestForPrivateMethod {

    default Object doPrivateMethod(
            Object object, String name, Class[] types, Object[] args) throws Exception{
        Method method = object.getClass().getDeclaredMethod(name, types);
        method.setAccessible(true);
        return method.invoke(object, args);
    }


}
