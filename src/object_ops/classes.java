package object_ops;

public class classes {
	public int student;
	public classes(int x) {
		this.student=x;
	}
	public void method1()
	{
		System.out.println("hi I'm first method");
	}
	public static int method2(int a)
	{
		int sum=5;
		sum=sum+a;
		return sum;
	}
	public static void method2()
	{
		System.out.println("testing method over-loading");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classes cl=new classes(30);
		System.out.println(cl.student);
		classes cl1=new classes(50);
		System.out.println("students in class1:"+cl1.student);
		cl.method1();
		int x=classes.method2(20);
		System.out.println("new sum ="+x);
		classes.method2();
	}

}
