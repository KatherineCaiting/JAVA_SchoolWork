/**
* @Title: PrintAdress.java
* @Package Ytz
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ����
* @date 2018��9��14������8:43:40
* @version V1.0
 */
package Ytz;

/**
      * @ClassName: PrintAdress
      * @Description: ��ӡ������ַ
      * @author ����
      * @date 2018��9��14�� ����8:43:40
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
