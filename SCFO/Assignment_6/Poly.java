public class Poly 
{
	private int[][] polynomialEquation;
	
	/**
	 * Parameterized Constructor
	 * @param poly input passed as argument
	 */
	public Poly(int[][] poly)
	{
		polynomialEquation=poly.clone();	
	}
	
	/**
	 * Function for sorting of polynomial with respect to 
	 * @param arr passed as argument to function for sorting.
	 * @return return the sorted array.
	 */
	public int[][] sorting(int[][] arr)
	{
		int swapDegree, swapCoefficient, lengthOfArray=arr.length;
		for ( int i=0; i<lengthOfArray; i++ )
			for ( int j=i+1; j<lengthOfArray; j++ )
				if ( arr[i][1]<arr[j][1] )
				{
					swapCoefficient=arr[j][0];
					arr[j][0]=arr[i][0];
					arr[i][0]=swapCoefficient;
					swapDegree=arr[j][1];
					arr[j][1]=arr[i][1];
					arr[i][1]=swapDegree;
				}
		return arr;
	}
	
	/**
	 * Function to evaluate value of the polynomial.
	 * @param a input argument to calculate value of polynomial
	 * @return return the value of polynomial
	 */
	public float evaluateTheValueOfPolynomial(float a)
	{
		float value=0;		
		for(int i=0;i<polynomialEquation.length;i++)
		{
			if(polynomialEquation[i][0]!=0)
				value+=polynomialEquation[i][0]*Math.pow(a,polynomialEquation[i][1]);
		}
		return value;		
	}
	
	/**
	 * Return the degree of polynomial
	 * @param polynomialEquation Input argument of Polynomial to find its degree.
	 * @return Return the degree of polynomial
	 */
	public int degree(int[][] polynomialEquation)
	{
		return polynomialEquation[0][1];		
	}
	
	/**
	 * This function will add polynomial.
	 * @param polynomialP1 First polynomial as argument
	 * @param polynomialP2 Second polynomial as argument
	 * @return Return the addition of the polynomials
	 */
	int[][] addPoly(int[][] polynomialP1, int[][] polynomialP2)
	{
		int[][] resultAdd=new int[polynomialP1.length+polynomialP2.length][2];
		int arr1[][]=sorting(polynomialP1);
		int arr2[][]=sorting(polynomialP2);
		int i=0,j=0,k=0;
		while( i < arr1.length && j < arr2.length)
		{
			if ( arr1[i][1] == arr2[j][1] )
			{
				resultAdd[k][0] = arr1[i][0] + arr2[j][0];
				resultAdd[k][1] = arr1[i][1];
				i++;k++;j++;
			}
			else if ( arr1[i][1] > arr2[j][1])
			{
				resultAdd[k][0] = arr1[i][0];
				resultAdd[k][1] = arr1[i][1];
				i++;k++;
			}
			else
			{
				resultAdd[k][0] = arr2[j][0];
				resultAdd[k][1] = arr2[j][1];
				k++;j++;
			}
		}
		while ( i < arr1.length )
		{
			resultAdd[k][0] = arr1[i][0];
			resultAdd[k][1] = arr1[i][1];
			k++;i++;
		}
		while( j < arr2.length ){
			resultAdd[k][0] = arr2[j][0];
			resultAdd[k][1] = arr2[j][1];
			j++;k++;
		}
		return resultAdd;	
	}
	
	
	/**
	 * This function will multiply two polynomial
	 * @param polynomialR1 First polynomial as argument
	 * @param polynomialR2 Second polynomial as argument
	 * @return Return multiplication of two polynomial
	 */
	int[][] multiplyPolynomial(int[][] polynomialR1, int[][] polynomialR2)
	{
		polynomialR1=sorting(polynomialR1);
		polynomialR2=sorting(polynomialR2);
		int k=0;
		int temp = polynomialR1.length*polynomialR2.length;
		int[][] resultMultiply=new int[temp][2];
		int coefficient=0,exponent=0;
		for(int i=0; i<polynomialR1.length; i++)
			for(int j=0; j<polynomialR2.length; j++)
			{
				coefficient = polynomialR1[i][0]*polynomialR2[j][0];
				exponent = polynomialR1[i][1]+polynomialR2[j][1];
				resultMultiply[k][0] += coefficient;
				resultMultiply[k][1] = exponent;
				k++;
			}

		return resultMultiply;		
	}
}
