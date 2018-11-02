/**
* @author 蔡婷
* @date 2018年11月2日
* @Title: ExceptionTest.java
* @project_name: SchoolWork
* @Package com.ytz.test
* @Description: TODO(用一句话描述该文件做什么)
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
* @Description: 在循环语句中的需要抛出异常的代码捕获测试
* @author 蔡婷
* @date 2018年11月2日
*
*/

public class ExceptionTest {
	public static void main(String[] args) {
		SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");
		List<Date> list =new ArrayList<>(10);
		
//		//将捕获异常放在for循环中
//		for(int cnt=0;cnt<10;cnt++){
//			try {
//				Date date = dateformat.parse("09-12");
//				list.add(date);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		//将捕获异常放到循环外
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
