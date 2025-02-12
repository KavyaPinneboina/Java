package string_practice;

public class string_buffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(20);
		System.out.println(sb.capacity());
		sb.append("abcdefghijklmnop");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.append("qrstuvwxyz");
		System.out.println(sb.capacity()); /* new capacity=(current capacity+1)*2 */
		System.out.println(sb.length());
		StringBuffer sb1=new StringBuffer("kavya");
		System.out.println(sb1.capacity());
		/*System.out.println(sb.charAt(27));  - string index out of bounds exception */
		sb.setCharAt(4, 'f');
		System.out.println(sb);
		StringBuffer sb2= new StringBuffer(50);
		sb2.append("PI value is ");
		sb2.append(3.14);
		sb2.append(':');
		sb2.append(true);
		System.out.println(sb2);
		System.out.println(sb.reverse());
		sb1.setLength(13);
		System.out.println(sb1.length());
		StringBuffer sb4=sb1.append("kavya").append("srikar").reverse().insert(5, "happy");
		System.out.println(sb4);
	}

}
