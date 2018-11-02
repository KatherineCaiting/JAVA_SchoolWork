/**
* @author 蔡婷
* @date 2018年10月31日
* @Title: Control.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.ytz.trans;

import java.util.Scanner;

/**
* @ClassName: Control
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年10月31日
*
*/

public class Control {

	public static void main(String[] args) {
		Translation car=new Car();
		Translation highSpeedRailWay=new HighSpeedRailway();
		Translation airplane=new AirPlane();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入出发地:");
		String departure=sc.nextLine();
		System.out.print("目的地:");
		String arrival=sc.nextLine();
		System.out.println("请输入两地间距离(单位：公里):");
		double distance=sc.nextDouble();
		
		System.out.println("----------------");
		car.printConsume(distance);
		System.out.println("----------------");
		highSpeedRailWay.printConsume(distance);
		System.out.println("----------------");
		airplane.printConsume(distance);
		
	}

}
