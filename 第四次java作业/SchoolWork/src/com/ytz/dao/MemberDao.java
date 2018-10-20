/**
* @author 蔡婷
* @date 2018年10月20日
* @Title: MemberDao.java
* @project_name: SchoolWork
* @Package com.ytz.dao
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.ytz.dao;

import java.util.Calendar;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.ytz.bean.Employee;
import com.ytz.bean.Manager;
import com.ytz.bean.Member;
import com.ytz.bean.ShareHolder;
import com.ytz.util.Dom4jUtils;

/**
* @ClassName: MemberDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年10月20日
*
*/

public class MemberDao {

	/**
	 * 将成员添加到XML文件中
	 * @param 员工 要添加的成员
	 * @return 成功返回TRUE，否则FALSE
	 */
	public boolean add(Employee employee){
		//加载dom树
		Document document = Dom4jUtils.getDocument() ;
		//拿到根节点
		Element root = document.getRootElement() ;
		//创建一个employee节点,及子节点
		Element emp = root.addElement("employee").addAttribute("idWork", employee.getIdWork()) ;
		//添加子节点
		emp.addElement("name").setText(employee.getName()) ;
		emp.addElement("birthMonth").setText(employee.getBirthMonth()) ;
		emp.addElement("wage").setText(employee.getWage() + "") ;
		
		//将内存中的dom树保存到硬盘上
		Dom4jUtils.write2xml(document) ;
		
		return true ;
	}
	
	/**
	 * 将成员添加到XML文件中
	 * @param 经理 要添加的经理
	 * @return 成功返回TRUE，否则FALSE
	 */
	public boolean add(Manager manager){
		//加载dom树
		Document document = Dom4jUtils.getDocument() ;
		//拿到根节点
		Element root = document.getRootElement() ;
		//创建一个employee节点,及子节点
		Element man = root.addElement("manager").addAttribute("idWork", manager.getIdWork()) ;
		//添加子节点
		man.addElement("name").setText(manager.getName()) ;
		man.addElement("birthMonth").setText(manager.getBirthMonth()) ;
		man.addElement("wage").setText(manager.getWage() + "") ;
		
		//将内存中的dom树保存到硬盘上
		Dom4jUtils.write2xml(document) ;
		
		return true ;
	}
	
	/**
	 * 将成员添加到XML文件中
	 * @param 经理  要添加的经理
	 * @return 成功返回TRUE，否则FALSE
	 */
	public boolean add(ShareHolder shareHolder){
		//加载dom树
		Document document = Dom4jUtils.getDocument() ;
		//拿到根节点
		Element root = document.getRootElement() ;
		//创建一个employee节点,及子节点
		Element man = root.addElement("shareHolder").addAttribute("idWork", shareHolder.getIdWork()) ;
		//添加子节点
		man.addElement("name").setText(shareHolder.getName()) ;
		man.addElement("wage").setText(shareHolder.getWage() + "") ;
		
		//将内存中的dom树保存到硬盘上
		Dom4jUtils.write2xml(document) ;
		
		return true ;
	}
	/**
	 * 根据成员的姓名删除成员
	 * @param idWork  要删除成员的姓名
	 * @return 成功返回TRUE，否则返回FALSE
	 */
	public boolean delete(String name,String deleteObj){
		//加载dom树
		Document document = Dom4jUtils.getDocument() ;
		//拿到根节点
		Element root = document.getRootElement() ;
		//拿到所有的节点
		List<Element> memList = root.elements(deleteObj) ;
		//循环判断
		for (int i = 0; i < memList.size(); i++) {
			Element mem = memList.get(i) ;
			if(mem.elementText("name").equals(name)){
				//找到了要删除的成员
				//父亲干掉儿子
				mem.getParent().remove(mem) ;
				
				//保存结果
				Dom4jUtils.write2xml(document) ;
				return true ;
			}
		}
		
		return false ;
	}
	
	
	/**
	 * 根据工作编号查询成员
	 * @param examid 要查询成员的工资
	 * @return 成功返回此成员，否则返回null
	 */
	public boolean findByIdWork(String idWork,String name,String findObj){
	    //加载dom树
		Document document = Dom4jUtils.getDocument();
		//拿到根节点
		Element root = document.getRootElement() ;
		//拿取所有的学生节点
		List<Element> memList = root.elements(findObj) ;
		//循环拿取每个student节点的examid属性的值判断
		for (int i = 0; i < memList.size(); i++) {
			Element memNode = memList.get(i) ;
			
			if(memNode.attributeValue("idWork") .equals(idWork)){
				System.out.println(name+"的工资为"+Float.parseFloat(memNode.elementText("wage")));
				Calendar calendar=Calendar.getInstance();
				if(findObj.equals("employee")||findObj.equals("manager")){
					if(Integer.valueOf(memNode.elementText("birthMonth"))==(calendar.get(Calendar.MONTH)+1))
						System.out.println(name+"即将生日哦！TA的礼物正在派送中");
					return true;
				}else{
					if((calendar.get(Calendar.MONTH)+1)==12)//12月
						System.out.println("这个月"+name+"有红利哦");
				}
			}
		}
		return false ;
	}
}
