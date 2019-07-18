package com.road.thread;

/**
 * @Describe
 * @Author Road
 * @Date 2019/3/29 16:38
 **/
public class DeprecatedSuspendResume extends Object implements Runnable {
    private volatile int firstVal;
    private volatile int secondVal;

    public static void main(String[] args) {
        DeprecatedSuspendResume deprecatedSuspendResume = new DeprecatedSuspendResume();
        Thread t = new Thread(deprecatedSuspendResume);
        t.start();

        try {
            Thread.sleep(1000);
            System.out.println("currentThread Sleep 1Second");
        } catch (InterruptedException x) {
            System.out.println("thread is interrupt exception");
        }

        for (int i = 0; i < 10; i++) {
            t.interrupt();
            System.out.println("dsr.areValuesEqual()=" + deprecatedSuspendResume.areValuesEqual());
            t.notifyAll();
        }
    }

    /**
     * 判断二者是否相等
     * 
     * @return
     */
    public boolean areValuesEqual() {
        return (firstVal == secondVal);
    }

    @Override
    public void run() {
        try {
            firstVal = 0;
            secondVal = 0;
            wordMethod();
        } catch (InterruptedException e) {
            System.out.println("interrupted while in workMethod()");
        }

    }

    private void wordMethod() throws InterruptedException {
        int val = 1;
        while (true) {
            stepOne(val);
            stepTwo(val);
            val++;
            Thread.sleep(200);
        }
    }

    private void stepTwo(int val) throws InterruptedException {
        firstVal = val;
        Thread.sleep(300);
    }

    private void stepOne(int val) {
        secondVal = val;
    }
}
