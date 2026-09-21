public class DSA19 {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node common1 = new Node(40);
        Node common2 = new Node(50);

        common1.next = common2;

        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = common1;

        Node head2 = new Node(15);
        head2.next = new Node(25);
        head2.next.next = common1;

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {

            if (p1 == null) {
                p1 = head2;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = head1;
            } else {
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            System.out.println(
                "Intersection Point: " + p1.data
            );
        } else {
            System.out.println("No Intersection");
        }
    }
}