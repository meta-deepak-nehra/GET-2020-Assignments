
public class AreaOfTriangle 
{
	public double area(double a, double b, double c)
	{
		double s=(a+b+c)/2;
		double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return area;
	}

}
