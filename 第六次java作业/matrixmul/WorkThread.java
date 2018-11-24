/**
* @author ����
* @date 2018��11��23��
* @Title: WorkThread.java
* @project_name: housework
* @Package com.java.matrixmul
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.java.matrixmul;

/**
* @ClassName: WorkThread
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��11��23��
*
*/

public class WorkThread implements Runnable {
	public int start;//���㿪ʼλ�ã��Դ����ֹ����̹߳�������
	public int[][] matrix1=null; //��һ������
	public int[][] matrix2=null; //�ڶ�������
	public int[][] result=null;  //������˵Ľ��
	
	
	//�����̹߳��췽��
	public WorkThread(int start,int [][]matrix1,int [][]matrix2,int [][]result){
		this.start=start;
		this.matrix1=matrix1;
		this.matrix2=matrix2;
		this.result=result;
	}
	
	
	
	@Override
	public void run() {
		int i,j,k;
		//�����߳���������ÿ�������߳�����
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
