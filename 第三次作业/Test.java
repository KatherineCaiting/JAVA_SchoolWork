/**
* @author ����
* @date 2018��9��28��
* @Title: Test.java
* @project_name: SchoolWork
* @Package Ytz
* @Description:����
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
                           ����ʹinteger1=3;��list�����Ԫ���Ƿ�ı䣿
* @author ����
* @date 2018��9��28��
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
		//�����false
		
		Integer int3=new Integer(10);
		Integer int4=new Integer(10);
		System.out.println(int3.equals(int4));
		//�����true
		
		
		
	}

}
