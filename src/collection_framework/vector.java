package collection_framework;
import java.util.*;

public class vector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector v=new Vector();
		System.out.println(v.capacity());
		v.addElement("where");
		v.add("are");
		v.addLast("you");
		System.out.println(v.size());
		System.out.println(v);
		Vector v1=new Vector(3,2);
		v1.add("I'm");
		v1.add("in");
		v1.addElement("cafeteria");
		System.out.println(v1.capacity());
		System.out.println(v1);
		v1.add("please come");
		System.out.println(v1.capacity());
		Enumeration e= v.elements();
		while(e.hasMoreElements())
		{
			Integer i=(Integer)e.nextElement();
			System.out.println(i);
		}
		
	}

}
