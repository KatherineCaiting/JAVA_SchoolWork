/**
* @author ����
* @date 2018��10��6��
* @Title: User.java
* @project_name: SchoolWork
* @Package Ytz
* @Description: ����һ���û��ࣨ��裩
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
* @Description: �û��ࣨ��裩
* @author ����
* @date 2018��10��6��
*
*/

/**
* @ClassName: User
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��10��16��
*
*/

/**
* @ClassName: User
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��10��16��
*
*/

public class User {
	/**
	* @Fields �û�ָ���ĸ赥
	*/
	static List<SongInfo> songList=new LinkedList<>();
	/**
	* @Title: addSong
	* @Description: ѯ���û��Ƿ���Ӹ��������ǣ�����ӵ��û��ĵ�赥
	* @param @return    ����
	* @return boolean    ��������
	* @throws
	*/
	public boolean addSong(){
		SongInfo songInfo=new SongInfo();
		Scanner scanner=new Scanner(System.in);
		
		String answer=scanner.next();
		if(answer.equals("yes")){
			System.out.println("����������Ҫ��ĸ�������");
			String songName=scanner.next();
			System.out.println("������������ĸ����ֵİ汾��");
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
			System.out.println("�������롰yes��or��no��Ŷ");
			addSong();
			return false;
		}
	}
	
	
	 /**
	* @Title: getDuration
	* @Description: ��ȡ���ظ�����ʱ��
	* @param @param position
	* @param @return    ����
	* @return String    ��������
	* @throws
	*/
	public String getDuration(String position) {
	        int length = 0;//�����ĳ��ȣ���λ��s
	        String time="";
	        try {
	            MP3File mp3File = (MP3File) AudioFileIO.read(new File(position));
	            MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();
	            // ��λΪ��
	            length = audioHeader.getTrackLength();
	            time=length/60+":"+length%60;//��������ת���ʱ���ʽ������0:00
	            return time;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return time;
	    }
}
