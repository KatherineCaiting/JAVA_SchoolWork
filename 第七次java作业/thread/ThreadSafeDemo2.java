/**
* @author 蔡婷
* @date 2018年11月15日
* @Title: ThreadSafeDemo2.java
* @project_name: SchoolWork
* @Package com.java.thread
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.java.thread;

import java.util.List;

/**
* @ClassName: ThreadSafeDemo2
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年11月15日
*
*/

public class ThreadSafeDemo2 implements Runnable {

	 private List<String> list;

	    public ThreadSafeDemo2(List<String> list){
	        this.list = list;
	    }

	    public void run() {
//	        while(true){
	    	System.out.println("线程："+ Thread.currentThread().getName());
	            list.add("版权归作者所有，任何形式转载请联系作者。作者：KY主创们（来自豆瓣来源：https://www.douban.com/note/630084526/不过，专门研究“人猫交流（cat-human communication)”的学者认为这种印象也不完全是精确的——是的，这是一个真实存在的研究学科。研究宠物行为的学科曾经一度被取消，因为人们认为这种研究的本质是一种拟人论（anthropomorphism），但现在研究这个学科的学者已经不再这样认为了（即宠物行为研究有其自身本质的意义）。");
	            System.out.println("线程："+ Thread.currentThread().getName()+"添加一个后尺寸："+list.size());
//	        }
	    }

}
