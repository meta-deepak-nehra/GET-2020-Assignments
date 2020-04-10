package ques3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiVarPolyMain 
{
	private static Scanner sc;
	public static void main(String args[]) {
		boolean loop =true;
		while(loop){
			sc = new Scanner(System.in);
			MultiVarPoly polyObj = new MultiVarPoly();
			try 
			{
				System.out.print("\n\nEnter the number of variables in the polynomial : ");
				int numberOfVariable = sc.nextInt();

				int expoArr[] = new int[numberOfVariable + 1];
				System.out.print("Enter the number of terms in your polynomial : ");
				int numberOfTerms = sc.nextInt();
				
				for (int i=1;i<=numberOfTerms;i++) {
					System.out.print("Enter the coefficient of "+i+" terms : ");
					int coeff = sc.nextInt();
					
					//here the values of the exponents will be saved
					for (int j=1;j<=numberOfVariable;j++) {
						System.out.print("Enter exponent value for your "+j+" variable for "+i+" term : ");
						int exponent=sc.nextInt();
						expoArr[j]=exponent;
					}
					polyObj.createLinkList(coeff, expoArr);
				}
				
				polyObj.show();
				int maxPower=polyObj.findDegree();
				System.out.println("Maximum power in this polynomial is:"+maxPower);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
			} 
		}
	}
}
