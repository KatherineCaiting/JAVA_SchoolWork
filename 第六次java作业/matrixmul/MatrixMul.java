/**
* @author 蔡婷
* @date 2018年11月23日
* @Title: MatrixMul.java
* @project_name: housework
* @Package com.java.matrixmul
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.java.matrixmul;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @ClassName: MatrixMul
* @Description: 矩阵相乘
* @author 蔡婷
* @date 2018年11月23日
*
*/

public class MatrixMul {
	public int[][] matrix1=null; //第一个矩阵
	public int[][] matrix2=null; //第二个矩阵
	public int[][] result=null;  //矩阵相乘的结果
	public static int m; //第一个矩阵的行数
	public static int n; //第一个矩阵的列数
	public static int p; //第二个矩阵的行数
	public static int q; //第二个矩阵的列数
	public static int numThread;//线程数量
	

	
	public MatrixMul(){
//		int matrix[][]=new int[m][n];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				matrix[i][j]=(int)(Math.random()*5);
//			}
//		}
//		return matrix;
		matrix1=new int[m][n];
		matrix2=new int[p][q];
		fillRandom(matrix1);
		fillRandom(matrix2);
		
	}
	
	//产生0-9的随机数初始化矩阵
		public void fillRandom(int[][] M) {
			for(int i=0;i<M.length;i++){
				for(int j=0;j<M[i].length;j++)
					M[i][j]=(int)(Math.random()*10);
			}
		}
	

		//串行矩阵乘法运算
		public  int[][]singleThread(){
			if(matrix1.length==0||matrix2.length==0||matrix1[0].length!=matrix2.length)
				return null;
			result=new int[matrix1.length][matrix2[0].length];
			for (int i = 0; i < matrix1.length; i++) {
				for (int j = 0; j < matrix2[0].length; j++) {
					int res=0;
					for (int k = 0; k < matrix1[0].length; k++) {
						res+=matrix1[i][k]*matrix2[k][j];
					}
					result[i][j]=res;
				}	
			}
			return result;
		}
		
		public boolean multithThread(){
			if(matrix1.length==0||matrix2.length==0||matrix1[0].length!=matrix2.length)
				return false;
			//并行矩阵乘法运算
			Thread[] workers=new Thread[numThread];
			for(int i=0;i<numThread;i++)
				workers[i]=new Thread(new WorkThread(i,matrix1,matrix2,result));//建立工作线程
			long time= System.currentTimeMillis();//记录开始时间
			for(int i=0;i<numThread;i++){
				workers[i].start();//启动工作线程
			}
			for(int i=0;i<numThread;i++){
				try{
					workers[i].join();//等待当前线程执行结束
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			long time1=System.currentTimeMillis();//记录结束时间
			System.out.println("计算["+m+"*"+n+"]与["+p+"*"+q+"]阶矩阵乘法,并行计算用时:"+(time1-time)+"ms");
			return true;
			
//			//使用线程池方法进行运算
//			Thread []poolThreads=new Thread[numThread];//建立工作线程
//			for(int i=0;i<numThread;i++)
//				poolThreads[i]=new Thread(new WorkThread(i,matrix1,matrix2,result));
//			//建立线程池
//			ExecutorService pool = Executors.newCachedThreadPool();
//			long time2=System.currentTimeMillis();//记录开始时间
//			for(int i=0;i<numThread;i++)
//				pool.execute(poolThreads[i]);//将工作线程放入线程池中执行
//			pool.shutdown();//在线程池终止前允许执行以前提交的任务
//			while (true) {  
//	            if (pool.isTerminated()) {   
//	                break;  
//	            }
//	        }//用一个死循环判断线程池是否执行完成
//			long time3=System.currentTimeMillis();//记录结束时间
//			//打印方法二使用的时间和矩阵C三个随机位置的值
//			System.out.println("计算["+m+"*"+n+"]与["+p+"*"+q+"]阶矩阵乘法,线程池计算用时:"+(time3-time2)+"ms");
//			
			
		}
		
	
	//矩阵的输出
	public void print(int [][]matrix){
        if(matrix.length!=0){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
	
	public static void main(String []args){
		
		
		Scanner scan =new Scanner(System.in);
		
		System.out.println("请输入第一个矩阵的行数和列数：");
		m=scan.nextInt();
		n=scan.nextInt();
		System.out.println("请输入第二个矩阵的行数和列数：");
		p=scan.nextInt();
		q=scan.nextInt();
		System.out.println("请输入要开启的线程数：");
		numThread=scan.nextInt();
		
		MatrixMul matrixMul=new MatrixMul();
		
		//测试串行
//		if(matrixMul.singleThread()==null){
//          System.out.println("这两个矩阵不能相乘.");
//      }
//      else{
////    	    long time3=System.currentTimeMillis();//记录开始时间
////	  		matrixMul.singleThread();//调用串行计算函数
////	  		long time4=System.currentTimeMillis();//记录结束时间
////	  		System.out.println("计算["+m+"*"+n+"]与["+p+"*"+q+"]阶矩阵乘法,直接计算用时:"+(time4-time3)+"ms");
//    
//          //System.out.println("相乘的结果是:");
//         // matrixMul.print(matrixMul.matrixMul(matrixMul.matrix1,matrixMul.matrix2)); 
//    
//      }
		
		//测试并行
		if(matrixMul.multithThread()==true){
			System.out.println("计算成功.");
		}else{
			System.out.println("这两个矩阵不能相乘.");
		}

	}
	
}


