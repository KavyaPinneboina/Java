package data_types;

public class operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=24,num2=36;
		char ch='a';
		int sum=num1+num2;
		int sub=num1-num2;
		int mul=num1*3;
		int div=num1/2;
		int mod=num1%3;
		System.out.println(sum+" ,"+sub+" ,"+mul+" ,"+div+","+mod);
		if(num1<num2)
		{
			System.out.println("num2 greatest\n");
		}
		else if(num1>num2)
		{
			System.out.println("num1 greatest\n");
		}
		else
		{
			System.out.println("both are equal");
		}
		num1+=10;
		num2-=10;
		if(num1%2==0 && num2%2==0)
		{
			System.out.println("both are even\n");
		}
		if(num1%2==0 || num2%2==0)
		{
			System.out.println("only one is even\n");
		}
		if(num1%2!=0)
		{
			System.out.println("num1 is composite\n");
		}
		int x=num1>num2?num1:num2;
		System.out.println(x);
		x++;
		int num3=(num2>>1);
		int num4=(num1<<1);
		int num5=(x&num1);
		System.out.println(num3+" ,"+num4+" ,"+num5);
		
	}

}
