package cn.jc.java.thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5000);
        int nThreads = 5000;
        ExecutorService pool2 = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

}


