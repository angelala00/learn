package cn.jc.exercise.leetcode.problems.problem1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类 leetcode能通过，但断点能判断出是错的
 */

class Foo5 {
    private AtomicInteger i;

    public Foo5() {
        i = new AtomicInteger(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // 如果i的值是1则将i的值设置为2，这涉及到CAS操作的，不懂的可以看前面给的链接
        while (!i.compareAndSet(1,2));
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!i.compareAndSet(2,3));
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while (!i.compareAndSet(3,4));
        printThird.run();
    }
}
