/**
* @author ����
* @date 2018��10��3��
* @Title: ListTest.java
* @project_name: SchoolWork
* @Package Ytz
* @Description: ͨ���������list set tree hashset hashlist˭�Ĳ����ٶȸ��죨��ģΪ1000~1000000�������ü�ʱ���ߣ������ͨ��Excel����
* @version V1.0
*/


package Ytz;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;


/**
* @ClassName: ListTest
* @Description: ���Լ����ڲ�ͬ������Сʱ�Ĳ����ٶ�
* @author ����
* @date 2018��10��14��
*
*/

public class ListTest {

//	private static Random random=new Random();
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//����Ҫ���Եļ��϶���
		//List<Integer> list = new ArrayList();
		ArrayList<Integer> arrayList=new ArrayList();
		LinkedList<Integer> linkedList=new LinkedList();
		Vector<Integer> vector=new Vector();
		
		//Map<Integer,Object> map=new HashMap();
		HashMap<Integer,Object> hashMap=new HashMap();

		Hashtable<Integer,Object> hashTable=new Hashtable();
		
		SortedMap<Integer,Object> sortedMap=new TreeMap();
		TreeMap<Integer,Object> treeMap=new TreeMap();
		
		//Set<Integer> set=new HashSet();
		HashSet<Integer> hashSet=new HashSet();
		TreeSet<Integer> treeSet=new TreeSet();
		SortedSet<Integer> sortedSet=new TreeSet();
		
		int i;
		System.out.print("��������Լ��ϵĴ�С:");
		int size=scanner.nextInt();
		
		//�򼯺����������
		for(i=0;i<size;i++){
			//String r = randomString();
			
			
		//	list.add(i);
			arrayList.add(i);
			linkedList.add(i);
			vector.add(i);
			
			//map.put(i,i);
			hashMap.put(i, i);
			hashTable.put(i,i);
			sortedMap.put(i, i);
			treeMap.put(i, i);
			
		//	set.add(i);
			hashSet.add(i);
			treeSet.add(i);
			sortedSet.add(i);
			
		}
		
		
		//���Լ��ϲ��ҵ�ʱ��
		long begin=System.currentTimeMillis();
//		for(int j=0;j<list.size()/10;j++){
//			list.contains(list.get(j));
//		}
//		System.out.println("list time:"+(System.currentTimeMillis()-begin)+"ms");
//		
		
//		begin=System.currentTimeMillis();
		for(int j=0;j<arrayList.size()/10;j++){
			arrayList.contains(arrayList.get(j));
		}
		System.out.println("arrayList time:"+(System.currentTimeMillis()-begin)+"ms");
		
		
		begin=System.currentTimeMillis();
		for(int j=0;j<linkedList.size()/10;j++){
			linkedList.contains(linkedList.get(j));
		}
		System.out.println("linkedList time:"+(System.currentTimeMillis()-begin)+"ms");
		
		
		begin=System.currentTimeMillis();
		for(int j=0;j<vector.size()/10;j++){
			vector.contains(vector.get(j));
		}
		System.out.println("vector time:"+(System.currentTimeMillis()-begin)+"ms");
		
		
//		begin=System.currentTimeMillis();
//		for(i=0;i<1000;i++){
//			for(int j=0;j<map.size()/10;j++){
//				hashMap.containsKey(map.get(j));
//		//}
//		}
//		System.out.println("map time:"+(System.currentTimeMillis()-begin)+"ms");


		begin=System.currentTimeMillis();
		for(int j=0;j<hashMap.size()/10;j++){
			hashMap.containsKey(hashMap.get(j));
		}
		System.out.println("hashMap time:"+(System.currentTimeMillis()-begin)+"ms");
		
		
		begin=System.currentTimeMillis();
		for(i=0;i<1000;i++){
			for(int j=0;j<hashTable.size()/10;j++){
				hashTable.containsKey(hashTable.get(j));
			//}
		}
		System.out.println("hashTable time:"+(System.currentTimeMillis()-begin)+"ms");

		
		begin=System.currentTimeMillis();	
				for(int j=0;j<sortedMap.size()/10;j++){
					sortedMap.containsKey(sortedMap.get(j));
				}
		System.out.println("sortedMap time:"+(System.currentTimeMillis()-begin)+"ms");
		
		
		begin=System.currentTimeMillis();
				for(int j=0;j<treeMap.size()/10;j++){
					treeMap.containsKey(treeMap.get(j));
				}
		System.out.println("treeMap time:"+(System.currentTimeMillis()-begin)+"ms");
		
		
//		begin=System.currentTimeMillis();
//		for(int j=0;j<set.size()/10;j++){
//			set.contains(hashSet.iterator());
//		}
//		System.out.println("set time:"+(System.currentTimeMillis()-begin)+"ms");

		
		begin=System.currentTimeMillis();
		for(int j=0;j<hashSet.size()/10;j++){
			hashSet.contains(hashSet.iterator());
		}
		System.out.println("hashSet time:"+(System.currentTimeMillis()-begin)+"ms");
		
		
		begin=System.currentTimeMillis();
			 for(int j=0;j<sortedSet.size()/10;j++){
					sortedSet.contains(j);
				}
		System.out.println("sortedSet time:"+(System.currentTimeMillis()-begin)+"ms");	
		
		
		begin=System.currentTimeMillis();
			 for(int j=0;j<treeSet.size()/10;j++){
				treeSet.contains(j);
				}
		System.out.println("treeSet time:"+(System.currentTimeMillis()-begin)+"ms");
	}
}

}