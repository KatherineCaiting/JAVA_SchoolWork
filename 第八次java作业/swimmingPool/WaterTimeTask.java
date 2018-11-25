package com.swimmingPool;


import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 定期放水类
 * Created by captain on 2017/7/27.
 */
public class WaterTimeTask extends TimerTask {

    @Override
    public void run() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10000);
        InputThread thread1 = new InputThread(queue);
        OutputThread thread2 = new  OutputThread(queue);
        OutputThread thread3 = new  OutputThread(queue);
        OutputThread thread4 = new OutputThread(queue);
        OutputThread thread5 = new OutputThread(queue);
        List<Callable<Object>> threadList = new ArrayList<>(5);
        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        threadList.add(thread4);
        threadList.add(thread5);
        List<Object> returnValue = null;
        try {
			returnValue = ThreadUtil.runCheckCallable(threadList,true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("泳池已经注满");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
        System.out.println(returnValue.get(2));
        System.out.println(returnValue.get(3));
        System.out.println(returnValue.get(4));
       
    }
}
