package com.example.andre_cuautle_lab_4_;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.lang.Math;


class Consumer extends Thread {
    int max = 50000;

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

    // Fill the array with random numbers

    private final BlockingQueue queue;
    Consumer(BlockingQueue q) { queue = q; }
    double x = 5;

    double a = 3; // Length of one side
    double b = 4;



    double c;

    double y;
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                //y = Math.exp(x);
                consume(queue.take());
                SetUp.getInstance().updateUI();
            }
        } catch (InterruptedException ex) { }
    }
    void consume(Object x) throws InterruptedException {
        int n = 30000000; // produced most satisfactory result after trouble-shooting
      y = factorial(n); // calculates factorial of n 
    }

}
