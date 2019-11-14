package com.example.demo1.test;

public class Tester{
public static void main(String[] args){
   Integer var1=new Integer(3);
   Integer var2=var1;
   doSomething(var2);
   System.out.print(var1.intValue());
   System.out.print(var1==var2);
}
public static void doSomething(Integer integer){
    integer=new Integer(4);
  }
}