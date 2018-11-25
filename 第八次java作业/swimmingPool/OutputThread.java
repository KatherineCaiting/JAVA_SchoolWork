package com.swimmingPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 放水线程
 * Created by captain on 2017/7/27.
 */
public class OutputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while(true){
            if(queue.size()==10000){
                break;
            }
            for(int cnt=0;cnt<3;cnt++){
            	System.out.println("-----"+"线程"+Thread.currentThread().getName()+":"+"正要放水中----");
                queue.poll(10,TimeUnit.SECONDS);
                System.out.println("线程"+Thread.currentThread().getName()+":"+"放了1立方米");
            }
            System.out.println("线程"+Thread.currentThread().getName()+":"+"放水3立方米，当前水量："+queue.size());
            TimeUnit.SECONDS.sleep(1);
        }
        return "success";
    }
}
