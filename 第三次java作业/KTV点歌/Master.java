
/**
* @author 蔡婷
* @date 2018年10月6日
* @Title: Master.java
* @project_name: SchoolWork
* @Package Ytz
* @Description: 定义一个主持人类
* @version V1.0
*/


package Ytz;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;

/**
* @ClassName: Master
* @Description: 主持人类
* @author 蔡婷
* @date 2018年10月6日
*
*/

public class Master {
	SongInfo song=new SongInfo();
	User user=new User();
	
	Scanner scanner=new Scanner(System.in);
	/**
	* @Title: Master
	* @Description: 主持人主持
	* @param     参数
	* @return void    返回类型
	* @throws
	*/
	public void Master(){
		System.out.println("请问是否点歌呢？ 请回答“yes”or“no”.");
		if(user.addSong()==true){
			//仅限本地已存的歌目
			Master();
		}else{
			
		}
	}
	
	/**
	* @Title: playMusic
	* @Description: 主持人执行播放列表的歌
	* @param @return    参数
	* @return Boolean    返回类型
	* @throws
	*/
	public Boolean playMusic(){
		 
		if(user.songList!=null){
			System.out.println("请问是否可以播放列表的歌呢？ 请回答“yes”or“no”.");
			String answer=scanner.next();
			if(answer.equals("yes")){
				try {
					run();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else if(answer.equals("no")){
				return false;
			}else{
				System.out.println("请您输入“yes”or“no”哦");
				playMusic();
				return false;
			}
		}else{
			System.out.println("用户没有添加歌曲呢！");
			return false;
		}
		
	}
	//按列表播放
	public void run()  throws FileNotFoundException, JavaLayerException{
		
		for(int i=0;i<user.songList.size();i++){
			System.out.println("-------------下面播放的是用户点的歌------------");
			System.out.println("歌名："+user.songList.get(i).name+" 原唱歌手为："+user.songList.get(i).singer+" 歌曲时长为："+user.songList.get(i).time);
			BufferedInputStream buffer = new BufferedInputStream(
	                new FileInputStream("D:/Song/"+user.songList.get(i).name+".mp3"));
	                new Player(buffer).play();
		}
	}
	//按主持人指定的播放
	public void masterRun()  throws FileNotFoundException, JavaLayerException{
		System.out.println("请主持人点出指定的歌：");
		String name=scanner.next();
		System.out.println("-------------下面播放主持人指定的歌-------------");
		BufferedInputStream buffer = new BufferedInputStream(
	           new FileInputStream("D:/Song/"+name+".mp3"));
	           new Player(buffer).play();	
	}
	
	
}

