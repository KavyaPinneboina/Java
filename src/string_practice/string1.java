package string_practice;

public class string1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= new String("kavya");
		String s2=new String("kavya");
		StringBuffer sb1=new StringBuffer("srikar");
		StringBuffer sb2 = new StringBuffer("srikar");
		System.out.println(s1==s2); /*reference comparison*/
		System.out.println(s1.equals(s2)); /* overridden to compare content*/
		System.out.println(sb1==sb2); /*reference comparison*/
		System.out.println(sb1.equals(sb2)); /*reference comparison*/
		/*after concatination,i.e runtime object is placed in heap , since there is no reference ,it is eligible for garbage collection*/
		s1.concat("pinneboina"); /*since we have literal object is created in string constant pool*/
		/*now onwards s1 refers to kavyapinneboina created in next step*/
		s1=s1.concat("pinneboina");
		char[] ch= {'k','a','v','y','a'};
		String s=new String(ch);
		System.out.println(s);
		byte[] b= {98,97,99,46,-1,-127,12};
		String s3=new String(b);
		System.out.println(s3);
	}

}
