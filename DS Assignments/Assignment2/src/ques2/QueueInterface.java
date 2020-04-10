package ques2;

public interface QueueInterface 
{
	public String enqueue(int element);
	public int dequeue();
	public boolean isFull();
	public boolean isEmpty();
}
