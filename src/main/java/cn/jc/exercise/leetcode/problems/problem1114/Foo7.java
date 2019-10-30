package cn.jc.exercise.leetcode.problems.problem1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用到了ReentrantLock
 */

class Foo7 {
    private int i = 1;
    private ReentrantLock lock;
    private Condition secondCondition, thirdCondition;

    public Foo7() {
        lock = new ReentrantLock();
        secondCondition = lock.newCondition();
        thirdCondition = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        printFirst.run();
        i = 2;
        secondCondition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (i != 2) {
            secondCondition.await();
        }
        printSecond.run();
        i = 3;
        thirdCondition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (i != 3) {
            thirdCondition.await();
        }
        printThird.run();
        lock.unlock();
    }
}
