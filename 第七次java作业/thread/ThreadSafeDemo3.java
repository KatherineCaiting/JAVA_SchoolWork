/**
* @author ����
* @date 2018��11��15��
* @Title: ThreadSafeDemo3.java
* @project_name: SchoolWork
* @Package com.java.thread
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.java.thread;

import java.util.List;

/**
* @ClassName: ThreadSafeDemo3
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��11��15��
*
*/

public class ThreadSafeDemo3 implements Runnable  {

	private List<String> list;

    public ThreadSafeDemo3(List<String> list){
        this.list = list;
    }

    public void run() {
//        while(true){
            if(list.size()>0){
            	System.out.println("�̣߳�"+ Thread.currentThread().getName());
                list.remove(0);
                System.out.println("�̣߳�"+ Thread.currentThread().getName()+"ɾ��һ����ߴ磺"+list.size());
//            }
        }
    }

}
