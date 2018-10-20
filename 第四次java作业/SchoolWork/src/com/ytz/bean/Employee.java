/**
* @author 蔡婷
* @date 2018年10月16日
* @Title: employee.java
* @project_name: SchoolWork
* @Package sch
* @Description:  发工资 
* 程序要求：
* 1.股东有股份，没有当月奖金，但有年终分红（12月份），年终分红为全年利润的10%，全部股东按照股份分红。
* 2.每月发工资时，需给当月生日的员工和经理发礼物，股东没有
* @version V1.0
*/


package com.ytz.bean;

import java.util.Scanner;

/**
* @ClassName: employee
* @Description: 员工类（继承成员类）
* @author 蔡婷
* @date 2018年10月16日
*
*/

public class Employee extends Member {
	/**
	* @Fields 公司成员出生月份
	*/
	private String birthMonth;
	
	/**
	* @Fields 红利
	*/
	private float bouns;
	
	/**
	 * @return the birthMonth
	 */
	public String getBirthMonth() {
		return birthMonth;
	}

	/**
	 * @param birthMonth the birthMonth to set
	 */
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	/**
	 * @return the bouns
	 */
	public float getBouns() {
		return bouns;
	}

	/**
	 * @param bouns the bouns to set
	 */
	public void setBouns(float bouns) {
		this.bouns = bouns;
	}

	
	/**
	* 创建一个新的实例 Employee.
	*
	*/
	public Employee(){
		//添加员工姓名和生日月份
		Scanner scanner=new Scanner(System.in);
		System.out.println("请您输入您的名字：");
		setName(scanner.next());
		System.out.println("请您输入您的出生月份：");
		System.out.println("（注：请您正确地输入您的出生月份哦，因为我们公司会在您生日当月为您送上一份精美礼物！）");
		setBirthMonth(scanner.next());
		
		//员工的工资设定
		setBouns((float) (Math.random()*1000));//这里我随便取随机数设定[0,1000)的值)
		setWage(4000+this.getBouns());//基本工资+奖金
	}

}
