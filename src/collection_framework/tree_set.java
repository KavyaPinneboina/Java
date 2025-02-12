package collection_framework;
import java.util.*;

public class tree_set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet t=new TreeSet();
		t.add(3);
		t.add(5);
		//t.add("kavya"); - heterogenous not allowed
		t.add(25);
		t.add(1);
		t.add(null);
		System.out.println(t);
		System.out.println(t.first());
		System.out.println(t.last());
		System.out.println(t.headSet(5));
		System.out.println(t.subSet(1, 25));

	}

}
