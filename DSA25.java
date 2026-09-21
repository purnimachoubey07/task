public class DSA25 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating loop
        head.next.next.next.next.next = head.next;

        Node slow = head;
        Node fast = head;

        boolean loopFound = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopFound = true;
                break;
            }
        }

        if (loopFound) {

            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            Node loopNode = slow;

            Node temp = loopNode;

            while (temp.next != loopNode) {
                temp = temp.next;
            }

            temp.next = null;

            System.out.println("Loop detected and removed.");

        } else {

            System.out.println("No Loop Found.");
        }

        System.out.println("Linked List:");

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}