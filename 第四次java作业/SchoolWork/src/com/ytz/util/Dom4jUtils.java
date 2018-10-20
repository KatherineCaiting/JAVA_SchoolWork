/**
* @author 蔡婷
* @date 2018年10月19日
* @Title: Dom4jUtils.java
* @project_name: SchoolWork
* @Package sch
* @Description: TODO(用一句话描述该文件做什么)
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
* @author 蔡婷
* @date 2018年10月19日
*
*/

public class Dom4jUtils {

	//获取dom树
		public static Document getDocument(){
			//创建dom4j解析器
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
		
		//保存dom树到硬盘上
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
