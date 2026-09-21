public class DSA20 {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node addNumbers(Node head1, Node head2) {

        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {

            int sum = carry;

            if (head1 != null) {
                sum = sum + head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum = sum + head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;

            current.next = new Node(sum % 10);

            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node result = addNumbers(head1, head2);

        System.out.println("Result:");

        while (result != null) {

            System.out.print(result.data + " ");

            result = result.next;
        }
    }
}