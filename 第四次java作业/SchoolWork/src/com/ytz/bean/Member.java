/**
* @author 蔡婷
* @date 2018年10月20日
* @Title: Member.java
* @project_name: SchoolWork
* @Package com.ytz.bean
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.ytz.bean;

/**
* @ClassName: Member
* @Description: 成员类（父类）
* @author 蔡婷
* @date 2018年10月20日
*
*/

public class Member {

	/**
	* @Fields 工作编号
	*/
	private String idWork;
	/**
	* @Fields 公司成员名字
	*/
	private String name;
	/**
	* @Fields 公司成员工资
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
