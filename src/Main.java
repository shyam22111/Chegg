class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void merge(LinkedList list) {
        Node a = this.head;
        Node b = list.head;
        Node tail = null;

        if (a == null) {
            this.head = b;
            return;
        }
        if (b == null) {
            return;
        }

        if (a.data <= b.data) {
            tail = a;
            a = a.next;
        } else {
            tail = b;
            b = b.next;
        }

        Node current = tail;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                current.next = a;
                current = a;
                a = a.next;
            } else {
                current.next = b;
                current = b;
                b = b.next;
            }
        }
        if (a == null) {
            current.next = b;
        } else {
            current.next = a;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Node head1 = new Node(8);
        head1.next = new Node(3);
        head1.next.next = new Node(7);
        Node head2 = new Node(1);
        head2.next = new Node(6);

        LinkedList list1 = new LinkedList(head1);
        LinkedList list2 = new LinkedList(head2);

        list1.merge(list2);
        list1.print();
    }
}
