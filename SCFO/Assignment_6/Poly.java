import java.util.Scanner;


public class Poly 
{
	private int[] polynomialEquation;
	
	public int[] setDataToThePolynomial()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the degree of polynomial");
		int highestDegree=sc.nextInt();
		polynomialEquation= new int[highestDegree+1];
		for(int i=0;i<=highestDegree;i++)
		{
			System.out.println("Enter the coefficient of x^"+i);
			int coefficientValue=sc.nextInt();
			polynomialEquation[i]=coefficientValue;
		}
		//sc.close();
		return polynomialEquation;		
	}
	
	public float evaluateTheValueOfPolynomial(float a)
	{
		float value = 0;
		for(int i=0;i<polynomialEquation.length;i++)
		{
			if(i==0)
				value=polynomialEquation[i];
			else
			{
				float temp=1;
				for(int j=0;j<i;j++)
				{
					temp=a*temp;
				}
				value= value+ polynomialEquation[i]*temp;
			}	
		}
		return value;
	}
	
	public int degree(int[] polynomialEquation)
	{
		return polynomialEquation.length-1;		
	}

	int[] addPoly(int[] polynomialP1, int[] polynomialP2)
	{
		if(polynomialP1.length>polynomialP2.length)
		{
			int resultPolynomial[]=new int[polynomialP1.length];
			int temp=polynomialP1.length-polynomialP2.length;
			for(int i=0;i<temp;i++)
				resultPolynomial[polynomialP2.length+i]=polynomialP1[polynomialP2.length+i];
			for(int i=0;i<polynomialP2.length;i++)
				resultPolynomial[i]=polynomialP1[i]+polynomialP2[i];
			return resultPolynomial;
		}
		else
		{
			int resultPolynomial[]=new int[polynomialP2.length];
			int temp=polynomialP2.length-polynomialP1.length;
			for(int i=0;i<temp;i++)
				resultPolynomial[polynomialP1.length+i]=polynomialP2[polynomialP1.length+i];
			for(int i=0;i<polynomialP1.length;i++)
				resultPolynomial[i]=polynomialP1[i]+polynomialP2[i];	
			return resultPolynomial;
		}
	}
	
	public int[] multiplyPoly(int[] polynomialP1, int[] polynomialP2)
	{
		int lengthOfResultPolynomial=polynomialP1.length+polynomialP2.length-1;
		int resultPolynomial[]=new int[lengthOfResultPolynomial];
		for(int i=0;i<polynomialP1.length;i++)
		{
			for(int j=0;j<polynomialP2.length;j++)
			{
				resultPolynomial[i+j]=resultPolynomial[i+j]+polynomialP1[i]*polynomialP2[j];
			}
		}
		return resultPolynomial;
	}
	
	void showAnswerToUser(int[] polynomial)
	{
		for(int i=polynomial.length-1;i>=0;i--)
			if(i==0)
				System.out.printf("%d",polynomial[i]);
			else
				System.out.printf("%dx^%d+",polynomial[i],i);
	}
	/*public static void main(String[] args) 
	{
		int a[]={5,0,10,4};
		int b[]={5,1};
		int c[]= multiplyPoly(a,b);
		for(int i=c.length-1;i>=0;i--)
			if(i==0)
				System.out.printf("%d",c[i]);
			else
				System.out.printf("%dx^%d+",c[i],i);
	}*/

}
