/**
* @author 蔡婷
* @date 2018年9月28日
* @Title: Test.java
* @project_name: SchoolWork
* @Package Ytz
* @Description:测试
* @version V1.0
*/


package Ytz;

import java.util.ArrayList;
import java.util.List;

/**
* @ClassName: Test
* @Description: List<Integer> list=new ArrayList<>(1);
		Integer integer=new Integer(10);
		list.add(integer);
		Integer integer1=list.get(0);
                           现在使integer1=3;问list里面的元素是否改变？
* @author 蔡婷
* @date 2018年9月28日
*
*/

public class Test {

	public static void main(String[] args) {
		/*List<Integer> list=new ArrayList<>(1);
		Integer integer=new Integer(10);
		list.add(integer);
		Integer integer1=list.get(0);
		integer1=3;
		
		System.out.println(list);*/
		
		Integer int1=new Integer(10);
		Integer int2=new Integer(10);
		System.out.println(int1==int2);
		//结果是false
		
		Integer int3=new Integer(10);
		Integer int4=new Integer(10);
		System.out.println(int3.equals(int4));
		//结果是true
		
		
		
	}

}
