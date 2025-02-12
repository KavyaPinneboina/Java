package collection_framework;
import java.util.*;

public class comparator {
	public static void main(String[] args) {
	TreeSet t=new TreeSet(new myComparator());
	t.add(new StringBuffer("A"));
	t.add(new StringBuffer("r"));
	t.add(new StringBuffer("s"));
	t.add(4);
	System.out.println(t);
	
	}
}
class myComparator implements Comparator{
	public int compare(Object o1,Object o2)
	{
		String s1=o1.toString();
		String s2=o2.toString();
		return -(s1.compareTo(s2));
	}
}
