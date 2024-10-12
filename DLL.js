class DoublyLinkedList {
  head = null;
  tail = null;
  size = 0;

  addFirst(val) {
    let node = new Node(val);
    if (this.size == 0) {
      this.head = node;
      this.tail = node;
      this.size++;
      return;
    }
    node.next = this.head;
    this.head.prev = node;
    this.head = node;
    this.size++;
  }

  removeFirst() {
    if (this.size == 0) {
      return -1;
    }
    if (this.size == 1) {
      let temp = this.head;
      this.head = null;
      this.tail = null;
      this.size = 0;
      return temp.data;
    }
    let temp = this.head;
    this.head = this.head.next;
    temp.next = null;
    this.head.prev = null;
    this.size--;
    return temp.data;
  }

  addLast(val) {
    let node = new Node(val);
    if (this.size == 0) {
      this.head = node;
      this.tail = node;
      this.size = 1;
      return;
    }
    this.tail.next = node;
    node.prev = this.tail;
    this.tail = node;
    this.size++;
  }

  removeLast() {
    if (this.size == 0) {
      return -1;
    }
    if (this.size == 1) {
      let temp = this.head;
      this.head = null;
      this.tail = null;
      this.size = 0;
      return temp.data;
    }
    let temp = this.tail;
    this.tail = this.tail.prev;
    this.tail.next = null;
    temp.prev = null;
    this.size--;
    return temp.data;
  }
}

class Node {
  data;
  next = null;
  prev = null;

  constructor(data) {
    this.data = data;
  }
}

let dll = new DoublyLinkedList();
dll.addFirst(1);
dll.addFirst(2);
dll.addFirst(3);
