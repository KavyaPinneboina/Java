package collection_framework;
import java.util.*;

class employee implements Comparable{
	String name;
	int eid;
	employee(String name,int eid)
	{
		this.name=name;
		this.eid=eid;
	}
	public String toString()
	{
		return name+"--"+eid; /*without toString it'll print the adress*/
	}
	public int compareTo(Object obj)
	{
		int eid1=this.eid;
		employee e=(employee)obj;
		int eid2=e.eid;
		if(eid1<eid2)
		{
			return -1;
		}
		else if(eid1>eid2)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
class myComparable implements Comparator{
	public int compare(Object obj1,Object obj2)
	{
		employee e1=(employee)obj1;
		employee e2=(employee)obj2;
		String s1=e1.name;
		String s2=e2.name;
		return s1.compareTo(s2);
	}
}

public class customized_compareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		employee e1= new employee("kavya",2);
		employee e2= new employee("srikar",5);
		employee e3= new employee("divya",1);
		employee e4= new employee("rajini",3);
		employee e5= new employee("ramarao",6);
		employee e6= new employee("akanksha",4);
		TreeSet t=new TreeSet();
		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e5);
		t.add(e4);
		t.add(e6);
		System.out.println(t);
		TreeSet t1=new TreeSet(new myComparable());
		t1.add(e1);
		t1.add(e3);
		t1.add(e5);
		System.out.println(t1);
		
	}

}
