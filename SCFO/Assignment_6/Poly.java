import java.util.Scanner;


public class Poly 
{
	private int[] polynomialEquation;
	
	void setDataToThePolynomial()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the degree of polynomial");
		int highestDegree=sc.nextInt();
		for(int i=0;i<=highestDegree;i++)
		{
			System.out.println("Enter the coefficient of x^"+i);
			int coefficientValue=sc.nextInt();
			polynomialEquation[i]=coefficientValue;
		}
		sc.close();
	}
	
	float evaluateTheValueOfPolynomial(float a)
	{
		float value = 0;
		for(int i=0;i<=polynomialEquation.length;i++)
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
	
	

}
