/**
* @author 蔡婷
* @date 2018年11月23日
* @Title: WorkThread.java
* @project_name: housework
* @Package com.java.matrixmul
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.java.matrixmul;

/**
* @ClassName: WorkThread
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年11月23日
*
*/

public class WorkThread implements Runnable {
	public int start;//计算开始位置，以此区分工作线程工作任务
	public int[][] matrix1=null; //第一个矩阵
	public int[][] matrix2=null; //第二个矩阵
	public int[][] result=null;  //矩阵相乘的结果
	
	
	//工作线程构造方法
	public WorkThread(int start,int [][]matrix1,int [][]matrix2,int [][]result){
		this.start=start;
		this.matrix1=matrix1;
		this.matrix2=matrix2;
		this.result=result;
	}
	
	
	
	@Override
	public void run() {
		int i,j,k;
		//根据线程数量划分每个工作线程任务
		result=new int[matrix1.length][matrix2[0].length];
		for(i=start; i<MatrixMul.m; i +=MatrixMul.numThread)      
		{      
			for(j=0;j<MatrixMul.m;j++)      
			{   
				int res=0;
				for( k=0; k< MatrixMul.m;k++)         
					res+=matrix1[i][k]*matrix2[k][j];
				result[i][j]=res;
			}
		}
	}

}
