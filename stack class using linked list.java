class Node{
    int data;
    Node next;
    Node (int data){
        this.data = data;
        this.next = null;
    }
}
// stack class using linked list
class Stack{
    private Node top;
    public Stack(){
        this.top = null;
    }
    // push operation
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    //pop operation
    public int pop(){
        if (isEmpty()){
            System.out.println("Stack underflow! cannot pop from an empty stack.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }
    //peak opeation 
    public int peek(){
        if (isEmpty()){
            System.out.println("stack is empty.");
            return -1;
        }
        return top.data;
    }
    // check if stack is empty
    public boolean isEmpty(){
        return top == null;
    }
    // Display Stack elements
    public void display(){
        if (isEmpty()){
            System.out.println("stack is empty!.");
            return;
        }
        Node temp = top;
        while (temp != null){
            System.out.println(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("None");
    }
}
// Main function
public class Main{
    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("popped: "+stack.pop());
        System.out.println("Top element: "+stack.peek());
        stack.display();
    }
}