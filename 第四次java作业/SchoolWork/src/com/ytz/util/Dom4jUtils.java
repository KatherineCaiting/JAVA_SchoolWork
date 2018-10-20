/**
* @author ����
* @date 2018��10��19��
* @Title: Dom4jUtils.java
* @project_name: SchoolWork
* @Package sch
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @version V1.0
*/


package com.ytz.util;


import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
* @ClassName: Dom4jUtils
* @Description: 
* @author ����
* @date 2018��10��19��
*
*/

public class Dom4jUtils {

	//��ȡdom��
		public static Document getDocument(){
			//����dom4j������
			SAXReader reader = new SAXReader() ;
			try {
				Document document = reader.read("src/member.xml") ;
				return document ;
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null ;
		} 
		
		//����dom����Ӳ����
		public static void write2xml(Document document){
			try {
				XMLWriter writer = new XMLWriter(new FileOutputStream("src/member.xml"),OutputFormat.createPrettyPrint()) ;
				writer.write(document) ;
				writer.close() ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
