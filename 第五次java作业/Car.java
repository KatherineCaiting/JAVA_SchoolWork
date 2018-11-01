/**
* @author 蔡婷
* @date 2018年10月28日
* @Title: Car.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: 描述一个汽车类
* @version V1.0
*/


package com.ytz.trans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
* @ClassName: Car
* @Description: 汽车类
* @author 蔡婷
* @date 2018年10月28日
*
*/

public class Car extends Translation {

	public Car(){
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
		setTrafficWay("汽车");
		try {
			setArriveTime(dateformat.parse("00:10"));//汽车到站时间为10分钟
			setReturnTime(dateformat.parse("00:20"));//汽车从车站返回的时间为20分钟
			setTimeForTakingTickets(dateformat.parse("00:05"));//在汽车站取票的时间为5分钟
			setSecurityTime(dateformat.parse("00:03"));//在汽车站安检的时间为3分钟
			setSpeedOfMotorVehicle(60);//汽车车速为60km/h;
			setCutoffInterval(dateformat.parse("00:05"));//汽车停车时间为5分钟
			setUnitPrice(0.32);//汽车0.32元/公里
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
		double time=distance/getSpeedOfMotorVehicle();//计算汽车花销的时间（单位：h）
		String time_h=String.valueOf((int)time);
		String time_m=String.valueOf((int)((time-(int)time)*60));
		String consumeTime = time_h+"小时"+time_m+"分钟";
		double money=distance*getUnitPrice();//计算汽车花销的价格
		ArrayList<String> list=new ArrayList<String>();
		
		list.add(consumeTime);
		list.add(String.valueOf(money));
		return list;
	}

}
