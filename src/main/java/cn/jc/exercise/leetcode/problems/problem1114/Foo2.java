package cn.jc.exercise.leetcode.problems.problem1114;

class Foo2 {
    int i = 0;

    public Foo2() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            i = 1;
            //与this.notifyAll();等效？
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (i != 1) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            i = 2;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (i != 2) {
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            i = 3;
        }
    }
}
