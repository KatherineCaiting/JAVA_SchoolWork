/**
* @author 蔡婷
* @date 2018年10月17日
* @Title: Shareholder.java
* @project_name: SchoolWork
* @Package sch
* @Description: 股东信息
* @version V1.0
*/


package com.ytz.bean;

import java.util.Scanner;

/**
* @ClassName: Shareholder
* @Description:  股东信息
* @author 蔡婷
* @date 2018年10月17日
*
*/

public class ShareHolder extends Member{
	/**
	* @Fields 红利
	*/
	private float bouns;
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
	* 创建一个新的实例 ShareHolder.
	*
	*/
	public ShareHolder() {
		// TODO Auto-generated constructor stub
		//添加股东姓名和生日月份
		Scanner scanner=new Scanner(System.in);
		System.out.println("请您输入您的名字：");
		setName(scanner.next());
		
		//股东的工资设定
		setBouns((float) (Math.random()*100000*0.1));//年终分红
		setWage(5000+this.getBouns());//基本工资+奖金
	}

	

}
