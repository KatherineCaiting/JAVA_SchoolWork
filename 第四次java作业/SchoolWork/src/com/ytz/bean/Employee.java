/**
* @author ����
* @date 2018��10��16��
* @Title: employee.java
* @project_name: SchoolWork
* @Package sch
* @Description:  ������ 
* ����Ҫ��
* 1.�ɶ��йɷݣ�û�е��½��𣬵������շֺ죨12�·ݣ������շֺ�Ϊȫ�������10%��ȫ���ɶ����չɷݷֺ졣
* 2.ÿ�·�����ʱ������������յ�Ա���;�������ɶ�û��
* @version V1.0
*/


package com.ytz.bean;

import java.util.Scanner;

/**
* @ClassName: employee
* @Description: Ա���ࣨ�̳г�Ա�ࣩ
* @author ����
* @date 2018��10��16��
*
*/

public class Employee extends Member {
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
	* ����һ���µ�ʵ�� Employee.
	*
	*/
	public Employee(){
		//���Ա�������������·�
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������������֣�");
		setName(scanner.next());
		System.out.println("�����������ĳ����·ݣ�");
		System.out.println("��ע��������ȷ���������ĳ����·�Ŷ����Ϊ���ǹ�˾���������յ���Ϊ������һ�ݾ��������");
		setBirthMonth(scanner.next());
		
		//Ա���Ĺ����趨
		setBouns((float) (Math.random()*1000));//���������ȡ������趨[0,1000)��ֵ)
		setWage(4000+this.getBouns());//��������+����
	}

}
