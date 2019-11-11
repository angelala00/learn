package cn.jc.exercise.leetcode.problems.problem1115;

class FooBar {
    private int n;
    private int on = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (on != 0) {
                    this.wait();
                }
                printFoo.run();
                on = 1;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (on != 1) {
                    this.wait();
                }
                printBar.run();
                on = 0;
                this.notifyAll();
            }
        }
    }
}
