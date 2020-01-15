import java.util.ArrayList;
import java.util.Scanner;

public class JobScheduler 
{
	private ArrayList<Integer> completionTime=new ArrayList<Integer>();
	private ArrayList<Integer> waitingTime=new ArrayList<Integer>();
	private ArrayList<Integer> turnAroundTime=new ArrayList<Integer>();
	private int maxWaitingTime=0;
	private int avgWaitingTime=0;
	ArrayList<InputProcesses> inputProcess=new ArrayList<InputProcesses>();
	void takeProcess()
	{
		System.out.println("FIRST COME FIRST SERVE");
		Scanner ins = new Scanner(System.in);
		System.out.println("Enter the number of processes:");
		int numberOfProcesses= ins.nextInt();
		for(int i=0;i<numberOfProcesses;i++)
		{
			System.out.println("Enter arrival time of "+(i+1)+" process:");
			int arrivalTime=ins.nextInt();
			System.out.println("Enter burst time of "+(i+1)+" process:");
			int burstTime=ins.nextInt();
			InputProcesses Process= new InputProcesses(arrivalTime,burstTime);
			inputProcess.add(Process);
		}
		sortProcessWithArrivalTime(numberOfProcesses);
		ins.close();
	}

	void sortProcessWithArrivalTime(int numberOfProcess)
	{
		for(int i=0;i<numberOfProcess;i++)
		{
			for(int j=i+1;j<numberOfProcess;j++)
			{
				if(inputProcess.get(i).getArrivalTime() > inputProcess.get(j).getArrivalTime() )
				{
					int temp=inputProcess.get(i).getArrivalTime();
					int temp1=inputProcess.get(i).getBurstTime();
					InputProcesses Process= new InputProcesses(inputProcess.get(j).getArrivalTime(),inputProcess.get(j).getBurstTime());
					inputProcess.add(i, Process);
					InputProcesses Process1= new InputProcesses(temp,temp1);
					inputProcess.add(j,Process1);
				}
			}
		}
		calculateCompletionTime(numberOfProcess);
	}

	void calculateCompletionTime(int numberOfProcess)
	{
		int temp=inputProcess.get(0).getArrivalTime()+inputProcess.get(0).getBurstTime();
		completionTime.add(temp);
		for(int i=1;i<numberOfProcess;i++)
		{
			if(completionTime.get((i-1))>inputProcess.get(i).getArrivalTime())
			{
				temp=completionTime.get((i-1))+inputProcess.get(i).getBurstTime();
				completionTime.add(temp);
			}
			else
			{
				temp=inputProcess.get(i).getArrivalTime()+inputProcess.get(i).getBurstTime();
				completionTime.add(temp);
			}
		}
		calculateWaitingTime(numberOfProcess);
	}

	void calculateWaitingTime(int numberOfProcess)
	{
		waitingTime.add(0);
		for(int i=1;i<numberOfProcess;i++)
		{
			if(completionTime.get((i-1))>inputProcess.get(i).getArrivalTime())
			{
				int temp=completionTime.get((i-1))-inputProcess.get(i).getArrivalTime();
				waitingTime.add(temp);
			}
			else
			{
				waitingTime.add(0);
			}
		}
		calculateTurnAroundTime(numberOfProcess);
	}

	void calculateTurnAroundTime(int numberOfProcess)
	{
		for(int i=0;i<numberOfProcess;i++)
		{
			int temp=completionTime.get(i)-inputProcess.get(i).getArrivalTime();
			turnAroundTime.add(temp);
		}
		avgAndMaxWaitingTime(numberOfProcess);
	}

	void avgAndMaxWaitingTime(int numberOfProcess)
	{	
		int totalWaitingTime=waitingTime.get(0);
		maxWaitingTime=waitingTime.get(0);
		for(int i=1;i<numberOfProcess;i++)
		{
			totalWaitingTime=totalWaitingTime+waitingTime.get(i);
			if(maxWaitingTime < waitingTime.get(i))
			{
				maxWaitingTime=waitingTime.get(i);
			}
		}
		avgWaitingTime=totalWaitingTime/numberOfProcess;
		showResults(numberOfProcess);
	}

	void showResults(int numberOfProcess)
	{
		System.out.println("ArrivalTime\tBurstTime\tCompletionTime\tWaitingTime\tTurnAroundTime");
		for(int i=0;i<numberOfProcess;i++)
		{	
			System.out.printf("%-15d %-15d %-15d %-15d %-15d\n",inputProcess.get(i).getArrivalTime(),inputProcess.get(i).getBurstTime(),completionTime.get(i),waitingTime.get(i),turnAroundTime.get(i));
		}
		System.out.println("The average waiting time is "+avgWaitingTime+" and maximum waiting time is "+maxWaitingTime+" .");
		end();
	}

	void end()
	{
		System.out.println("Thanks!");
		System.exit(0);
	}
}	