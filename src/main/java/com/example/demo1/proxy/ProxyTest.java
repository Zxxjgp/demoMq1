package com.example.demo1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        TarGetInterface newProxyInstance = (TarGetInterface) Proxy.newProxyInstance(
                Target.class.getClassLoader(), 
                new Class[] {TarGetInterface.class},
                new InvocationHandler() {
                    //invoke 代表的是执行代理对象的方法
                    @Override
                    //method：代表目标对象的方法字节码对象
                    //args:代表目标对象的响应的方法的参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // TODO Auto-generated method stub
                        Object invoke = method.invoke(new Target(), args);
                        return invoke;
                    }
                });
        
        String method1 = newProxyInstance.method1();
        newProxyInstance.method2();
        int method3 = newProxyInstance.method3(100);
        System.out.println(method1);
        System.out.println(method3);
    }
}