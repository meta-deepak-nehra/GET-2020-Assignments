import java.util.Scanner;
public class MainPoly 
{
	static Scanner inr = new Scanner(System.in);
	
	/**
	 * Function for setting the polynomial.
	 * @return
	 */
	public static int[][] getPoly(){
		System.out.println("Enter the number of terms in polynomial");
		int numberOfTerms=inr.nextInt();
		int[][] polynomialToSet= new int[numberOfTerms][2];
		for(int i=0;i<numberOfTerms;i++)
		{
			System.out.println("Enter the exponent");
			int tempExponent=inr.nextInt();
			System.out.println("Enter the coefficient");
			int tempCoefficient=inr.nextInt();
			polynomialToSet[i][0]=tempCoefficient;
			polynomialToSet[i][1]=tempExponent;
		}
		return polynomialToSet;
	}
	
	/**
	 * Main Function
	 * @param args Input arguments for main function.
	 */
	public static void main(String[] args) 
	{
		int polynomialToSet[][] = getPoly();
		Poly obj= new Poly(polynomialToSet);
		System.out.println("Please choose from following options");
		System.out.println("1.Evaluate value of polynomial");
		System.out.println("2.Degree of polynomial");
		System.out.println("3.Add polynomial");
		System.out.println("4.Multiply polynomial");
		int br = inr.nextInt();
		if(br>4||br<1)
		{
			System.out.println("Your Choice is Invalid");
			System.exit(0);
		}
		switch(br)
		{
			case 1:
				
				System.out.println("Enter the float value for which you want to evaluate value of polynomial");
				float  c=inr.nextFloat();
				float value=obj.evaluateTheValueOfPolynomial(c);
				System.out.println("The value of polynomial is "+value);
				System.exit(0);
		
			case 2:
				int[][] tempToShow1=obj.sorting(polynomialToSet);
				int d=obj.degree(tempToShow1);
				System.out.println("Degree of given polynomial is :"+d);
				System.exit(0);
			
			case 3:	
				int polynomialToSet2[][] = getPoly();
				int polynomialToSet3[][] = getPoly();
				int[][] resultOfAdd=obj.addPoly(polynomialToSet2, polynomialToSet3);
				System.exit(0);
			
			case 4:	
				int polynomialSet1[][] = getPoly();
				int polynomialSet2[][] = getPoly();
				int[][] resultOfMultiply=obj.multiplyPolynomial(polynomialSet1, polynomialSet2);
				System.exit(0);				
		}
		inr.close();
	}

}
