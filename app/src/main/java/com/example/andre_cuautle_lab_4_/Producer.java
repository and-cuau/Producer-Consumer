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
    public static int factorial(int n) { // performs factorial calculation. 
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
                queue.put(produce()); // Add item of arbitrary value to queue
                SetUp.getInstance().updateUI(); // update the UI to display 
            }
        } catch (InterruptedException ex) {

        }
   //     queue.size();
    }
    Object produce() throws InterruptedException {

        int n = 30000000; // produced most satisfactory result after trouble-shooting
        y = factorial(n); // calculate factorial of n to stall program execution

        return 5;
    }
}
