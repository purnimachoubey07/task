public class DSA31 {

    static int[] queue = new int[5];

    static int front = -1;
    static int rear = -1;

    static void enqueue(int value) {

        // Queue full
        if ((rear + 1) % queue.length == front) {
            System.out.println("Queue is Full");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % queue.length;
        }

        queue[rear] = value;
        System.out.println(value + " inserted");
    }

    static void dequeue() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println(queue[front] + " removed");

        // Only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % queue.length;
        }
    }

    static void display() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Circular Queue: ");

        int i = front;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % queue.length;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);

        display();

        dequeue();
        dequeue();

        enqueue(60);
        enqueue(70);

        display();
    }
}