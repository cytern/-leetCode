package com.leetcode.demo.test1115交替打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }
     Lock lock = new ReentrantLock();
     Condition condition1 = lock.newCondition();
     Condition condition2 = lock.newCondition();
     private int num = 0;
    public void foo(Runnable printFoo) throws InterruptedException {

        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                while (num != 0){
                    condition1.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                num = 1;
                condition2.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
               while (num != 1){
                   condition2.await();
               }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
               num = 0;
               condition1.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
