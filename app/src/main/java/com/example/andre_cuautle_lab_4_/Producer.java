package com.example.andre_cuautle_lab_4_;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.CountDownLatch;

class Producer extends Thread{
    private final BlockingQueue queue;
    Producer(BlockingQueue q) {
        queue = q;
    }
    public static int factorial(int n) {
        // Base case: if n is 0 or 1, return 1
        if (n == 0 || n == 1) {
            return 1;
        }

        int m = 1;
        for (int i=1; i<=n; i++){
            m = (m*i) % 1000000;
        }
        // Recursive case: multiply n with factorial of (n-1)
        return m;
    }
    double x = 5;
    double a = 3; // Length of one side
    double b = 4;

    double c;

    double y;

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // y = Math.exp(x);
                queue.put(produce());
            }
        } catch (InterruptedException ex) {

        }
   //     queue.size();
    }
    Object produce() throws InterruptedException {

        int n = 30000000;
        y = factorial(n);

//        int b  = 1;
//        int max = new Random().nextInt(10);
//        for (long i=0L; i<6000000L; i++){
//            b = (int) ((b * max) % 123456789L);
//        }
//        y = b;
        return 5;
    }
}
