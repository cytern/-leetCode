package test1114按顺序打印;

public class Run {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Print print = new Print();
        try {
            for (int i = 0;i<1;i++) {
                new Thread(()->{
                    try {
                        foo.first(print);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"a").start();
            }
            for (int i = 0;i<1;i++) {
                new Thread(()->{
                    try {
                        foo.second(print);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"b").start();
            }
            for (int i = 0;i<1;i++) {
                new Thread(()->{
                    try {
                        foo.third(print);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"c").start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Print implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "打印出了");
    }
}
