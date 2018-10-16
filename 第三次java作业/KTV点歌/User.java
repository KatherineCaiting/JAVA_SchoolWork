/**
* @author 蔡婷
* @date 2018年10月6日
* @Title: User.java
* @project_name: SchoolWork
* @Package Ytz
* @Description: 定义一个用户类（点歌）
* @version V1.0
*/


package Ytz;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

/**
* @ClassName: User
* @Description: 用户类（点歌）
* @author 蔡婷
* @date 2018年10月6日
*
*/

/**
* @ClassName: User
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年10月16日
*
*/

/**
* @ClassName: User
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年10月16日
*
*/

public class User {
	/**
	* @Fields 用户指定的歌单
	*/
	static List<SongInfo> songList=new LinkedList<>();
	/**
	* @Title: addSong
	* @Description: 询问用户是否添加歌曲，若是，就添加到用户的点歌单
	* @param @return    参数
	* @return boolean    返回类型
	* @throws
	*/
	public boolean addSong(){
		SongInfo songInfo=new SongInfo();
		Scanner scanner=new Scanner(System.in);
		
		String answer=scanner.next();
		if(answer.equals("yes")){
			System.out.println("请输入您想要点的歌曲名：");
			String songName=scanner.next();
			System.out.println("请输入您想点哪个歌手的版本？");
			String singerName=scanner.next();
			String songTime=getDuration("D:/Song/"+songName+".mp3");
			songInfo.setName(songName);
			songInfo.setSinger(singerName);
			songInfo.setTime(songTime);
			songList.add(songInfo);
			
			
			return true;
		}else if(answer.equals("no")){
			return false;
		}else{
			System.out.println("请您输入“yes”or“no”哦");
			addSong();
			return false;
		}
	}
	
	
	 /**
	* @Title: getDuration
	* @Description: 获取本地歌曲的时长
	* @param @param position
	* @param @return    参数
	* @return String    返回类型
	* @throws
	*/
	public String getDuration(String position) {
	        int length = 0;//歌曲的长度，单位是s
	        String time="";
	        try {
	            MP3File mp3File = (MP3File) AudioFileIO.read(new File(position));
	            MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();
	            // 单位为秒
	            length = audioHeader.getTrackLength();
	            time=length/60+":"+length%60;//歌曲长度转变成时间格式，类似0:00
	            return time;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return time;
	    }
}
