package serialization;
import java.io.*;
/* before serializing a object the class must implement serializable interface */
class dog implements Serializable{
	
	int i=10;
	transient int j=20; /*if we don't want to store original value during serialization for security */
			
}
public class prac_serialization1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		dog d1=new dog();
		FileOutputStream fos=new FileOutputStream("abc.ser");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(d1);
		FileInputStream fis= new FileInputStream("abc.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		dog d2=(dog)ois.readObject();
		System.out.println(d2.i+","+d2.j);
		
		}

}
