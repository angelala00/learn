package cn.jc.exercise.leetcode.problems.problem1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类 leetcode上执行最快的方案代码
 */

class Foo6 {

    private AtomicInteger atomicInteger;

    public Foo6() {
        atomicInteger = new AtomicInteger();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            if (atomicInteger.compareAndSet(0, 0)) {
                printFirst.run();
                atomicInteger.compareAndSet(0, 1);
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (atomicInteger.compareAndSet(1, 1)) {
                printSecond.run();
                atomicInteger.compareAndSet(1, 2);
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (atomicInteger.compareAndSet(2, 2)) {
                printThird.run();
                atomicInteger.compareAndSet(2, 3);
                break;
            }
        }
    }
}
