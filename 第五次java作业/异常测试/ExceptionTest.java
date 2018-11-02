/**
* @author ����
* @date 2018��11��2��
* @Title: ExceptionTest.java
* @project_name: SchoolWork
* @Package com.ytz.test
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.ytz.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @ClassName: ExceptionTest
* @Description: ��ѭ������е���Ҫ�׳��쳣�Ĵ��벶�����
* @author ����
* @date 2018��11��2��
*
*/

public class ExceptionTest {
	public static void main(String[] args) {
		SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");
		List<Date> list =new ArrayList<>(10);
		
//		//�������쳣����forѭ����
//		for(int cnt=0;cnt<10;cnt++){
//			try {
//				Date date = dateformat.parse("09-12");
//				list.add(date);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		//�������쳣�ŵ�ѭ����
		try{
			for(int cnt=0;cnt<10;cnt++){
				Date date = dateformat.parse("09-12");
				list.add(date);
			}
		}catch (ParseException e){
			e.printStackTrace();
		}
	}

}
