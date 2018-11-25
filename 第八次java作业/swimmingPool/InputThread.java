package com.swimmingPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 注水线程
 * Created by captain on 2017/7/27.
 */
public class InputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public InputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while(true){
            boolean flag = true;
            for(int cnt=0;cnt<5;cnt++){
                flag = queue.offer("一立方米");
                System.out.println("线程"+Thread.currentThread().getName()+":"+"注水1立方米");
                if(!flag){
                    break;
                }
            }
            System.out.println("线程"+Thread.currentThread().getName()+":"+"注水5立方米，当前水量："+queue.size());
            if(!flag){
                break;
            }
            TimeUnit.SECONDS.sleep(1);
        }
        return "success";
    }
}
