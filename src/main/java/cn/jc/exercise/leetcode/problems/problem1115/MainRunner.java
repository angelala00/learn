package cn.jc.exercise.leetcode.problems.problem1115;

class MainRunner {
    public static void main(String[] args) {
        FooBar2 foo = new FooBar2(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("foo:" + Thread.currentThread().getId());
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar:" + Thread.currentThread().getId());
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
    }

}
