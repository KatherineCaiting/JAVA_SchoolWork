/**
* @author ����
* @date 2018��11��15��
* @Title: ThreadSafeDemo1.java
* @project_name: SchoolWork
* @Package com.java.thread
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.java.thread;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
* @ClassName: ThreadSafeDemo1
* @Description: ɾ��list�е�Ԫ��
* @author ����
* @date 2018��11��15��
*
*/

public class ThreadSafeDemo1 implements Runnable {

	private List<String> list;
	

    public ThreadSafeDemo1(List<String> list){
        this.list = list;
    }

   
    public void run() {
       // Random random = new Random();
    	System.out.println("�̣߳�"+ Thread.currentThread().getName());
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
            System.out.println("�Ƴ�Ԫ�ص�������"+cnt); 
        }
    }
}

