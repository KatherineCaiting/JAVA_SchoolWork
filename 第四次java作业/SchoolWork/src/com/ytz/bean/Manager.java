/**
* @author ����
* @date 2018��10��17��
* @Title: Manager.java
* @project_name: SchoolWork
* @Package sch
* @Description: ������Ϣ
* @version V1.0
*/


package com.ytz.bean;

import java.util.Scanner;

/**
* @ClassName: Manager
* @Description: ������Ϣ
* @author ����
* @date 2018��10��17��
*
*/

public class Manager extends Member{
	/**
	* @Fields ��˾��Ա�����·�
	*/
	private String birthMonth;
	
	
	/**
	* @Fields ����
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
	* ����һ���µ�ʵ�� Manager.
	*
	*/
	public Manager() {
		//��Ӿ��������������·�
				Scanner scanner=new Scanner(System.in);
				System.out.println("���������������֣�");
				setName(scanner.next());
				System.out.println("�����������ĳ����·ݣ�");
				System.out.println("��ע��������ȷ���������ĳ����·�Ŷ����Ϊ���ǹ�˾���������յ���Ϊ������һ�ݾ��������");
				setBirthMonth(scanner.next());
				
				//����Ĺ����趨
				setBouns((float) (Math.random()*2000));//���������ȡ������趨[0,2000)��ֵ;
				setWage(5000+this.getBouns());//��������+����
	}

}
