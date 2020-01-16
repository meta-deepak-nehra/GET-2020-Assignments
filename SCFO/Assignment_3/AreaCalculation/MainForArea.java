import java.util.Scanner;


public class MainForArea 
{

	public static void main(String[] args) 
	{
		Scanner inr = new Scanner(System.in);
		System.out.println("Please choose from following options");
		System.out.println("1.For Triangle");
		System.out.println("2.For Circle");
		System.out.println("3.For Square");
		System.out.println("4.For Rectangle");
		System.out.println("5.Exit");
		int b = inr.nextInt();
		if(b>5||b<1)
		{
			System.out.println("Your Choice is Invalid");
			end();
		}
		switch(b)
		{
		case 1:
			InterfaceForArea obj1 = new AreaForTriangle();
			System.out.println("Enter the base of triangle ");
			double baseOfTriangle= inr.nextDouble();
			System.out.println("Enter the height of triangle ");
			double heightOfTriangle=inr.nextDouble();
			obj1.area(baseOfTriangle,heightOfTriangle);
			break;
		case 2:
			InterfaceForArea obj2 = new AreaForCircle();
			System.out.println("Enter the radius of circle ");
			double radiusOfCircle=inr.nextDouble();
			double radiusOfCircle1=radiusOfCircle;
			obj2.area(radiusOfCircle,radiusOfCircle1);
			break;
		case 3:	
			InterfaceForArea obj3 = new AreaForSquare();
			System.out.println("Enter the side of square ");
			double sideOfSquare=inr.nextDouble();
			double sideOfSquare1=sideOfSquare;
			obj3.area(sideOfSquare,sideOfSquare1);
			break;
		case 4:
			InterfaceForArea obj4 = new AreaForRectangle();
			System.out.println("Enter the width of rectangle ");
			double widthOfRectangle=inr.nextDouble();
			System.out.println("Enter the height of rectangle ");
			double heightOfRectangle=inr.nextDouble();
			obj4.area(widthOfRectangle,heightOfRectangle);
			break;
		case 5:	
			end();
			break;
		}
		inr.close();
	}
	
	
	static void end()
	{
		System.out.println("Thanks!");
		System.exit(0);
	}

}

interface InterfaceForArea
{
	void area(double a ,double b);
}
