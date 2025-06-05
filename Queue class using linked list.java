class Node{
    int data;
    Node next;
    Node (int data){
        this.data = data;
        this.next = null;
    }
}
// Queue class using linked list
class Queue{
    private Node front, rear;
    public Queue(){
        this.front = this.rear = null;
    }
    // Enqueue operation
    public void Enqueue(int data){
        Node newNode = new Node(data);
        if (rear == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    //Dequeue operation
    public int Dequeue(){
        if (front == null){
            System.out.println("Queue underflow! cannot Dequeue from an empty queue.");
            return -1;
        }
        int dequeuedData = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        return dequeuedData;
    }
    //peak opeation 
    public int peek(){
        if (isEmpty()){
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }
    // check if queue is empty
    public boolean isEmpty(){
        return front == null;
    }
    // Display Queue elements
    public void display(){
        if (isEmpty()){
            System.out.println("Queue is empty!.");
            return;
        }
        Node temp = front;
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
        Queue queue = new Queue();
        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);
        queue.display();
        System.out.println("dequeued: "+queue.Dequeue());
        System.out.println("front end: "+queue.peek());
        queue.display();
    }
}