package object_ops;
import java.util.ArrayList;
public class driver {
	private vehicle availableVehicle;
	
	public void rentvehicle(vehicle v)
	{
		this.availableVehicle=v;
		System.out.println("driver has now a vehicle to drive");
	}
	public void driveVehicle(double miles)
	{
		if(this.availableVehicle!=null)
		{
			this.availableVehicle.gotoDestination(miles);
			System.out.println("driver drives the vehicle safely");
		}
	}
	public void returnVehicle() {
		this.availableVehicle=null;
		System.out.println("driver returns the vehicle");
	}

}
