/**
* @author ����
* @date 2018��10��20��
* @Title: MemberUi.java
* @project_name: SchoolWork
* @Package com.ytz.ui
* @Description: TODO(��һ�仰�������ļ���ʲô)
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
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��10��20��
*
*/

public class MemberUi {

	static Scanner scan  = new Scanner(System.in) ;
	static MemberDao dao = new MemberDao() ;

	public static void main(String[] args) {
		System.out.println("--------��ӭ����������С����-------");
		option();
	}
	public static void option(){
		System.out.println("��ѡ������� a) ��ӳ�Ա    b) ��ѯ��Ա����   c) ɾ����Ա" );
		
		String op = scan.next() ;
		
		if("a".equalsIgnoreCase(op)){
			addMember() ;
		}else if("b".equalsIgnoreCase(op)){
			findMemberByName() ;
		}else if("c".equals(op)){
			removeMemberByName() ;
		}else{
			System.out.println("û�д��ֲ���");
			option();
		}
		isContinue();
	}
	public static void isContinue(){
		System.out.println("�����Ƿ�������в���,'yes'or'no'");
		String answer = scan.next() ;
		
		if("yes".equalsIgnoreCase(answer)){
			option();
		}else if("no".equalsIgnoreCase(answer)){
			System.out.println("-----��������----");
		}else{
			System.out.println("�����롮yes��or'no'Ŷ");
			isContinue();
		}
	}
	//ɾ����Ա
	private static void removeMemberByName() {
		System.out.println("�����뱻ɾ��Ա�Ĺ�����:");
		String idWork = scan.next() ;
		System.out.println("�����뱻ɾ��Ա������:");
		String name = scan.next() ;
		
		if(Integer.valueOf(idWork)>20&&Integer.valueOf(idWork)<=100){
			
			//����ҵ���߼�����ɹ���
			boolean flag = dao.delete(name,"employee") ;
			
			if(flag)
				System.out.println("---------ɾ���ɹ�-------------");
			else
				System.out.println("---------ɾ��ʧ��-------------");
		}else if(Integer.valueOf(idWork)<=10&&Integer.valueOf(idWork)>=0){
			
			//����ҵ���߼�����ɹ���
			boolean flag = dao.delete(name,"shareHolder") ;
			
			if(flag)
				System.out.println("---------ɾ���ɹ�-------------");
			else
				System.out.println("---------ɾ��ʧ��-------------");
		}else if(Integer.valueOf(idWork)<=20&&Integer.valueOf(idWork)>10){
		
			//����ҵ���߼�����ɹ���
			boolean flag = dao.delete(name,"manager") ;
			
			if(flag)
				System.out.println("---------ɾ���ɹ�-------------");
			else
				System.out.println("---------ɾ��ʧ��-------------");
		}
		
	}

	//���ݳ�Ա���ֲ��ҳ�Ա����
	private static void findMemberByName() {
		System.out.println("����������:");
		String name = scan.next() ;
		System.out.println("�����빤����:");
		String idWork = scan.next() ;
		
		if(Integer.valueOf(idWork)>20&&Integer.valueOf(idWork)<=100){
			//����dao����ɹ���
			
			boolean flag = dao.findByIdWork(idWork,name,"employee") ;
			if(flag)
				System.out.println("");
			else
				System.out.println("���˲�����");
			
		}else if(Integer.valueOf(idWork)<=10&&Integer.valueOf(idWork)>=0){
			boolean flag = dao.findByIdWork(idWork,name,"shareHolder") ;
			if(flag)
				System.out.println("");
			else
				System.out.println("���˲�����");
		}else if(Integer.valueOf(idWork)<=20&&Integer.valueOf(idWork)>10){
			boolean flag = dao.findByIdWork(idWork,name,"manager") ;
			if(flag)
				System.out.println("");
			else
				System.out.println("���˲�����");
		}
		
	}

	//���һ����Ա
	private static void addMember() {
		
		System.out.println("���������Ĺ������:");
		String idWork = scan.next() ;
	
		if(Integer.valueOf(idWork)>20&&Integer.valueOf(idWork)<=100){
			Employee employee=new Employee();
			
			employee.setIdWork(idWork);
			//����dao����ɹ���
			boolean flag = dao.add(employee) ;
			if(flag)
				System.out.println("----------��ӳɹ�------------------");
			else
				System.out.println("----------���ʧ��------------------");
		}else if(Integer.valueOf(idWork)<=10&&Integer.valueOf(idWork)>=0){
			ShareHolder shareHolder=new ShareHolder();
			
			shareHolder.setIdWork(idWork);
			//����dao����ɹ���
			boolean flag = dao.add(shareHolder) ;
			if(flag)
				System.out.println("----------��ӳɹ�------------------");
			else
				System.out.println("----------���ʧ��------------------");
		}else if(Integer.valueOf(idWork)<=20&&Integer.valueOf(idWork)>10){
			Manager manager=new Manager();
			
			manager.setIdWork(idWork);
			//����dao����ɹ���
			boolean flag = dao.add(manager) ;
			if(flag)
				System.out.println("----------��ӳɹ�------------------");
			else
				System.out.println("----------���ʧ��------------------");
		}
	}

}
