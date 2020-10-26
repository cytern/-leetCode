package test1114按顺序打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    public Foo() {

    }
    Lock lock = new ReentrantLock();
    Condition conditionFirst = lock.newCondition();
    Condition conditionSecond = lock.newCondition();
    Condition conditionThird = lock.newCondition();
    private volatile int num = 1;
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        try {
            lock.lock();
            while (num != 1) {
               conditionFirst.await();
            }
            printFirst.run();
            num = 2;
            conditionSecond.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        try {
            lock.lock();
            while (num != 2){
                conditionSecond.await();
            }
            printSecond.run();
            num = 3;
            conditionThird.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        try {
            lock.lock();
            while (num != 3){
                conditionThird.await();
            }
            printThird.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}