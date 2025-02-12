package object_ops;

abstract class mod_fiers1 {
	int a=2,b=3;
	abstract void met_hod1();
	abstract void met_hod2();
	public void met_hod3()
	{
		System.out.println("I'm implemented method of abstract class");
	}
}
abstract class new_mod extends mod_fiers1{
	int a=10;
	public void met_hod1()
	{
		System.out.println("I have instantiated from child class of abstract❤️");
	}
	//public static void main(String[] args) {
		//mod_fiers1 m1=new mod_fiers1();-we cannot create objects for abstract class
		//new_mod m1=new new_mod();
		//m1.met_hod1();
		//int sum=m1.a+m1.b;
		//System.out.println("sum = "+sum);
		//modifiers m2=new modifiers();
		//m2.method1();
		//}
}
class new_mod1 extends new_mod{
	public void met_hod2()
	{
		System.out.println("I'm from multilevel inheritence and implementation of super class abstract method");
	}
	public static void main(String[] args)
	{
		new_mod1 m1=new new_mod1();
		m1.met_hod2();
		m1.met_hod1();
		m1.met_hod3();
		System.out.println(m1.a);
		
	}

}