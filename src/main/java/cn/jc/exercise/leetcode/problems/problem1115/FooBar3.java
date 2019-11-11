package cn.jc.exercise.leetcode.problems.problem1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar3 {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    int flag = 0;
    Condition fooC = lock.newCondition();
    Condition barC = lock.newCondition();

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (flag == 1) {
                    barC.await();
                }
                flag = 1;
                fooC.signalAll();
                printFoo.run();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (flag == 0) {
                    fooC.await();
                }
                flag = 0;
                barC.signalAll();
                printBar.run();
            } finally {
                lock.unlock();
            }
        }
    }
}
