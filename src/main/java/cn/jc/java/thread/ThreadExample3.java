package cn.jc.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample3 {
    static int sum = 0;
    static ThreadLocal<Integer> subsum = new ThreadLocal<>();

    static CountDownLatch countDownLatch = new CountDownLatch(4);
    private static int averageAge2(List<Student> students) throws InterruptedException {
        ExecutorService servers = Executors.newFixedThreadPool(4);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2500000; i++) {
                    subsum.set(subsum.get() + students.get(i).age);
                }
                synchronized(this){
                    sum += subsum.get();
                }
                countDownLatch.countDown();
            }
        };
        servers.submit(task);

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 2500000; i < 5000000; i++) {
                    subsum.set(subsum.get() + students.get(i).age);
                }
                synchronized(this){
                    sum += subsum.get();
                }
                countDownLatch.countDown();
            }
        };
        servers.submit(task2);

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                for (int i = 5000000; i < 7500000; i++) {
                    subsum.set(subsum.get() + students.get(i).age);
                }
                synchronized(this){
                    sum += subsum.get();
                }
                countDownLatch.countDown();
            }
        };
        servers.submit(task3);

        Runnable task4 = new Runnable() {
            @Override
            public void run() {
                for (int i = 7500000; i < 10000000; i++) {
                    subsum.set(subsum.get() + students.get(i).age);
                }
                synchronized(this){
                    sum += subsum.get();
                }
                countDownLatch.countDown();
            }
        };
        servers.submit(task4);
        countDownLatch.await();
        return sum / students.size();
    }


    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 10000000; i++) {
            students.add(new Student("jiangchi" + i, i % 100));
        }
        long start = System.currentTimeMillis();
        int age = averageAge(students);
        long end = System.currentTimeMillis();
        System.out.println("averageAge is " + age + " cost " + (end - start));

        long start2 = System.currentTimeMillis();
        int age2 = averageAge2(students);
        long end2 = System.currentTimeMillis();
        System.out.println("averageAge2 is " + age2 + " cost2 " + (end2 - start2));
    }

    private static int averageAge(List<Student> students) {
        int sum = 0;
        for (Student student : students) {
            sum += student.age;
        }
        return sum / students.size();
    }
}
