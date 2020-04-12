package ques1;

import java.util.Scanner;

public class Question1{
	public static void main(String[] args)
	{

		Node head=null;

		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the Linklist:");
		int x;
		do
		{
			x=0;
			System.out.println("Please enter the data:");
			int data=sc.nextInt();
			head=createLinklist(head,data);
			System.out.println("Do you want to add more elements:\nPress1 : Yes\t\tOther : No");
			x=sc.nextInt();
		}while(x==1);

		showLinklist(head);

		System.out.println("Enter value of L:");
		int l=sc.nextInt();
		System.out.println("Enter value of R:");
		int r=sc.nextInt();
		System.out.println("Enter value of N:");
		int n=sc.nextInt();

		head=subLinklist(head,l,r,n);

		showLinklist(head);

		sc.close();
	}

	static Node subLinklist(Node head,int l,int r,int n)
	{
		int i=1;
		Node previousLeft=null;
		Node left=null;
		Node right=head;

		if(l>r){
			System.out.println("This case is not valid(Left position cannot be greater than right position).");
			return head;
		}

		if(n>=(r-l+1)){
			n=n%(r-l+1);
			if(n==0){
				return head;
			}
		}
		if(l==r){
			return head;
		}

		while((right!=null)&&(i<=l||i<=r)){
			if(i<=l){
				previousLeft=left;
				left=right;
			}
			if(i<r){
				right=right.next;
				i++;
			}else{
				break;
			}
		}

		if(l==1){
			previousLeft=right.next;
		}else{
			previousLeft.next=right.next;
		}

		right.next=null;
		left=rotation(left,n);
		right=left;
		while(right.next!=null){
			right=right.next;
		}

		if(l==1){
			head=left;
			right.next=previousLeft;
		}else{
			right.next=previousLeft.next;
			previousLeft.next=left;
		}
		return head;
	}

	//Forroatatingthestring
	static Node rotation(Node left,int n)
	{
		Node curr=null;
		for(int i=1;i<=n;i++){
			curr=left;
			while(curr.next.next!=null){
				curr=curr.next;
			}
			curr.next.next=left;//First value added to last node
			left=curr.next;//left now pointing to last node
			curr.next=null;//doing last node next to null
		}
		return left;
	}

	static Node createLinklist(Node head,int element)
	{
		Node node=new Node(element);
		Node current=null;
		if(head==null){
			head=node;
		}else{
			current=head;
			while(current.next!=null){
				current=current.next;
			}
			current.next=node;
		}
		return head;
	}

	static void showLinklist (Node head)
	{
		Node traverse=head;
		String txt="List is ";
		if(head==null){
			txt+="Empty";
		}else{
			while(traverse!=null){
				txt+=("~>"+traverse.data);
				traverse=traverse.next;
			}
		}
		System.out.println(txt);
	}

}
