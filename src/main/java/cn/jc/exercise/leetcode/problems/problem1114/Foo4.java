package cn.jc.exercise.leetcode.problems.problem1114;

/**
 * 如果不加volatile的话，会Time Limit Exceeded，这里理解的不是很透
 */
class Foo4 {
    private volatile int i = 0;

    public Foo4() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i != 1) ;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i != 2) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        i = 3;
    }
}
