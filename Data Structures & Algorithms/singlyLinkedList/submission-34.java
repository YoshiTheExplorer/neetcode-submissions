class Node {
    int val;
    Node next;

    Node() {}

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = new Node(-1); // dummy node
        this.tail = this.head;
    }

    public int get(int index) {
        Node temp = this.head.next;
        int count = 0;

        while (temp != null) {
            if (count == index) {
                return temp.val;
            }

            temp = temp.next;
            count++;
        }

        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val, this.head.next);
        this.head.next = newNode;

        if (this.tail == this.head) {
            this.tail = newNode;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public boolean remove(int index) {
        Node temp = this.head;
        int count = 0;

        while (count < index && temp.next != null) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            return false;
        }

        if (temp.next == this.tail) {
            this.tail = temp;
        }

        temp.next = temp.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        Node temp = this.head.next;
        ArrayList<Integer> sol = new ArrayList<>();

        while (temp != null) {
            sol.add(temp.val);
            temp = temp.next;
        }

        return sol;
    }
}