package jvm;

public class run_time_object {
	public static void main(String[] args)
	{
		Runtime r=Runtime.getRuntime();
		System.out.println(r.freeMemory()/(1024*1024));  /* to get output in terms of mb*/
		System.out.println(r.totalMemory());
		System.out.println(r.maxMemory());
	}

}
