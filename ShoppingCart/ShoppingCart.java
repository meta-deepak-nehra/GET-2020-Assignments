import java.util.*;

public class ShoppingCart 
{
	int total;
	int ItemCode[]= new int[5];
	String ItemName[]=new String[5];
	int ItemPrice[]=new int[5];
	ArrayList<Product> itemsInCart= new ArrayList<Product>();

	void SetData()
	{
		ItemCode[0]=1;
		ItemCode[1]=2;
		ItemCode[2]=3;
		ItemCode[3]=4;
		ItemCode[4]=5;
		ItemName[0]="Coke";
		ItemName[1]="Pizza";
		ItemName[2]="Burger";
		ItemName[3]="Fries";
		ItemName[4]="Ice Cream";
		ItemPrice[0]=140;
		ItemPrice[1]=290;
		ItemPrice[2]=110;
		ItemPrice[3]=105;
		ItemPrice[4]=120;
	}

	void ShowandSet()
	{
		Scanner ins = new Scanner(System.in);
		System.out.println("Code    Rate        Name");
		for( int i=0;i<5;i++)
		{
			System.out.println(ItemCode[i]+"       "+ItemPrice[i]+"        "+ItemName[i]);
		}
		int s= ins.nextInt();
		if(s>5||s<1)
		{
			System.out.println("Your Choice is Invalid");
		}
		else
		{
			for(int j=0;j<5;j++)
			{
				if(s==ItemCode[j])
				{
					System.out.print("Quantity:");
					int ItemQuantity= ins.nextInt();
					Product product =new Product(ItemCode[j], ItemName[j], ItemPrice[j]*ItemQuantity, ItemQuantity);
					itemsInCart.add(product);

				}
			}
			welcome();
		}

		ins.close();
	}

	void welcome()
	{
		Scanner inr = new Scanner(System.in);
		System.out.println("Please choose from following options");
		System.out.println("1.Shopping");
		System.out.println("2.View Cart");
		System.out.println("3.Generate Bill");
		System.out.println("4.Exit");
		SetData();
		int b = inr.nextInt();
		if(b>4||b<1)
		{
			System.out.println("Your Choice is Invalid");
			welcome();
		}
		switch(b)
		{
		case 1:
			ShowandSet();
			break;
		case 2:
			cart();
			break;
		case 3:
			bill();
			break;
		case 4:	
			end();
			break;
		}
		inr.close();
	}

	void cart()
	{
		total=0;
		System.out.println("Code    Price        Name");
		for( int j=0;j<itemsInCart.size();j++)
		{
			{	
				total=total+itemsInCart.get(j).getItemRate(); 
				System.out.printf(itemsInCart.get(j).getItemCode()+"	"+itemsInCart.get(j).getItemRate()+"	"+itemsInCart.get(j).getItemName());
			}
		}	
		System.out.println("Total Amount is "+ total);
		welcome();
	}
	
	void bill()
	{
		System.out.println("Amount to pay: "+ total);
		System.out.println("Thanks for Shopping.Visit Again.");
		welcome();
	}

	void end()
	{
		System.out.println("Thanks!");
		System.exit(0);
	}
}
