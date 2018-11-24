/**
* @author ����
* @date 2018��11��23��
* @Title: MatrixMul.java
* @project_name: housework
* @Package com.java.matrixmul
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.java.matrixmul;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @ClassName: MatrixMul
* @Description: �������
* @author ����
* @date 2018��11��23��
*
*/

public class MatrixMul {
	public int[][] matrix1=null; //��һ������
	public int[][] matrix2=null; //�ڶ�������
	public int[][] result=null;  //������˵Ľ��
	public static int m; //��һ�����������
	public static int n; //��һ�����������
	public static int p; //�ڶ������������
	public static int q; //�ڶ������������
	public static int numThread;//�߳�����
	

	
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
	
	//����0-9���������ʼ������
		public void fillRandom(int[][] M) {
			for(int i=0;i<M.length;i++){
				for(int j=0;j<M[i].length;j++)
					M[i][j]=(int)(Math.random()*10);
			}
		}
	

		//���о���˷�����
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
			//���о���˷�����
			Thread[] workers=new Thread[numThread];
			for(int i=0;i<numThread;i++)
				workers[i]=new Thread(new WorkThread(i,matrix1,matrix2,result));//���������߳�
			long time= System.currentTimeMillis();//��¼��ʼʱ��
			for(int i=0;i<numThread;i++){
				workers[i].start();//���������߳�
			}
			for(int i=0;i<numThread;i++){
				try{
					workers[i].join();//�ȴ���ǰ�߳�ִ�н���
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			long time1=System.currentTimeMillis();//��¼����ʱ��
			System.out.println("����["+m+"*"+n+"]��["+p+"*"+q+"]�׾���˷�,���м�����ʱ:"+(time1-time)+"ms");
			return true;
			
//			//ʹ���̳߳ط�����������
//			Thread []poolThreads=new Thread[numThread];//���������߳�
//			for(int i=0;i<numThread;i++)
//				poolThreads[i]=new Thread(new WorkThread(i,matrix1,matrix2,result));
//			//�����̳߳�
//			ExecutorService pool = Executors.newCachedThreadPool();
//			long time2=System.currentTimeMillis();//��¼��ʼʱ��
//			for(int i=0;i<numThread;i++)
//				pool.execute(poolThreads[i]);//�������̷߳����̳߳���ִ��
//			pool.shutdown();//���̳߳���ֹǰ����ִ����ǰ�ύ������
//			while (true) {  
//	            if (pool.isTerminated()) {   
//	                break;  
//	            }
//	        }//��һ����ѭ���ж��̳߳��Ƿ�ִ�����
//			long time3=System.currentTimeMillis();//��¼����ʱ��
//			//��ӡ������ʹ�õ�ʱ��;���C�������λ�õ�ֵ
//			System.out.println("����["+m+"*"+n+"]��["+p+"*"+q+"]�׾���˷�,�̳߳ؼ�����ʱ:"+(time3-time2)+"ms");
//			
			
		}
		
	
	//��������
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
		
		System.out.println("�������һ�������������������");
		m=scan.nextInt();
		n=scan.nextInt();
		System.out.println("������ڶ��������������������");
		p=scan.nextInt();
		q=scan.nextInt();
		System.out.println("������Ҫ�������߳�����");
		numThread=scan.nextInt();
		
		MatrixMul matrixMul=new MatrixMul();
		
		//���Դ���
//		if(matrixMul.singleThread()==null){
//          System.out.println("���������������.");
//      }
//      else{
////    	    long time3=System.currentTimeMillis();//��¼��ʼʱ��
////	  		matrixMul.singleThread();//���ô��м��㺯��
////	  		long time4=System.currentTimeMillis();//��¼����ʱ��
////	  		System.out.println("����["+m+"*"+n+"]��["+p+"*"+q+"]�׾���˷�,ֱ�Ӽ�����ʱ:"+(time4-time3)+"ms");
//    
//          //System.out.println("��˵Ľ����:");
//         // matrixMul.print(matrixMul.matrixMul(matrixMul.matrix1,matrixMul.matrix2)); 
//    
//      }
		
		//���Բ���
		if(matrixMul.multithThread()==true){
			System.out.println("����ɹ�.");
		}else{
			System.out.println("���������������.");
		}

	}
	
}


