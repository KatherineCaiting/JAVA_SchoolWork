/**
* @author ����
* @date 2018��10��20��
* @Title: MemberDao.java
* @project_name: SchoolWork
* @Package com.ytz.dao
* @Description: TODO(��һ�仰�������ļ���ʲô)
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
* @Description: TODO(������һ�仰��������������)
* @author ����
* @date 2018��10��20��
*
*/

public class MemberDao {

	/**
	 * ����Ա��ӵ�XML�ļ���
	 * @param Ա�� Ҫ��ӵĳ�Ա
	 * @return �ɹ�����TRUE������FALSE
	 */
	public boolean add(Employee employee){
		//����dom��
		Document document = Dom4jUtils.getDocument() ;
		//�õ����ڵ�
		Element root = document.getRootElement() ;
		//����һ��employee�ڵ�,���ӽڵ�
		Element emp = root.addElement("employee").addAttribute("idWork", employee.getIdWork()) ;
		//����ӽڵ�
		emp.addElement("name").setText(employee.getName()) ;
		emp.addElement("birthMonth").setText(employee.getBirthMonth()) ;
		emp.addElement("wage").setText(employee.getWage() + "") ;
		
		//���ڴ��е�dom�����浽Ӳ����
		Dom4jUtils.write2xml(document) ;
		
		return true ;
	}
	
	/**
	 * ����Ա��ӵ�XML�ļ���
	 * @param ���� Ҫ��ӵľ���
	 * @return �ɹ�����TRUE������FALSE
	 */
	public boolean add(Manager manager){
		//����dom��
		Document document = Dom4jUtils.getDocument() ;
		//�õ����ڵ�
		Element root = document.getRootElement() ;
		//����һ��employee�ڵ�,���ӽڵ�
		Element man = root.addElement("manager").addAttribute("idWork", manager.getIdWork()) ;
		//����ӽڵ�
		man.addElement("name").setText(manager.getName()) ;
		man.addElement("birthMonth").setText(manager.getBirthMonth()) ;
		man.addElement("wage").setText(manager.getWage() + "") ;
		
		//���ڴ��е�dom�����浽Ӳ����
		Dom4jUtils.write2xml(document) ;
		
		return true ;
	}
	
	/**
	 * ����Ա��ӵ�XML�ļ���
	 * @param ����  Ҫ��ӵľ���
	 * @return �ɹ�����TRUE������FALSE
	 */
	public boolean add(ShareHolder shareHolder){
		//����dom��
		Document document = Dom4jUtils.getDocument() ;
		//�õ����ڵ�
		Element root = document.getRootElement() ;
		//����һ��employee�ڵ�,���ӽڵ�
		Element man = root.addElement("shareHolder").addAttribute("idWork", shareHolder.getIdWork()) ;
		//����ӽڵ�
		man.addElement("name").setText(shareHolder.getName()) ;
		man.addElement("wage").setText(shareHolder.getWage() + "") ;
		
		//���ڴ��е�dom�����浽Ӳ����
		Dom4jUtils.write2xml(document) ;
		
		return true ;
	}
	/**
	 * ���ݳ�Ա������ɾ����Ա
	 * @param idWork  Ҫɾ����Ա������
	 * @return �ɹ�����TRUE�����򷵻�FALSE
	 */
	public boolean delete(String name,String deleteObj){
		//����dom��
		Document document = Dom4jUtils.getDocument() ;
		//�õ����ڵ�
		Element root = document.getRootElement() ;
		//�õ����еĽڵ�
		List<Element> memList = root.elements(deleteObj) ;
		//ѭ���ж�
		for (int i = 0; i < memList.size(); i++) {
			Element mem = memList.get(i) ;
			if(mem.elementText("name").equals(name)){
				//�ҵ���Ҫɾ���ĳ�Ա
				//���׸ɵ�����
				mem.getParent().remove(mem) ;
				
				//������
				Dom4jUtils.write2xml(document) ;
				return true ;
			}
		}
		
		return false ;
	}
	
	
	/**
	 * ���ݹ�����Ų�ѯ��Ա
	 * @param examid Ҫ��ѯ��Ա�Ĺ���
	 * @return �ɹ����ش˳�Ա�����򷵻�null
	 */
	public boolean findByIdWork(String idWork,String name,String findObj){
	    //����dom��
		Document document = Dom4jUtils.getDocument();
		//�õ����ڵ�
		Element root = document.getRootElement() ;
		//��ȡ���е�ѧ���ڵ�
		List<Element> memList = root.elements(findObj) ;
		//ѭ����ȡÿ��student�ڵ��examid���Ե�ֵ�ж�
		for (int i = 0; i < memList.size(); i++) {
			Element memNode = memList.get(i) ;
			
			if(memNode.attributeValue("idWork") .equals(idWork)){
				System.out.println(name+"�Ĺ���Ϊ"+Float.parseFloat(memNode.elementText("wage")));
				Calendar calendar=Calendar.getInstance();
				if(findObj.equals("employee")||findObj.equals("manager")){
					if(Integer.valueOf(memNode.elementText("birthMonth"))==(calendar.get(Calendar.MONTH)+1))
						System.out.println(name+"��������Ŷ��TA����������������");
					return true;
				}else{
					if((calendar.get(Calendar.MONTH)+1)==12)//12��
						System.out.println("�����"+name+"�к���Ŷ");
				}
			}
		}
		return false ;
	}
}
