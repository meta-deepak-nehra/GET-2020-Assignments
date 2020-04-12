package ques3;

public class MultiVarPoly 
{
	private Node head;

	class Node {
		public int data;
		public Node right;
		public Node exponential;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
			right = null;
			exponential = null;
		}

	}

	public void createLinkList(int coeff, int[] expoArr) {
		Node newNode = new Node(coeff);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = newNode;
		}
		for (int i = 1; i < expoArr.length ; i++) {
			Node newNode1 = new Node(expoArr[i]);
			newNode.exponential = newNode1;
			newNode = newNode1;
		}

	}

	public void show() {
		Node temp = head;
		if (head == null) {
			System.out.println("No elements are in the list!!!\n");
			return;
		}
		
		System.out.println("\n\nLINKED LIST  : ");
		while(temp != null) {
			System.out.print("coefficient->" + temp.data + "->" + "Exponential terms->");
			Node temp1= temp.exponential;
			while (temp1 != null) {
				System.out.print(temp1.data + "->");
				temp1 = temp1.exponential;
			}
			temp = temp.right;
			System.out.println();
		}
	}

	public int findDegree() {
		int max = 0;
		if (head == null) {
			System.out.println("No items in the list!!!");
			return max;
		}
		Node temp = head;
		while (temp != null) {
			int sum = 0;
			Node temp1 = temp;
			while (temp1.exponential != null) {
				sum = sum + temp1.exponential.data;
				temp1 =temp1.exponential;
			}
			if (sum > max) {
				max = sum;
			}
			temp = temp.right;
		}
		return max;
	}
}
