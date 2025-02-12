package string_practice;

final class immutable_class {
	private int i;
  immutable_class(int i)
	{
		this.i=i;
	}
	public immutable_class modify(int i)
	{
		if(this.i==i)
		{
			return this;
		}
		else
		{
			return new immutable_class(i);
		}
	}

}
class test{
	public static void main(String[] args)
	{
		immutable_class i1=new immutable_class(10);
		immutable_class i2=i1.modify(100);
		immutable_class i3=i1.modify(10);
		System.out.println(i1==i2);
		System.out.println(i1==i3);
	}
}
