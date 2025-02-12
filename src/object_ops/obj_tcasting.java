package object_ops;

public class obj_tcasting {
	public static void main(String[] args)
	{
		Object o=new String("kavya");
		//StringBuffer sb=(StringBuffer)o; - it is runtime error ,bcz runtime object of 'o' is string whihc is not same or child of Stringbuffer.
		String s=new String("srikar");
		//StringBuffer sb1=(StringBuffer)s; - string and stringbuffer doesn't have nay relation
		//StringBuffer sb2=(String)o; - stringbuffer is neither same nor child
		String s1=(String)o;
		System.out.println(s1);
	}

}
