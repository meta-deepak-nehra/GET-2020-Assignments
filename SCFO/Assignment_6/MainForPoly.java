import java.util.Scanner;


public class MainForPoly 
{
	public static void main(String[] args) 
	{
		Scanner inr = new Scanner(System.in);
		Poly obj= new Poly();
		int br;
		//System.out.println("Enter the polynomial");
		int[] polynomial= obj.setDataToThePolynomial();
		System.out.println("Please choose from following options");
		System.out.println("1.Evaluate value of following polynomial");
		System.out.println("2.Degree of polynomial");
		System.out.println("3.Add polynomial");
		System.out.println("4.Multiply polynomial");
		br = inr.nextInt();
		if(br>4||br<1)
		{
			System.out.println("Your Choice is Invalid");
			System.exit(0);
		}
		switch(br)
		{
		case 1:
			System.out.println("Enter the value you want to evaluate for");
			float a = inr.nextFloat();
			float r=obj.evaluateTheValueOfPolynomial(a);
			System.out.println("Value of following polynomial is :"+r);
			break;
		case 2:
			int c=obj.degree(polynomial);
			System.out.println("Degree of given polynomial is :"+c);
			break;
		case 3:
			System.out.println("Enter the polynomial 1");
			int[] p1=obj.setDataToThePolynomial();
			System.out.println("Enter the polynomial 2");
			int[] p2=obj.setDataToThePolynomial();
			int[] result=obj.addPoly(p1,p2);
			obj.showAnswerToUser(result);
			break;
		case 4:	
			System.out.println("Enter the polynomial 1");
			int[] P1=obj.setDataToThePolynomial();
			System.out.println("Enter the polynomial 2");
			int[] P2=obj.setDataToThePolynomial();
			int[] multiplyResult=obj.multiplyPoly(P1,P2);
			obj.showAnswerToUser(multiplyResult);
			break;
		}
		//inr.close();
	}
}
