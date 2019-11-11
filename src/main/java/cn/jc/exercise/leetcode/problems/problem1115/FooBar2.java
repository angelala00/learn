package cn.jc.exercise.leetcode.problems.problem1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar2 {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private int flag = 0;
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            while (flag != 0) {
                fooCondition.await();
            }
            printFoo.run();
            flag = 1;
            barCondition.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            while (flag != 1) {
                barCondition.await();
            }
            printBar.run();
            flag = 0;
            fooCondition.signal();
            lock.unlock();
        }
    }
}
