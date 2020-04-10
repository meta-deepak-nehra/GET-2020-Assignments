package ques1;

public class DigitStack 
{
	int indexDig = -1;
	int maxDig = 100;
	int digStackArr[] = new int[101];
	
	public void push(int element) {
		
		if(indexDig >= maxDig) {
			System.out.println("Maximum limit of operand reached.");
			return;
		}
		indexDig++;
		digStackArr[indexDig] = element; 
	}
	
	public int pop() {
		if(indexDig == (-1) ) {
			System.out.println("No element in Operand Array");
			return -1;
		}
		int element = digStackArr[indexDig];
		indexDig--;
		return element;
	}
	
	public int peek() {
		return digStackArr[indexDig];
	}
}
