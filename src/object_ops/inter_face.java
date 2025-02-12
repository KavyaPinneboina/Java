package object_ops;

public interface inter_face {
	public void inter_method();
	public void inter_method1();
}

class new_inter implements inter_face{
	public void inter_method() {
		System.out.println("practicing interface");
	}
	public void inter_method1() {
		System.out.println("this is second method from interface");
	}
	public static void main(String[] args) {
		new_inter n1=new new_inter();
		n1.inter_method();
		n1.inter_method1();
	}
}
