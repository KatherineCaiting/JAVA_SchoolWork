/**
* @author 蔡婷
* @date 2018年11月15日
* @Title: ThreadSafeDemo1.java
* @project_name: SchoolWork
* @Package com.java.thread
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.java.thread;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
* @ClassName: ThreadSafeDemo1
* @Description: 删除list中的元素
* @author 蔡婷
* @date 2018年11月15日
*
*/

public class ThreadSafeDemo1 implements Runnable {

	private List<String> list;
	

    public ThreadSafeDemo1(List<String> list){
        this.list = list;
    }

   
    public void run() {
       // Random random = new Random();
    	System.out.println("线程："+ Thread.currentThread().getName());
    	synchronized(this){
            Iterator<String> iterator = list.iterator();
            int cnt = 0;
            while(iterator.hasNext()){
                String string=iterator.next();
                list.remove(string);
                cnt++;
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("移除元素的数量："+cnt); 
        }
    }
}

