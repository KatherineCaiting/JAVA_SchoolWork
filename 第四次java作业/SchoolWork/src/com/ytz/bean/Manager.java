/**
* @author 蔡婷
* @date 2018年10月17日
* @Title: Manager.java
* @project_name: SchoolWork
* @Package sch
* @Description: 经理信息
* @version V1.0
*/


package com.ytz.bean;

import java.util.Scanner;

/**
* @ClassName: Manager
* @Description: 经理信息
* @author 蔡婷
* @date 2018年10月17日
*
*/

public class Manager extends Member{
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
	* 创建一个新的实例 Manager.
	*
	*/
	public Manager() {
		//添加经理姓名和生日月份
				Scanner scanner=new Scanner(System.in);
				System.out.println("请您输入您的名字：");
				setName(scanner.next());
				System.out.println("请您输入您的出生月份：");
				System.out.println("（注：请您正确地输入您的出生月份哦，因为我们公司会在您生日当月为您送上一份精美礼物！）");
				setBirthMonth(scanner.next());
				
				//经理的工资设定
				setBouns((float) (Math.random()*2000));//这里我随便取随机数设定[0,2000)的值;
				setWage(5000+this.getBouns());//基本工资+奖金
	}

}
