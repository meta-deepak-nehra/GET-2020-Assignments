public class AreaForTriangle implements InterfaceForArea
{
	public void area(double baseOfTriangle, double heightOfTriangle) 
	{
		double areaOfTriangle= baseOfTriangle*heightOfTriangle*0.5;
		System.out.println("The area of triangle is :"+areaOfTriangle);
	}
}
