import java.util.Scanner;
public class MainForIntSet 
{
	/**
	 * Main function for running the program
	 * @param args String argument as input to mian
	 */
	public static void main(String[] args) 
	{
		Scanner inr = new Scanner(System.in);
		
		System.out.println("Enter the number of values of set");
		int ab=inr.nextInt();
		int setToPass[]=new int[ab];
		System.out.println("Enter the values of set");
		for(int i=0;i<ab;i++)
		{	
			int s=inr.nextInt();
			setToPass[i]=s;
		}	
		IntSet obj= new IntSet(setToPass);
		System.out.println("Please choose from following options");
		System.out.println("1.Check whether following element is present in set or not");
		System.out.println("2.Size of set");
		System.out.println("3.Following set is subset or not");
		System.out.println("4.Complement of set");
		System.out.println("5.Union of set");
		int b = inr.nextInt();
		if(b>5||b<1)
		{
			System.out.println("Your Choice is Invalid");
			System.exit(0);
		}
		switch(b)
		{
		case 1:
			System.out.println("Enter the value of element you want to check");
			int a = inr.nextInt();
			boolean sr=obj.isMemberOfSet(a);
			if(sr==true)
				System.out.println("Element is present in set.");
			else
				System.out.println("Element is not present in set.");
			break;
		case 2:
			int c=obj.size();
			System.out.println("Size of given set is :"+c);
			break;
		case 3:
			System.out.println("Enter the number of values of subset");
			int abc=inr.nextInt();
			int subsetToPass[]=new int[abc];
			System.out.println("Enter the values of set");
			for(int i=0;i<abc;i++)
				subsetToPass[i]=inr.nextInt();
			boolean result=obj.isSubSet(subsetToPass);
			if(result==true)
				System.out.println("It is a subset of set");
			else
				System.out.println("It is not a subset of set");
			break;
		case 4:	
			int[] resultComplement=obj.getComplement();
			System.out.println("Complement is:");
			for(int i=0;i<resultComplement.length;i++)
			{
				System.out.println(resultComplement[i]);
			}
			break;
		case 5:
			System.out.println("Enter the number of values of set 1");
			int abc1=inr.nextInt();
			int set1ToPass[]=new int[abc1];
			System.out.println("Enter the values of set 1");
			for(int i=0;i<abc1;i++)
				set1ToPass[i]=inr.nextInt();
			System.out.println("Enter the number of values of set 2");
			int abc2=inr.nextInt();
			int set2ToPass[]=new int[abc2];
			System.out.println("Enter the values of set 2");
			for(int i=0;i<abc2;i++)
				set2ToPass[i]=inr.nextInt();
			int[] unionSet=obj.union(set1ToPass,set2ToPass);
			System.out.println("Union is:");
			for(int i=0;i<unionSet.length;i++)
			{
				System.out.println(unionSet[i]);
			}
			break;
		}
		inr.close();
		
	}
}
