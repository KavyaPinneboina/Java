package object_ops;

public class over_riding {
		public void property()
		{
			System.out.println("properties : gold,money,land");
		}
	    public void marriage()
	    {
	    	System.out.println("arrange marriage");
	    }
}
class child extends over_riding{
	public void marriage() {
		System.out.println("love+arrange marriage");
	}
}
class test{
	public static void main(String[] args) {
	over_riding o1=new over_riding();
	child m1= new child();
	over_riding o2=new child();
	o1.property();
	o1.marriage();
	m1.property();
	m1.marriage();
	o2.marriage();
	}
}
