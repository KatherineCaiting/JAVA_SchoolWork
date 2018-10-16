/**
* @Title: Nursery.java
* @Package Ytz
* @Description: 狼外婆要哄小红帽觉，怎么哄呢?唱个数酒瓶的童谣吧
                1。酒要从99数到0！
                2。每数一瓶就唱一段重谣：
                N bottles of beer on the wall.N bottles of beer.
                Take one down
                Pass it around
                N-1 bottles of beer on the wall
                3。注区分 bottle的单复放
                4。最后一瓶拿下墙后，要说 No more bottles of beer on the wall
* @author 蔡婷
* @date 2018年9月14日上午9:07:41
* @version V1.0
 */
//import java.io.BufferedReader;

package Ytz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
public class Nursery {
   public static int n;
	public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        n=Integer.parseInt(lineTxt);
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
     


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		String filePath = "‪C://nums.txt";
        readTxtFile(filePath);
		
		for(i=0;i<=n-1;i++)
		{
			if((n-i)==2){
		    	System.out.println((n-i)+" bottles of beer on the wall.");
				System.out.println((n-i)+" bottles of beer.");
			    System.out.println("Take one down Pass it around ");
			    System.out.println((n-1-i)+" bottle of beer on the wall");
			    System.out.println();
		    }else if((n-i)==1){
		    	System.out.println((n-i)+" bottle of beer on the wall.");
				System.out.println((n-i)+" bottle of beer.");
			    System.out.println("Take one down Pass it around ");
			    System.out.println("No more bottles of beer on the wall");
			    System.out.println();
		    }else{
		    	System.out.println((n-i)+" bottles of beer on the wall.");
				System.out.println((n-i)+" bottles of beer.");
			    System.out.println("Take one down Pass it around ");
			    System.out.println((n-1-i)+" bottles of beer on the wall");
			    System.out.println();
		    }
			
		}

	}

}
