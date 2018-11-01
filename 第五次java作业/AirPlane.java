/**
* @author ����
* @date 2018��10��31��
* @Title: AirPlane.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.ytz.trans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
* @ClassName: AirPlane
* @Description: �ɻ���
* @author ����
* @date 2018��10��31��
*
*/

public class AirPlane extends Translation {

	public AirPlane() {
		// TODO Auto-generated constructor stub
	    SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
		setTrafficWay("�ɻ�");
		try {
			setArriveTime(dateformat.parse("00:05"));//�ɻ���վʱ��Ϊ5����
			setReturnTime(dateformat.parse("00:20"));//�ɻ��ӻ������ص�ʱ��Ϊ20����
			setTimeForTakingTickets(dateformat.parse("00:05"));//�ڻ���ȡƱ��ʱ��Ϊ5����
			setSecurityTime(dateformat.parse("00:05"));//�ڻ��������ʱ��Ϊ5����
			setSpeedOfMotorVehicle(900);//�ɻ��ٶ�Ϊ250km/h;
			setCutoffInterval(dateformat.parse("00:05"));//�ɻ�ͣ��ʱ��Ϊ5����
			setUnitPrice(0.75);//�ɻ�0.75Ԫ/����
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
		double time=distance/getSpeedOfMotorVehicle();//����ɻ�������ʱ�䣨��λ��h��
		String time_h=String.valueOf((int)time);
		String time_m=String.valueOf((int)((time-(int)time)*60));
		String consumeTime = time_h+"Сʱ"+time_m+"����";
		double money=distance*getUnitPrice();//����ɻ������ļ۸�
		ArrayList<String> list=new ArrayList<String>();
		
		list.add(consumeTime);
		list.add(String.valueOf(money));
		return list;
	}

}
