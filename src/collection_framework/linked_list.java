package collection_framework;
import java.util.*;
public class linked_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l=new LinkedList();
		l.add(1);
		l.add("hi");
		l.add("how are you");
		l.add(2);
		System.out.println(l);
		System.out.println(l.getFirst());
		System.out.println(l.get(0));
		l.addFirst("kavya");
		System.out.println(l.getFirst());
		l.removeLast();
		System.out.println(l);
	}

}
