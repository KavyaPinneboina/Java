package object_ops;

public class met_ol {
	int sum=100;
	public void met_hods1() {
		System.out.println("practicing method over loading");
	}
	public void met_hods1(int x)
	{
		sum=sum+x;
	}

}
class met_ol1 extends met_ol{
	public static void main(String[] args)
	{
		met_ol1 m1=new met_ol1();
		m1.met_hods1();
		m1.met_hods1(200);
	 System.out.println(m1.sum);
	}
}
