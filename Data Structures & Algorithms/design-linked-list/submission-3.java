class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int idx;

    public MyLinkedList() {
        head = null;
        tail = null;
        idx = -1;
    }

    public int get(int index) {
        if (index > idx || index < 0) {
            return -1;
        }
        Node temp;
        if (index > idx / 2) {
            temp = tail;
            int count = idx - index;
            while (count > 0) {
                temp = temp.prev;
                count--;
            }
        } else {
            temp = head;
            int count = index;
            while (count > 0) {
                temp = temp.next;
                count--;
            }
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            idx++;
            return;
        }
        Node newHead = new Node(val, null, head);
        head.prev = newHead;
        head = newHead;
        idx++;
        return;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            head = new Node(val);
            tail = head;
            idx++;
            return;
        }
        Node newTail = new Node(val, tail, null);
        tail.next = newTail;
        tail = newTail;
        idx++;
        return;
    }

    public void addAtIndex(int index, int val) {
        if (index > idx + 1 || index < 0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == idx + 1) {
            addAtTail(val);
            return;
        }

        Node before = head;
        int count = index - 1;
        while (count > 0) {
            before = before.next;
            count--;
        }
        Node after = before.next;
        Node newNode = new Node(val, before, after);
        before.next = newNode;
        after.prev = newNode;
        idx++;
        return;
    }

    public void deleteAtIndex(int index) {
        if (head == null || index > idx || index < 0) {
            return;
        }

        if (index == 0 && idx == 0) {
            head = null;
            idx--;
            tail = null;
            return;
        }

        if (index == 0) {
            head = head.next;
            head.prev = null;
            idx--;
            return;
        } else if (index == idx) {
            tail = tail.prev;
            tail.next = null;
            idx--;
            return;
        }

        Node before = head;
        int count = index - 1;
        while (count > 0) {
            before = before.next;
            count--;
        }
        Node after = before.next.next;
        before.next = after;
        after.prev = before;
        idx--;
        return;
    }
}