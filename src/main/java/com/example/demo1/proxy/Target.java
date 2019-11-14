package com.example.demo1.proxy;

public class Target implements TarGetInterface{

    @Override
    public String method1() {
        // TODO Auto-generated method stub
        System.out.println("method1 running...");
        return "aaa";
    }

    @Override
    public void method2() {
        // TODO Auto-generated method stub
        System.out.println("method2 running...");
    }

    @Override
    public int method3(int x) {
        // TODO Auto-generated method stub
        return x;
    }

}