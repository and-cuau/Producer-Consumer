package com.example.andre_cuautle_lab_4_;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.RadioButton;
import android.view.View;
import java.util.concurrent.CyclicBarrier;

import android.util.Log;



// import java.thread.utils;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class SetUp extends AppCompatActivity {
    private RadioButton r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50;
    private Button higher, lower;
    TextView tv, tv2;
    int ConsPrior, ProdPrior;

    int size;

    Consumer cons;
    Producer prod;



    RadioButton[] rArray = new RadioButton[50];

    BlockingQueue qt = new ArrayBlockingQueue<>(50);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
        higher = findViewById(R.id.higher);
        lower = findViewById(R.id.lower);

        for (int i = 1; i <= 50; i++) {
            int resId = getResources().getIdentifier("r" + i, "id", getPackageName());
            rArray[i - 1] = findViewById(resId);
        }

        higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProdPrior = prod.getPriority();
                prod.setPriority(ProdPrior + 1);
            }
        });

        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProdPrior = prod.getPriority();
                prod.setPriority(ProdPrior - 1);
            }
        });



        // Your initialization code or other setup goes here
        // For example, you might initialize UI components or set up listeners.
    }

    @Override
    protected void onStart() {
        super.onStart();

        setUpInstance = this;
        cons = new Consumer(qt);
        prod = new Producer(qt);

        CyclicBarrier barrier = new CyclicBarrier(2);


        cons.setPriority(5); // max is 10, min is 1
        prod.setPriority(5);

        new Thread(cons).start();
        new Thread(prod).start();

//        startButtons();

        size = qt.size();

        double x = 20;
        double y;
        int c = 0;

     //   String strC = Integer.toString(c);
     //   tv2.setText(strC);
        // tv2.setText("for loop finished 2");

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Code to resume activities like animations or audio playback
    }






//    public void updateUI() {
//        size = qt.size();
//        String strNum = Integer.toString(size);
//        tv2.setText(strNum);
//        for (int j = 1; j <= size; j++) {
//            int resId = getResources().getIdentifier("r" + j, "id", getPackageName());
//            rArray[j - 1].setChecked(true);
//        }
//    }


    @Override
    protected void onPause() {
        super.onPause();
        // Code to pause ongoing activities like animations or audio playback
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Code to stop ongoing tasks or release resources
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        prod.interrupt();
        cons.interrupt();

        higher.setOnClickListener(null);
        lower.setOnClickListener(null);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Code to handle activity restart
    }

    private Handler uiHandler = new Handler(Looper.getMainLooper());
    private static SetUp setUpInstance = null;
    public static SetUp getInstance(){
        return setUpInstance;
    }

    public void updateUI() {
        uiHandler.post(() -> {
            size = qt.size();
            String strNum = Integer.toString(size);
            tv2.setText(strNum);
            for (int j = 1; j <= size; j++) {
                int resId = getResources().getIdentifier("r" + j, "id", getPackageName());
                rArray[j - 1].setChecked(true);
            }
            for (int m = size + 1; m <= 50; m++) {
                int resId = getResources().getIdentifier("r" + m, "id", getPackageName());
                rArray[m - 1].setChecked(false);
            }
        });
    }
}

