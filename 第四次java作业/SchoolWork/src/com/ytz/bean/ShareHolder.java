/**
* @author ����
* @date 2018��10��17��
* @Title: Shareholder.java
* @project_name: SchoolWork
* @Package sch
* @Description: �ɶ���Ϣ
* @version V1.0
*/


package com.ytz.bean;

import java.util.Scanner;

/**
* @ClassName: Shareholder
* @Description:  �ɶ���Ϣ
* @author ����
* @date 2018��10��17��
*
*/

public class ShareHolder extends Member{
	/**
	* @Fields ����
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
	* ����һ���µ�ʵ�� ShareHolder.
	*
	*/
	public ShareHolder() {
		// TODO Auto-generated constructor stub
		//��ӹɶ������������·�
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������������֣�");
		setName(scanner.next());
		
		//�ɶ��Ĺ����趨
		setBouns((float) (Math.random()*100000*0.1));//���շֺ�
		setWage(5000+this.getBouns());//��������+����
	}

	

}
