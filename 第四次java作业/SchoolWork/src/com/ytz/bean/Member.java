/**
* @author ����
* @date 2018��10��20��
* @Title: Member.java
* @project_name: SchoolWork
* @Package com.ytz.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.ytz.bean;

/**
* @ClassName: Member
* @Description: ��Ա�ࣨ���ࣩ
* @author ����
* @date 2018��10��20��
*
*/

public class Member {

	/**
	* @Fields �������
	*/
	private String idWork;
	/**
	* @Fields ��˾��Ա����
	*/
	private String name;
	/**
	* @Fields ��˾��Ա����
	*/
	private float wage;
	/**
	 * @return the idWork
	 */
	public String getIdWork() {
		return idWork;
	}
	/**
	 * @param idWork the idWork to set
	 */
	public void setIdWork(String idWork) {
		this.idWork = idWork;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the wage
	 */
	public float getWage() {
		return wage;
	}

	/**
	 * @param wage the wage to set
	 */
	public void setWage(float wage) {
		this.wage = wage;
	}
	
}
