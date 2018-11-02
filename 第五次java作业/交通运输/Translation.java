/**
* @author 蔡婷
* @date 2018年10月28日
* @Title: Translation.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.ytz.trans;

import java.util.ArrayList;
import java.util.Date;

/**
* @ClassName: Translation
* @Description: 交通工具抽象类
* @author 蔡婷
* @date 2018年10月28日
*
*/

public abstract class Translation {
	/**
	* @Fields 交通方式名称
	*/
	private String trafficWay;
	/**
	* @Fields 到车站时间
	*/
	private Date arriveTime;
	/**
	* @Fields 从车站返回时间
	*/
	private Date returnTime;
	/**
	* @Fields 取票时间
	*/
	private Date timeForTakingTickets;
	/**
	* @Fields 安检时间
	*/
	private Date securityTime;
	/**
	* @Fields 停车时间
	*/
	private Date cutoffInterval;
	/**
	* @Fields 车速
	*/
	private double speedOfMotorVehicle;
	/**
	* @Fields 单价
	*/
	private double unitPrice;
	
	
	/**
	 * @return the trafficWay
	 */
	public String getTrafficWay() {
		return trafficWay;
	}

	/**
	 * @param trafficWay the trafficWay to set
	 */
	public void setTrafficWay(String trafficWay) {
		this.trafficWay = trafficWay;
	}

	/**
	 * @return the arriveTime
	 */
	public Date getArriveTime() {
		return arriveTime;
	}

	/**
	 * @param arriveTime the arriveTime to set
	 */
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	/**
	 * @return the returnTime
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * @param returnTime the returnTime to set
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * @return the timeForTakingTickets
	 */
	public Date getTimeForTakingTickets() {
		return timeForTakingTickets;
	}

	/**
	 * @param timeForTakingTickets the timeForTakingTickets to set
	 */
	public void setTimeForTakingTickets(Date timeForTakingTickets) {
		this.timeForTakingTickets = timeForTakingTickets;
	}

	/**
	 * @return the securityTime
	 */
	public Date getSecurityTime() {
		return securityTime;
	}

	/**
	 * @param securityTime the securityTime to set
	 */
	public void setSecurityTime(Date securityTime) {
		this.securityTime = securityTime;
	}

	/**
	 * @return the cutoffInterval
	 */
	public Date getCutoffInterval() {
		return cutoffInterval;
	}

	/**
	 * @param cutoffInterval the cutoffInterval to set
	 */
	public void setCutoffInterval(Date cutoffInterval) {
		this.cutoffInterval = cutoffInterval;
	}

	/**
	 * @return the speedOfMotorVehicle
	 */
	public double getSpeedOfMotorVehicle() {
		return speedOfMotorVehicle;
	}

	/**
	 * @param speedOfMotorVehicle the speedOfMotorVehicle to set
	 */
	public void setSpeedOfMotorVehicle(double speedOfMotorVehicle) {
		this.speedOfMotorVehicle = speedOfMotorVehicle;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	* 创建一个新的实例 Translation.
	*
	* @param trafficWay
	* @param arriveTime
	* @param returnTime
	* @param timeForTakingTickets
	* @param securityTime
	* @param cutoffInterval
	* @param speedOfMotorVehicle
	* @param unitPrice
	*/
	
	public Translation(String trafficWay, Date arriveTime, Date returnTime, Date timeForTakingTickets,
			Date securityTime, Date cutoffInterval, double speedOfMotorVehicle, double unitPrice) {
		super();
		this.trafficWay = trafficWay;
		this.arriveTime = arriveTime;
		this.returnTime = returnTime;
		this.timeForTakingTickets = timeForTakingTickets;
		this.securityTime = securityTime;
		this.cutoffInterval = cutoffInterval;
		this.speedOfMotorVehicle = speedOfMotorVehicle;
		this.unitPrice = unitPrice;
	}

	/**
	* 创建一个新的实例 Translation.
	*
	*/
	
	public Translation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	* @Title: consume
	* @Description: 消耗的时间和价格
	* @param @param distance 
	* @param @return    参数
	* @return ArrayList<String>    返回类型
	* @throws
	*/
	public abstract  ArrayList<String> consume(double distance);
	
	
	/**
	* @Title: printConsume
	* @Description:  //输出花费的时间和金钱	
	* @param @param distance    参数
	* @return void    返回类型
	* @throws
	*/
	public void printConsume(double distance){
		ArrayList<String> list=consume(distance);
		System.out.println("乘坐"+trafficWay+"花费时间:"+list.get(0));
		System.out.println("花费金钱:"+list.get(1));
	}

}
