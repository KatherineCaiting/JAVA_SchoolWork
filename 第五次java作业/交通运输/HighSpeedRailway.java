/**
* @author 蔡婷
* @date 2018年10月31日
* @Title: HighSpeedRailway.java
* @project_name: SchoolWork
* @Package com.ytz.trans
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.ytz.trans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
* @ClassName: HighSpeedRailway
* @Description: 高铁类
* @author 蔡婷
* @date 2018年10月31日
*
*/

public class HighSpeedRailway extends Translation {

	public HighSpeedRailway() {
		// TODO Auto-generated constructor stub
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
		setTrafficWay("高铁");
		try {
			setArriveTime(dateformat.parse("00:05"));//高铁到站时间为5分钟
			setReturnTime(dateformat.parse("00:20"));//高铁从车站返回的时间为20分钟
			setTimeForTakingTickets(dateformat.parse("00:05"));//在高铁站取票的时间为5分钟
			setSecurityTime(dateformat.parse("00:03"));//在高铁站取票的时间为5分钟
			setSpeedOfMotorVehicle(250);//高铁车速为250km/h;
			setCutoffInterval(dateformat.parse("00:05"));//高铁停车时间为5分钟
			setUnitPrice(0.45);//高铁二等座0.45元/公里
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
				double time=distance/getSpeedOfMotorVehicle();//计算高铁花销的时间（单位：h）
				String time_h=String.valueOf((int)time);
				String time_m=String.valueOf((int)((time-(int)time)*60));
				String consumeTime = time_h+"小时"+time_m+"分钟";
				double money=distance*getUnitPrice();//计算高铁花销的价格
				ArrayList<String> list=new ArrayList<String>();
				
				list.add(consumeTime);
				list.add(String.valueOf(money));
				return list;
	}
	

}
