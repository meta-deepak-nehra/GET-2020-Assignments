package ques2;

public class Node {
    private int data;
    private int priority;

    public Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public int getData() {
        return data;
    }

    public int getPriority() {
        return priority;
    }
}
