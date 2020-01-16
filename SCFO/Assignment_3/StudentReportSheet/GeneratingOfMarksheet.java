import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class GeneratingOfMarksheet 
{
	ArrayList<StudentData> dataOfStudents= new ArrayList<StudentData>();
	
	
	void userInteractionScreen()
	{
		Scanner inr = new Scanner(System.in);
		System.out.println("Please choose from following options");
		System.out.println("1.To calculate Maximum, Minimum and Average grades of the students");
		System.out.println("2.To calculate percentage of passed students");
		System.out.println("3.Exit");
		int b = inr.nextInt();
		if(b>3||b<1)
		{
			System.out.println("Your Choice is Invalid");
			userInteractionScreen();
		}
		switch(b)
		{
		case 1:
			setDataOfStudents();
			calculateMaxMinAverageOfMarks();
			break;
		case 2:
			setDataOfStudents();
			calculatePercentageOfPassedStudents();
			break;
		case 3:
			end();
			break;
		}
		inr.close();
	}
	void setDataOfStudents()
	{
		Scanner ins = new Scanner(System.in);
		System.out.println("Enter the number of students in the class :");
		int numberOfStudents= ins.nextInt();
		
		for(int i=0;i<numberOfStudents;i++)
		{
			ins.nextLine();
			System.out.println("Enter the name of student :");
			String name=ins.nextLine();
			System.out.println("Enter the grades of student :");
			float grades=ins.nextFloat();
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			float gradesToSubmit = Float.valueOf(decimalFormat.format(grades)); 
			StudentData studentDetail= new StudentData((i+1),name,gradesToSubmit);
			dataOfStudents.add(studentDetail);
		}

		ins.close();
	}
	void calculateMaxMinAverageOfMarks()
	{
		float maxGrades=0,minGrades=100,avgGrades;
		float totalGrades=0;
		for( int i=0;i<dataOfStudents.size();i++)
		{
			totalGrades=totalGrades+dataOfStudents.get(i).studentGrades; 
			if(maxGrades<dataOfStudents.get(i).studentGrades)
				maxGrades=dataOfStudents.get(i).studentGrades;
			if(minGrades>dataOfStudents.get(i).studentGrades)
				minGrades=dataOfStudents.get(i).studentGrades;
		}
		float totalNumberOfStudents=dataOfStudents.size();
		avgGrades=totalGrades/totalNumberOfStudents;
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		float avgGradesToShow = Float.valueOf(decimalFormat.format(avgGrades));
		System.out.println("Maximum Grade : "+maxGrades);
		System.out.println("Minimum Grade : "+minGrades);
		System.out.println("Average Grade : "+avgGradesToShow);
		end();
	}
	
	void calculatePercentageOfPassedStudents()
	{
		float passedStudents=(float) 0.0;
		float gradeForPassing=40;
		for( int i=0;i<dataOfStudents.size();i++)
		{
			if(dataOfStudents.get(i).studentGrades>=gradeForPassing)
				passedStudents=passedStudents+1;
		}
		float percentageOfPassedStudents=(passedStudents/dataOfStudents.size())*100;
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		float percentageOfPassedStudentsToShow = Float.valueOf(decimalFormat.format(percentageOfPassedStudents));
		System.out.println("Percentage of passed students is : "+percentageOfPassedStudentsToShow);
		end();
	}
	
	void end()
	{
		System.out.println("Thanks!");
		System.exit(0);
	}
}
