/**
* @author ����
* @date 2018��10��28��
* @Title: Car.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: ����һ��������
* @version V1.0
*/


package com.ytz.trans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
* @ClassName: Car
* @Description: ������
* @author ����
* @date 2018��10��28��
*
*/

public class Car extends Translation {

	public Car(){
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
		setTrafficWay("����");
		try {
			setArriveTime(dateformat.parse("00:10"));//������վʱ��Ϊ10����
			setReturnTime(dateformat.parse("00:20"));//�����ӳ�վ���ص�ʱ��Ϊ20����
			setTimeForTakingTickets(dateformat.parse("00:05"));//������վȡƱ��ʱ��Ϊ5����
			setSecurityTime(dateformat.parse("00:03"));//������վ�����ʱ��Ϊ3����
			setSpeedOfMotorVehicle(60);//��������Ϊ60km/h;
			setCutoffInterval(dateformat.parse("00:05"));//����ͣ��ʱ��Ϊ5����
			setUnitPrice(0.32);//����0.32Ԫ/����
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public ArrayList<String> consume(double distance) {
		// TODO Auto-generated method stub
		String consume=String.valueOf(getSecurityTime())+String.valueOf(getTimeForTakingTickets())+
				        String.valueOf(getArriveTime())+String.valueOf(getCutoffInterval())+String.valueOf(getReturnTime());
		double time=distance/getSpeedOfMotorVehicle();//��������������ʱ�䣨��λ��h��
		String time_h=String.valueOf((int)time);
		String time_m=String.valueOf((int)((time-(int)time)*60));
		String consumeTime = time_h+"Сʱ"+time_m+"����";
		double money=distance*getUnitPrice();//�������������ļ۸�
		ArrayList<String> list=new ArrayList<String>();
		
		list.add(consumeTime);
		list.add(String.valueOf(money));
		return list;
	}

}
