package ques2;

public class QueueImpl implements QueueInterface
{
	int rear = -1;
	int front = -1;
	int max = 5;
	int[] array = new int[5];
	
	@Override
	public String enqueue(int element) {
		if( isFull() ) {
			System.out.println("Queue is Full !!!\n");
			return "Full";
		}
		if( front == -1 && rear == -1 ) {
			front++;
			rear++;
			array[rear] = element;
			return "inserted";
		} else if( rear < max-1 ) {
			if( rear==front-1 ) {
				System.out.println("The queue is Full");
				return "Full";
			} else {
				rear++;
				array[rear] = element;
				return "inserted";
			}
		} else if( (rear == max-1) && (front==0) ) {
			System.out.println("The queue is full");
			return "Full";
		} else {
			rear = 0;
			array[rear] = element;
			return "inserted";
		}
	}
	
	@Override
	public int dequeue() {
		int element;
		if( isEmpty() ) {
			System.out.println("Queue is empty");
			return -1;
		} else if( front == rear ) {
			element = array[front];
			front = -1;
			rear = -1;
			return element;
		} else if( front == max-1 ) {
			element = array[front];
			front = 0;
			return element;
		} else {
			element = array[front];
			front++;
			return element;
		}
	}
	
	@Override
	public boolean isFull() {
		if( rear==front-1 ) {
			return true;
		}
		if( ((rear == max-1)&&(front==0)) ) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		if( front == -1 && rear == -1 ) {
			return true;
		}
		return false;
	}

}
