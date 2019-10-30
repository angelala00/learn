package cn.jc.exercise.leetcode.problems.problem1114;

class MainRunner {

    /**
     * @param args 不正确的测试类
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable printFirst = new Runnable() {
            @Override
            public void run() {
                System.out.println("first:" + Thread.currentThread().getId());
            }
        };
        Runnable printSecond = new Runnable() {
            @Override
            public void run() {
                System.out.println("second:" + Thread.currentThread().getId());
            }
        };
        Runnable printThird = new Runnable() {
            @Override
            public void run() {
                System.out.println("third:" + Thread.currentThread().getId());
            }
        };
        foo.first(printSecond);
        foo.first(printFirst);
        foo.first(printThird);
    }

}
