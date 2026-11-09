class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
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
        int i = 0;
        Node curr = head;
        while(curr != null && i < index){
            i++;
            curr = curr.next;
        }
        if(curr == null) return -1;
        return curr.val;
    }

    public void insertHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        if(tail == null) tail = head;
    }

    public void insertTail(int val) {
        Node newTail = new Node(val);
        if(tail == null){
            tail = head = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
    }

    public boolean remove(int index) {
        if(head == null) return false;
        if(index == 0){
            head = head.next;
            if(head == null) tail = null;
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
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        Node curr = head;
        while(curr != null){
            i++;
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
