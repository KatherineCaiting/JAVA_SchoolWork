/**
* @author ����
* @date 2018��10��31��
* @Title: Control.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.ytz.trans;

import java.util.Scanner;

/**
* @ClassName: Control
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��10��31��
*
*/

public class Control {

	public static void main(String[] args) {
		Translation car=new Car();
		Translation highSpeedRailWay=new HighSpeedRailway();
		Translation airplane=new AirPlane();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�����������:");
		String departure=sc.nextLine();
		System.out.print("Ŀ�ĵ�:");
		String arrival=sc.nextLine();
		System.out.println("���������ؼ����(��λ������):");
		double distance=sc.nextDouble();
		
		System.out.println("----------------");
		car.printConsume(distance);
		System.out.println("----------------");
		highSpeedRailWay.printConsume(distance);
		System.out.println("----------------");
		airplane.printConsume(distance);
		
	}

}
