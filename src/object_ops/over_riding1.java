package object_ops;

public class over_riding1 {
	   String s="kavya";
		public Object m1() {
			return null;
		}
		private void m2()
		{
			System.out.println("practicing modifiers");
		}
		public final void m3()
		{
			System.out.println("final modifiers can't be overridden and name also can't be used");
		}
		public void m4()
		{
			System.out.println("hi babes");
		}
		public static void m5()
		{
			System.out.println("parent");
		}
		public void m6(int... i)
		{
			System.out.println("va-args practicing");
		}
}
class child1 extends over_riding1{
	String s="srikar";
	public String m1() {
		return null;
	}
	private void m2()
	{
		System.out.println("private can't be overridden but can be used with same name");
	}
	/*public void m3()
	{
		System.out.println("trying to use final method");
	}*/
	/*public final void m4()
	{
		System.out.println("hi boss");
	}*/
	//protected abstract void m4(); - scope of method can't be reduced ,can be increased
	//public abstract void m4();
	public static void m5()
	{
		System.out.println("child");
	}
	public void m6(int i)
	{
		System.out.println("va-args in child class"); /* it becomes overloading*/
	}
}
class test1 extends child1{
	public void m4(){
		System.out.println("hi ,practicing over_riding with abstract method");
	}
	public static void main(String[] args) {
		child1 c1=new child1();
		//c1.m2();
		over_riding1 or=new over_riding1();
		//or.m2();
		System.out.println(c1.s);
		System.out.println(or.s);
		over_riding1 or1=new child1();
		System.out.println(or1.s); /* varibale resolution is taken care by compiler always*/
	}
}
