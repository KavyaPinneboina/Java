package collection_framework;
import java.util.*;
import java.io.*;

public class array_list {
	public static void main(String[] args) {
	ArrayList l=new ArrayList();
	l.add("kavya");
	l.add("blah blah");
	l.add(null);
	l.add("srikar");
	System.out.println(l);
	l.remove(null);
	System.out.println(l);
	boolean x=l.contains("kavya");
	System.out.println(x);
	l.add(3,"happy");
	System.out.println(l);
	Object o=l.get(2);
	System.out.println(o);
	l.set(2,"hi");
	System.out.println(l);
	l.add(1,7); /* if we try to add new object in middle ,it'll automatically move*/
	System.out.println(l);
	System.out.println(l instanceof Serializable);
	System.out.println(l instanceof Cloneable);
	System.out.println(l instanceof RandomAccess);
	LinkedList l1=new LinkedList();
	System.out.println(l1 instanceof RandomAccess);
	ArrayList l2=new ArrayList();
	l2.add(1);
	l2.add(2);
	l2.add(3);
	l2.add(3,4);
	l2.add(5);
	
	Iterator i=l2.iterator();
	while(i.hasNext())
	{
		Integer i1=(Integer)i.next();
		System.out.println(i1);
		if(i1==3)
		{
			i.remove();
		}
		}
	System.out.println(l2);
	LinkedList l3=new LinkedList();
	l3.add(2);
	l3.add(3);
	l3.add(4);
	l3.add(5);
	l3.add(5);
	ListIterator n=l3.listIterator();
	while(n.hasNext())
	{
		Integer i2=(Integer)n.next();
		System.out.println(i2+","+n.nextIndex());
		if(i2==3)
		{
			n.remove();
		}
		if(i2==4)
		{
			n.set(7);
		}
		if(n.hasPrevious())
		{
			System.out.println("I'm not first element");
		}
	}
	System.out.println(l3);
	}
	
}
