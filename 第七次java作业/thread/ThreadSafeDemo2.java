/**
* @author ����
* @date 2018��11��15��
* @Title: ThreadSafeDemo2.java
* @project_name: SchoolWork
* @Package com.java.thread
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.java.thread;

import java.util.List;

/**
* @ClassName: ThreadSafeDemo2
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��11��15��
*
*/

public class ThreadSafeDemo2 implements Runnable {

	 private List<String> list;

	    public ThreadSafeDemo2(List<String> list){
	        this.list = list;
	    }

	    public void run() {
//	        while(true){
	    	System.out.println("�̣߳�"+ Thread.currentThread().getName());
	            list.add("��Ȩ���������У��κ���ʽת������ϵ���ߡ����ߣ�KY�����ǣ����Զ�����Դ��https://www.douban.com/note/630084526/������ר���о�����è������cat-human communication)����ѧ����Ϊ����ӡ��Ҳ����ȫ�Ǿ�ȷ�ġ����ǵģ�����һ����ʵ���ڵ��о�ѧ�ơ��о�������Ϊ��ѧ������һ�ȱ�ȡ������Ϊ������Ϊ�����о��ı�����һ�������ۣ�anthropomorphism�����������о����ѧ�Ƶ�ѧ���Ѿ�����������Ϊ�ˣ���������Ϊ�о����������ʵ����壩��");
	            System.out.println("�̣߳�"+ Thread.currentThread().getName()+"���һ����ߴ磺"+list.size());
//	        }
	    }

}
