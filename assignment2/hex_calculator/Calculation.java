import java.util.Scanner;
public class Calculation 
{
	private String hexNumber1, hexNumber2,outputHexNumber;
	private int intNumber1,intNumber2,outputIntNumber;
	
	void welcomeScreen()
	{
		Scanner inr = new Scanner(System.in);
		System.out.println("Hex Calculator");
		System.out.println("Choose which operation you want to perform");
		System.out.println("1.Addition");
		System.out.println("2.Difference");
		System.out.println("3.Multiplication");
		System.out.println("4.Division");
		System.out.println("5.Comparing the Numbers");
		System.out.println("6.Exit");
		int b = inr.nextInt();
		if(b>6||b<1)
		{
			System.out.println("Your Choice is Invalid");
			welcomeScreen();
		}
		switch(b)
		{
		case 1:
			addition();
			break;
		case 2:
			difference();
			break;
		case 3:
			multiply();
			break;
		case 4:	
			divide();
			break;
		case 5:	
			compare();
			break;	
		case 6:	
			end();
			break;
		}
		inr.close();
	}
	
	void getData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st number");
		hexNumber1 = sc.nextLine();
		System.out.println("Enter 2nd number");
		hexNumber2 = sc.nextLine();
		TypeConversion obj= new TypeConversion();
		intNumber1= obj.hexToInt(hexNumber1);
		intNumber2= obj.hexToInt(hexNumber2);
		sc.close();
	}
	
	void addition()
	{
		getData();
		outputIntNumber= intNumber1+intNumber2;
		TypeConversion obj= new TypeConversion();
		outputHexNumber= obj.intToHex(outputIntNumber);
		System.out.println("Addition of "+hexNumber1+" and "+hexNumber2+" = "+outputHexNumber);
		end();
	}
	
	void difference()
	{
		getData();
		if(intNumber1>intNumber2)
			outputIntNumber= intNumber1-intNumber2;
		else
			outputIntNumber= intNumber2-intNumber1;
		TypeConversion obj= new TypeConversion();
		outputHexNumber= obj.intToHex(outputIntNumber);
		System.out.println("Difference of "+hexNumber1+" and "+hexNumber2+" = "+outputHexNumber);
		end();
	}
	
	void multiply()
	{
		getData();
		outputIntNumber= intNumber1*intNumber2;
		TypeConversion obj= new TypeConversion();
		outputHexNumber= obj.intToHex(outputIntNumber);
		System.out.println("Multiplication of "+hexNumber1+" and "+hexNumber2+" = "+outputHexNumber);
		end();
	}
	
	void divide()
	{
		getData();
		outputIntNumber= intNumber1/intNumber2;
		TypeConversion obj= new TypeConversion();
		outputHexNumber= obj.intToHex(outputIntNumber);
		System.out.println("Division of "+hexNumber1+" and "+hexNumber2+" = "+outputHexNumber);
		end();
	}
	
	void compare()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st number");
		hexNumber1 = sc.nextLine();
		System.out.println("Enter 2nd number");
		hexNumber2 = sc.nextLine();
		int comparisonResult = hexNumber1.compareTo(hexNumber2);
		boolean comparisonResult1 = hexNumber1.equalsIgnoreCase(hexNumber2);
		if (comparisonResult1 == false) 
		{
			System.out.println(hexNumber2+" and "+hexNumber1+" are equal ");
		}
		if (comparisonResult < 0) 
		{
			System.out.println(hexNumber2+" is greater than "+hexNumber1);
		}
		else if (comparisonResult > 0) 
		{
			System.out.println(hexNumber1+" is greater than "+hexNumber2);
		}
		sc.close();
		end();
	}
	void end()
	{
		System.out.println("Thanks!");
		System.exit(0);
	}
}
