package ques2;

import java.util.Scanner;

public class PriorityQueueMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of queue:");
        int size = sc.nextInt();
        int choice;
        PriorityQueue queue = new PriorityQueue(size);
        do {
            System.out.println("Select Your Choice:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Show Queue");
            System.out.println("4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data:");
                    int data = sc.nextInt();
                    System.out.println("Enter Priority");
                    int priority = sc.nextInt();
                    queue.enqueue(new Node(data, priority));
                    break;
                case 2:
                    queue.dequeue();

                    break;
                case 3:
                    queue.showQueue();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!!!");
                    break;
            }
        } while (choice != 4);
        sc.close();
    }

}