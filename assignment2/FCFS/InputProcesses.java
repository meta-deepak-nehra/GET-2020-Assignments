public class InputProcesses 
{
	int arrivalTime;
	int burstTime;
	
	
	public InputProcesses(int arrivalTime, int burstTime) 
	{
		super();
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
	}
	
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getBurstTime() {
		return burstTime;
	}
	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	
}
