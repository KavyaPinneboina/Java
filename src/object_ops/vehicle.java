package object_ops;
import java.util.ArrayList;
public class vehicle {
	public double fuel;
	public double fuelCapacity;
	public double fuelConsumption;
	public double mileage;
	public double lifespan;
	public ArrayList<part> parts;
	public vehicle(double lifespan,double mileage, double fuelConsumption, double fuelCapacity,ArrayList Parts)
	{
		this.mileage=mileage;
		this.lifespan=lifespan;
		this.fuelCapacity=fuelCapacity;
		this.fuelConsumption=fuelConsumption;
		this.parts=Parts;
	}
	public void gotoDestination(double miles)
	{
		this.mileage=this.mileage+miles;
		this.fuel=this.fuel-this.fuelConsumption*miles;
	}
}
