import java.util.Scanner;


public class StringOperations 
{
	void userInteractionScreen()
	{
		Scanner inr = new Scanner(System.in);
		System.out.println("Please choose from following options");
		System.out.println("1.Compare Two Strings");
		System.out.println("2.Replace lowercase characters with uppercase and vice-versa");
		System.out.println("3.Reversing the Strings");
		System.out.println("4.To find longest word from string");
		System.out.println("5.Exit");
		int b = inr.nextInt();
		if(b>5||b<1)
		{
			System.out.println("Your Choice is Invalid");
			userInteractionScreen();
		}
		switch(b)
		{
		case 1:
			compareTheStrings();
			break;
		case 2:
			String str=takeInputFromUser();
			replaceUpperLowerCharacters(str);
			break;
		case 3:	
			String stj=takeInputFromUser();
			reverseTheString(stj);
			break;
		case 4:
			String sjd=takeInputFromUser();
			findLargestWord(sjd);
			break;
		case 5:	
			end();
			break;
		}
		inr.close();
	}
	
	String takeInputFromUser()
	{
		String userInputString;
		Scanner inr = new Scanner(System.in);
		System.out.println("Enter the string:");
		userInputString= inr.nextLine();
		inr.close();
		return userInputString;
	}
	
	void replaceUpperLowerCharacters(String userInputString)
	{
		StringBuilder string = new StringBuilder(userInputString);
		for( int i=0;i<userInputString.length();i++)
		{
			char ch=userInputString.charAt(i);
			int asciiValueOfCharacter=ch;
			if((asciiValueOfCharacter==0)||(asciiValueOfCharacter==32))
				System.out.println(i);
			else if(asciiValueOfCharacter<97)
			{
				asciiValueOfCharacter=asciiValueOfCharacter+32;
				ch=(char) asciiValueOfCharacter;
				string.setCharAt(i, ch);
			}
			else
			{
				asciiValueOfCharacter=asciiValueOfCharacter-32;
				ch=(char) asciiValueOfCharacter;
				string.setCharAt(i, ch);
			}
		}
		System.out.println("Your final string is here:");
		System.out.println(string);
	}
	void reverseTheString(String userInputString)
	{
		String reversedString = new String();
		for( int i=(userInputString.length()-1);i>=0;i--)
		{
			char ch=userInputString.charAt(i);
			reversedString=reversedString+ch;
		}
		System.out.println(reversedString);
	}
	
	void compareTheStrings()
	{
		Scanner inr = new Scanner(System.in);
		System.out.println("Enter the string 1:");
		String stringToCompare1= inr.nextLine();
		System.out.println("Enter the string 1:");
		String stringToCompare2= inr.nextLine();
		inr.close();
		if(stringToCompare1.length()!=stringToCompare2.length())
		{
			System.out.println("Strings are not same.");
		}
		else 
		{
			for( int i=0;i<stringToCompare1.length();i++)
			{
				if(stringToCompare1.charAt(i)==stringToCompare2.charAt(i))
				{
					if(i==(stringToCompare1.length()-1))
					System.out.println("Strings are same.");	
				}
				else
				{
					System.out.println("Strings are not same.");
					break;
				}
			}
		}
	}
	
	void findLargestWord(String stringToFindLargestWord)
	{
		char[] stringStoredInLocalArray=stringToFindLargestWord.toCharArray();
		int maxLength=0,varLength=0,maxIndexValue=0,varIndexValue=0;
		for(int i=0;i<stringStoredInLocalArray.length;i++){
			if(stringStoredInLocalArray[i]==' ' || i==stringStoredInLocalArray.length-1)
			{
				if(i==stringStoredInLocalArray.length-1)
					varLength += 1;
				if(varLength>=maxLength)
				{
					maxLength=varLength;
					maxIndexValue=varIndexValue;
				}
				varLength=0;
				varIndexValue=i+1;
			}
			else{
				varLength++;
			}
		}
		char[] longestWordSetting=new char[maxLength];
		int j=0;
		for(int i=maxIndexValue;i<(maxLength+maxIndexValue);i++)
		{
			longestWordSetting[j]=stringStoredInLocalArray[i];
			j++;
		}
		String longestWord=String.valueOf(longestWordSetting);
		System.out.println("Longest word is : "+longestWord);
	}
	
	void end()
	{
		System.out.println("Thanks!");
		System.exit(0);
	}
}
