public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    // O(1)
    void addLast(int num) {
        Node node = new Node(num);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // O(n)
    int removeLast() {
        if (head == null) {
            return -1;
        }
        if (size == 1) {
            int data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        int temp = tail.data;
        curr.next = null;
        tail = curr;
        size--;
        return temp;
    }

    // O(1)
    void addFirst(int num) {
        Node node = new Node(num);
        if (head == null) {
            head = node;
            tail = node;
            size = 1;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    // O(1)
    int removeFirst() {
        if (size == 1) {
            int data = head.data;
            head = null;
            tail = null;
            size = 0;
            return data;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
        return temp.data;
    }

}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
