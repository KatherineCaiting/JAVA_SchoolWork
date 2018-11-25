/**
* @author 蔡婷
* @date 2018年11月19日
* @Title: ThreadUtil.java
* @project_name: SchoolWork
* @Package com.swimmingPool
* @Description: TODO(用一句话描述该文件做什么)
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
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年11月19日
*
*/

public class ThreadUtil {

	 private static ExecutorService exec;
	    /**
	     * 线程池管理工具
	     * 传入一组带有返回值的线程，然后由工具类统一管理，并把最终的线程运行集合返回
	     * @param list       线程集合
	     * @param isBlock    是否阻塞标示位，如果为false，则线程启动后立即返回，否则等待所有线程均有结果后返回（推荐使用true）
	     * @return           线程运行结果集合，仅返回已运行结束的线程集合，如都未结束，则返回尺寸为0的list
	     * @throws ExecutionException
	     * @throws InterruptedException
	     */
	    public static List<Object> runCheckCallable(List<Callable<Object>> list, boolean isBlock) throws InterruptedException, ExecutionException {
	        //对参数进行检测
	        if (CheckNull(list)) {
	            return new ArrayList<>();
	        }

	        //初始化线程，打开一个线程池
	        exec = Executors.newCachedThreadPool();
	        //添加线程并返回Future线程
	        List<Future<Object>> futureList = exec.invokeAll(list);

	        if (!isBlock){
	            return new ArrayList<>();
	        }
	        //检查并获取线程返回值
	        return getAllCallableReturn(futureList);
	    }

	    /**
	     * 对方法中传入的参数进行检测
	     * @param list   传入的集合对象
	     * @return       如果检测成功，返回true，反之，返回false
	     */
	    private static boolean CheckNull(List<Callable<Object>> list) {
	        //检测list是否为空
	        if (list==null||list.size()<1){
	            return true;
	        }
	        //检测list中对象是否为空
	        for (Callable callable :list){
	            if (callable==null){
	                return true;
	            }
	        }
	        return false;
	    }

	    /**
	     * 轮询获取所有Callable线程的返回值，直到所有返回值都被获取到（阻塞）
	     * @param futureList     所有线程的管理类集合
	     * @return
	     * @throws ExecutionException
	     * @throws InterruptedException
	     */
	    private static List<Object> getAllCallableReturn(List<Future<Object>> futureList) throws ExecutionException, InterruptedException {
	        List<Object> returnValue = new ArrayList<>(futureList.size());//为了使性能比较好，因此将ArrayList的长度为线程数量
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

