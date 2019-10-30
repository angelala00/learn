package cn.jc.exercise.leetcode.problems.problem1114;

/**
 * Time Limit Exceeded
 */
class Foo3 {
    int i = 0;

    public Foo3() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (i == 1) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                i = 2;
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (i == 2) {
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                i = 3;
                break;
            }
        }
    }
}
