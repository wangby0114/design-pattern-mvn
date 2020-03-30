package com.wangby.collections;

import java.util.concurrent.*;

public class T11_FutureTask {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<String>(new Callable() {
            @Override
            public Object call() throws Exception {
                TimeUnit.SECONDS.sleep(4);
                return "hello FutureTask";
            }
        });

        ExecutorService service = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        service.submit(task);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        System.out.println("--------");

        try {
            start = System.currentTimeMillis();
            System.out.println(task.get());
            end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
