package com.leetcode.demo.test1115交替打印;

public class Main {


    public static void main(String[] args) {
        Print print  = new Print();
        FooBar fooBar = new FooBar(2);
        new Thread(()->{
            try {
                fooBar.foo(print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();
        new Thread(()->{
            try {
                fooBar.bar(print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();
    }
}

class Print implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "我的打印");
    }
}