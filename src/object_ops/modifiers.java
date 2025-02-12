package object_ops;

final class modifiers {
     int sum=100;
     public void method1()
     {
    	 System.out.println("hi I'm from final class");
     }
}
/*class dog extends modifiers{
	if we use final keyword ,no child is possible.
}*/
class dog{
	public static void main(String[] args) {
	modifiers m1=new modifiers();
	m1.method1();
	new_mod1 m3 =new new_mod1();
	m3.met_hod1();
	}
	
}
