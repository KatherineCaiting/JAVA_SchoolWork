/**
* @author 蔡婷
* @date 2018年10月20日
* @Title: MemberUi.java
* @project_name: SchoolWork
* @Package com.ytz.ui
* @Description: TODO(用一句话描述该文件做什么)
* @version V1.0
*/


package com.ytz.ui;

import java.util.Scanner;

import com.ytz.bean.Employee;
import com.ytz.bean.Manager;
import com.ytz.bean.Member;
import com.ytz.bean.ShareHolder;
import com.ytz.dao.MemberDao;

/**
* @ClassName: MemberUi
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 蔡婷
* @date 2018年10月20日
*
*/

public class MemberUi {

	static Scanner scan  = new Scanner(System.in) ;
	static MemberDao dao = new MemberDao() ;

	public static void main(String[] args) {
		System.out.println("--------欢迎来到发工资小程序-------");
		option();
	}
	public static void option(){
		System.out.println("请选择操作： a) 添加成员    b) 查询成员工资   c) 删除成员" );
		
		String op = scan.next() ;
		
		if("a".equalsIgnoreCase(op)){
			addMember() ;
		}else if("b".equalsIgnoreCase(op)){
			findMemberByName() ;
		}else if("c".equals(op)){
			removeMemberByName() ;
		}else{
			System.out.println("没有此种操作");
			option();
		}
		isContinue();
	}
	public static void isContinue(){
		System.out.println("请问是否继续进行操作,'yes'or'no'");
		String answer = scan.next() ;
		
		if("yes".equalsIgnoreCase(answer)){
			option();
		}else if("no".equalsIgnoreCase(answer)){
			System.out.println("-----操作结束----");
		}else{
			System.out.println("请输入‘yes’or'no'哦");
			isContinue();
		}
	}
	//删除成员
	private static void removeMemberByName() {
		System.out.println("请输入被删成员的工作号:");
		String idWork = scan.next() ;
		System.out.println("请输入被删成员的姓名:");
		String name = scan.next() ;
		
		if(Integer.valueOf(idWork)>20&&Integer.valueOf(idWork)<=100){
			
			//调用业务逻辑层完成功能
			boolean flag = dao.delete(name,"employee") ;
			
			if(flag)
				System.out.println("---------删除成功-------------");
			else
				System.out.println("---------删除失败-------------");
		}else if(Integer.valueOf(idWork)<=10&&Integer.valueOf(idWork)>=0){
			
			//调用业务逻辑层完成功能
			boolean flag = dao.delete(name,"shareHolder") ;
			
			if(flag)
				System.out.println("---------删除成功-------------");
			else
				System.out.println("---------删除失败-------------");
		}else if(Integer.valueOf(idWork)<=20&&Integer.valueOf(idWork)>10){
		
			//调用业务逻辑层完成功能
			boolean flag = dao.delete(name,"manager") ;
			
			if(flag)
				System.out.println("---------删除成功-------------");
			else
				System.out.println("---------删除失败-------------");
		}
		
	}

	//根据成员名字查找成员工资
	private static void findMemberByName() {
		System.out.println("请输入名字:");
		String name = scan.next() ;
		System.out.println("请输入工作号:");
		String idWork = scan.next() ;
		
		if(Integer.valueOf(idWork)>20&&Integer.valueOf(idWork)<=100){
			//调用dao层完成功能
			
			boolean flag = dao.findByIdWork(idWork,name,"employee") ;
			if(flag)
				System.out.println("");
			else
				System.out.println("此人不存在");
			
		}else if(Integer.valueOf(idWork)<=10&&Integer.valueOf(idWork)>=0){
			boolean flag = dao.findByIdWork(idWork,name,"shareHolder") ;
			if(flag)
				System.out.println("");
			else
				System.out.println("此人不存在");
		}else if(Integer.valueOf(idWork)<=20&&Integer.valueOf(idWork)>10){
			boolean flag = dao.findByIdWork(idWork,name,"manager") ;
			if(flag)
				System.out.println("");
			else
				System.out.println("此人不存在");
		}
		
	}

	//添加一个成员
	private static void addMember() {
		
		System.out.println("请输入您的工作编号:");
		String idWork = scan.next() ;
	
		if(Integer.valueOf(idWork)>20&&Integer.valueOf(idWork)<=100){
			Employee employee=new Employee();
			
			employee.setIdWork(idWork);
			//调用dao层完成功能
			boolean flag = dao.add(employee) ;
			if(flag)
				System.out.println("----------添加成功------------------");
			else
				System.out.println("----------添加失败------------------");
		}else if(Integer.valueOf(idWork)<=10&&Integer.valueOf(idWork)>=0){
			ShareHolder shareHolder=new ShareHolder();
			
			shareHolder.setIdWork(idWork);
			//调用dao层完成功能
			boolean flag = dao.add(shareHolder) ;
			if(flag)
				System.out.println("----------添加成功------------------");
			else
				System.out.println("----------添加失败------------------");
		}else if(Integer.valueOf(idWork)<=20&&Integer.valueOf(idWork)>10){
			Manager manager=new Manager();
			
			manager.setIdWork(idWork);
			//调用dao层完成功能
			boolean flag = dao.add(manager) ;
			if(flag)
				System.out.println("----------添加成功------------------");
			else
				System.out.println("----------添加失败------------------");
		}
	}

}
