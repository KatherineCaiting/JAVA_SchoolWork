package Ytz;
/**
* @author 蔡婷
* @date 2018年10月6日
* @Title: Control.java
* @project_name: SchoolWork
* @Package Ytz
* @Description: 控制类  让他们运行起来
* @version V1.0
*/




import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javazoom.jl.decoder.JavaLayerException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* @ClassName: Control
* @Description: 控制类  让他们运行起来
* @author 蔡婷
* @date 2018年10月6日
*
*/

public class Control {
	public Master master;
	public User user;
	public static void SongDrive() throws IOException{
		Master master=new Master();
		master.Master();
		if(master.playMusic()==true){
			//
		}else{
			//
		}
		try {
			master.masterRun();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.out.println("欢迎来到文强KTV,请尽情的歌唱吧！");
		SongDrive();
		
	}

}
