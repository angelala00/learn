package cn.jc.java.thread;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;

public class ThreadExample {
    private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal();

    public SimpleDateFormat getSDF() {
        SimpleDateFormat sdf = new ThreadExample().threadLocal.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("");
            threadLocal.set(sdf);
        }
        return sdf;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5000);
        int nThreads = 5000;
        ExecutorService pool2 = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        Runnable t1 = null;
        Future<?> f = pool2.submit(t1);
//        pool2.ex
        String s = null;

    }


}


