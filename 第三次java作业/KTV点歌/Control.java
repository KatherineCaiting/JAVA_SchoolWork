package Ytz;
/**
* @author ����
* @date 2018��10��6��
* @Title: Control.java
* @project_name: SchoolWork
* @Package Ytz
* @Description: ������  ��������������
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
* @Description: ������  ��������������
* @author ����
* @date 2018��10��6��
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
		System.out.println("��ӭ������ǿKTV,�뾡��ĸ質�ɣ�");
		SongDrive();
		
	}

}
