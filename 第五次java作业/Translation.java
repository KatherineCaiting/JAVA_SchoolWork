/**
* @author ����
* @date 2018��10��28��
* @Title: Translation.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.ytz.trans;

import java.util.ArrayList;
import java.util.Date;

/**
* @ClassName: Translation
* @Description: ��ͨ���߳�����
* @author ����
* @date 2018��10��28��
*
*/

public abstract class Translation {
	/**
	* @Fields ��ͨ��ʽ����
	*/
	private String trafficWay;
	/**
	* @Fields ����վʱ��
	*/
	private Date arriveTime;
	/**
	* @Fields �ӳ�վ����ʱ��
	*/
	private Date returnTime;
	/**
	* @Fields ȡƱʱ��
	*/
	private Date timeForTakingTickets;
	/**
	* @Fields ����ʱ��
	*/
	private Date securityTime;
	/**
	* @Fields ͣ��ʱ��
	*/
	private Date cutoffInterval;
	/**
	* @Fields ����
	*/
	private double speedOfMotorVehicle;
	/**
	* @Fields ����
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
	* ����һ���µ�ʵ�� Translation.
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
	* ����һ���µ�ʵ�� Translation.
	*
	*/
	
	public Translation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	* @Title: consume
	* @Description: ���ĵ�ʱ��ͼ۸�
	* @param @param distance 
	* @param @return    ����
	* @return ArrayList<String>    ��������
	* @throws
	*/
	public abstract  ArrayList<String> consume(double distance);
	
	
	/**
	* @Title: printConsume
	* @Description:  //������ѵ�ʱ��ͽ�Ǯ	
	* @param @param distance    ����
	* @return void    ��������
	* @throws
	*/
	public void printConsume(double distance){
		ArrayList<String> list=consume(distance);
		System.out.println("����"+trafficWay+"����ʱ��:"+list.get(0));
		System.out.println("���ѽ�Ǯ:"+list.get(1));
	}

}
