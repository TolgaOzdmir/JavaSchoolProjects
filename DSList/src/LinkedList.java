public class LinkedList {
    private Node head;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public LinkedList() {
        this.head = null;
    }

    public void addTail(int data) {
        this.head = addTail(this.head, data);
    }

    private Node addTail(Node head, int data) {
        if (head != null)
            head.next = addTail(head.next, data);
        else
            head = new Node(data);
        return head;
    }

    public void addHead(int data) {
        if (head == null)
            head = new Node(data);
        else {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
        }
    }

    public void removeTail() {
        if (head != null)
            head = removeTail(head);
    }

    private Node removeTail(Node head) {
        if (head.next == null)
            head = null;
        else
            head.next = removeTail(head.next);
        return head;
    }

    public int removeHead() {
        if (head == null) return Integer.MIN_VALUE;
        int temp = head.data;
        head = head.next;
        return temp;
    }

    public void remove(int index) {
        if (head != null)
            head = remove(head, index);
    }

    private Node remove(Node head, int index) {
        if (head != null) {
            if (index == 0) {
                return head.next;
            }
            head.next = remove(head.next, --index);
            return head;
        }
        return null;
    }

    public void display() {
        display(this.head);
        System.out.println();
    }

    private void display(Node head) {
        if (head != null) {
            System.out.print(head.data + " ");
            display(head.next);
        }
    }

    public void displayReverse() {
        displayReverse(this.head);
        System.out.println();
    }

    private void displayReverse(Node head) {
        if (head != null) {
            displayReverse(head.next);
            System.out.print(head.data + " ");
        }
    }
}
