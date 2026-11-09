class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            if (curr == null) return -1;
            curr = curr.next;
        }
        return curr == null ? -1 : curr.val;
    }

    public void insertHead(int val) {
        Node node = new Node(val, head);
        head = node;
        if (tail == null) tail = node;
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(int index) {
        if (head == null) return false;

        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
            return true;
        }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            if (curr.next == null) return false;
            curr = curr.next;
        }

        if (curr.next == null) return false;
        if (curr.next == tail) tail = curr;
        curr.next = curr.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        return values;
    }
}
