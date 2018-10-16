/**
* @Title: PrintAdress.java
* @Package Ytz
* @Description: TODO(用一句话描述该文件做什么)
* @author 蔡婷
* @date 2018年9月14日上午8:43:40
* @version V1.0
 */
package Ytz;

/**
      * @ClassName: PrintAdress
      * @Description: 打印变量地址
      * @author 蔡婷
      * @date 2018年9月14日 上午8:43:40
      * 
 */
public class PrintAdress {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String c="a";
		String a;
		a=c;
		System.out.println(System.identityHashCode(c));
		System.out.println(System.identityHashCode(a));
		a="b";
		System.out.println(System.identityHashCode(c));
		System.out.println(System.identityHashCode(a));
	}

}
