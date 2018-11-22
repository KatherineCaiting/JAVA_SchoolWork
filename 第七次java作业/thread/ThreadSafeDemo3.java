/**
* @author 蔡婷
* @date 2018年11月15日
* @Title: ThreadSafeDemo3.java
* @project_name: SchoolWork
* @Package com.java.thread
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.java.thread;

import java.util.List;

/**
* @ClassName: ThreadSafeDemo3
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年11月15日
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
            	System.out.println("线程："+ Thread.currentThread().getName());
                list.remove(0);
                System.out.println("线程："+ Thread.currentThread().getName()+"删除一个后尺寸："+list.size());
//            }
        }
    }

}
