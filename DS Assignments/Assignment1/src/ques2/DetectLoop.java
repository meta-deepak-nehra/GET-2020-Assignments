package ques2;

public class DetectLoop 
{
	public static void main(String[] args) 
	{	
		LinkedList list = new LinkedList();
		LinkedList.insertData(list, 10);
		LinkedList.insertData(list, 20);
		LinkedList.insertData(list, 30);
		LinkedList.insertData(list, 40);
		LinkedList.insertData(list, 50);
		LinkedList.insertData(list, 60);
		LinkedList.insertData(list, 70);		
		list.head.next.next.next.next = list.head;		
		if (hasLoop(list.head))
			System.out.println("Loop found");
		else
			System.out.println("No Loop");
	}

	static boolean hasLoop(LinkedList.Node head) 
	{
		LinkedList.Node backward = head,forward = head;
		while (forward != null && forward.next != null) 
		{
			backward = backward.next;
			forward = forward.next.next;
			if (backward == forward)
				return true;
		}
		return false;
	}

}
