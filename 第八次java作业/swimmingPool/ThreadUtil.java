/**
* @author ����
* @date 2018��11��19��
* @Title: ThreadUtil.java
* @project_name: SchoolWork
* @Package com.swimmingPool
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.swimmingPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



/**
* @ClassName: ThreadUtil
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��11��19��
*
*/

public class ThreadUtil {

	 private static ExecutorService exec;
	    /**
	     * �̳߳ع�����
	     * ����һ����з���ֵ���̣߳�Ȼ���ɹ�����ͳһ�����������յ��߳����м��Ϸ���
	     * @param list       �̼߳���
	     * @param isBlock    �Ƿ�������ʾλ�����Ϊfalse�����߳��������������أ�����ȴ������߳̾��н���󷵻أ��Ƽ�ʹ��true��
	     * @return           �߳����н�����ϣ������������н������̼߳��ϣ��綼δ�������򷵻سߴ�Ϊ0��list
	     * @throws ExecutionException
	     * @throws InterruptedException
	     */
	    public static List<Object> runCheckCallable(List<Callable<Object>> list, boolean isBlock) throws InterruptedException, ExecutionException {
	        //�Բ������м��
	        if (CheckNull(list)) {
	            return new ArrayList<>();
	        }

	        //��ʼ���̣߳���һ���̳߳�
	        exec = Executors.newCachedThreadPool();
	        //����̲߳�����Future�߳�
	        List<Future<Object>> futureList = exec.invokeAll(list);

	        if (!isBlock){
	            return new ArrayList<>();
	        }
	        //��鲢��ȡ�̷߳���ֵ
	        return getAllCallableReturn(futureList);
	    }

	    /**
	     * �Է����д���Ĳ������м��
	     * @param list   ����ļ��϶���
	     * @return       ������ɹ�������true����֮������false
	     */
	    private static boolean CheckNull(List<Callable<Object>> list) {
	        //���list�Ƿ�Ϊ��
	        if (list==null||list.size()<1){
	            return true;
	        }
	        //���list�ж����Ƿ�Ϊ��
	        for (Callable callable :list){
	            if (callable==null){
	                return true;
	            }
	        }
	        return false;
	    }

	    /**
	     * ��ѯ��ȡ����Callable�̵߳ķ���ֵ��ֱ�����з���ֵ������ȡ����������
	     * @param futureList     �����̵߳Ĺ����༯��
	     * @return
	     * @throws ExecutionException
	     * @throws InterruptedException
	     */
	    private static List<Object> getAllCallableReturn(List<Future<Object>> futureList) throws ExecutionException, InterruptedException {
	        List<Object> returnValue = new ArrayList<>(futureList.size());//Ϊ��ʹ���ܱȽϺã���˽�ArrayList�ĳ���Ϊ�߳�����
	        while(true){
	        	Iterator<Future<Object>> iterator = futureList.iterator();
	            while(iterator.hasNext()){
	                Future<Object> future = iterator.next();
	                if (future.isDone()){
	                    Object o = future.get();
	                    returnValue.add(o);
	                    iterator.remove();
	                }
	            }
	            if (futureList.size()==0){
	                break;
	            }
	            TimeUnit.MILLISECONDS.sleep(10*1000);
	        }
	        return returnValue;
	    }

}

