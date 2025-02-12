package string_practice;

public class comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer(6);
		String s="";
		if (sb.equals(s))
		{
			System.out.println("match 1");
		}
		else if(sb.toString().equals(s.toString()))
		{
			System.out.println("match 2");
		}
		else
		{
			System.out.println("no match");
		}

	}

}
