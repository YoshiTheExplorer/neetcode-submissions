class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val, Node prev, Node next){
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class Deque {
    Node head;
    Node tail;
    public Deque() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void append(int value) {
        Node newNode = new Node(value, null, null);
        if(tail == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value, null, null);
        if(head == null){
            head = tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public int popleft() {
        if(head == null) return -1;
        if(head.next == null){
            int val = head.val;
            head = tail = null;
            return val;
        }
        Node pop = head;

        head = head.next;
        head.prev = null;

        return pop.val;
    }

    public int pop() {
        if(tail == null) return -1;
        if(head.next == null){
            int val = head.val;
            head = tail = null;
            return val;
        }
        Node popLeft = tail;

        tail = tail.prev;
        tail.next = null;

        return popLeft.val;
    }
}
