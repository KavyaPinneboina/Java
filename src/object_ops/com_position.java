package object_ops;
import java.util.ArrayList;
public class com_position {
	public static void main(String[] args)
	{
		ArrayList<part> bmwParts=new ArrayList<part>();
		part bmwEngine=new part();
		part bmwBody=new part();
		bmwParts.add(bmwEngine);
		bmwParts.add(bmwBody);
		
		vehicle bmw=new vehicle(1500,500,50,0.7,bmwParts);
		
		ArrayList<part> volvoParts= new ArrayList<part>();
		part volvoEngine=new part();
		part volvoBody=new part();
		volvoParts.add(volvoEngine);
		volvoParts.add(volvoBody);
		vehicle volvo=new vehicle(1400,400,40,0.6,volvoParts);
		
		}
}
