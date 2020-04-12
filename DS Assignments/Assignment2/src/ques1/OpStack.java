package ques1;

public class OpStack 
{
	int indexOp = -1;
	int maxOp = 100;
	char opStackArr[] = new char[101];
	
	public void push(char element) {
		if(indexOp >= maxOp) {
			System.out.println("Operator stack is full");
			return;
		}
		indexOp++;
		opStackArr[indexOp] = element;
	}
	
	public char pop() {
		if(indexOp == (-1) ) {
			System.out.println("Operator stack has no elements");
			return '#';
		}
		char element = opStackArr[indexOp];
		indexOp--;
		return element;
	}
	
	public char peek(){
		return opStackArr[indexOp];
	}
}
