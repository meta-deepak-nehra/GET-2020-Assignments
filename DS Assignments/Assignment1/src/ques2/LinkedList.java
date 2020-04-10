package ques2;

public class LinkedList 
{
	Node head;
	static class Node 
	{
		int data;
		Node next;
		Node(int data) 
		{
			this.data=data;
			next=null;
		}
	}
	public static LinkedList insertData(LinkedList list, int data) 
	{
		Node newNode=new Node(data);
		if (list.head==null) 
		{
			list.head=newNode;
		} 
		else 
		{
			Node node=list.head;
			while (node.next!=null) 
			{
				node=node.next;
			}
			node.next=newNode;
		}
		return list;
	}
}
