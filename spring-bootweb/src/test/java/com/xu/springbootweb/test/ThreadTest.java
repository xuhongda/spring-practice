package com.xu.springbootweb.test;

/**
 * @author xuhongda on 2018/8/9
 * com.xu.springbootweb.test
 * spring-practice
 */
public class ThreadTest {

    private static int i = 99999999;

    private void fun(){
        Runnable runnable = this::func;
        runnable.run();
        Thread thread1= new Thread(runnable,"xx1");
        Thread thread2 = new Thread(runnable,"xx2");
        Thread thread3 = new Thread(runnable,"xx3");
        Thread thread4 = new Thread(runnable,"xx3");
        Thread thread5 = new Thread(runnable,"xx4");
        Thread thread6 = new Thread(runnable,"xx4");
        Thread thread7 = new Thread(runnable,"xx4");
        Thread thread8 = new Thread(runnable,"xx4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
    }

    private void func() {
        while (i>0){
            System.out.println("还有余票"+i--);
        }
    }

    public static void main(String[] args) {
        new ThreadTest().fun();
    }
}
