class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val = val;
        next = prev = null;
    }
}

class Deque {
    Node start;
    Node end;
    public Deque() {
        start = null;
        end = null;
    }

    public boolean isEmpty() {
        if(start == null && end == null){
            return true;
        } 
        return false;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(end == null) {end = start = newNode; return;}
        end.next = newNode;
        newNode.next = null;
        newNode.prev = end;
        end = newNode;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        if(start == null) {start = end = newNode; return;}
        start.prev = newNode;
        newNode.next = start;
        newNode.prev = null;
        start = newNode;
    }

    public int pop() {
        if(start == null && end == null) return -1;
        int value = end.val;
        if (start == end) {
            start = end = null;
        } else {
            this.end = end.prev;
            this.end.next = null;
        }
        
        return value;
    }

    public int popleft() {
    if (start == null) return -1;

    int value = start.val;

    if (start == end) {
        start = end = null;
    } else {
        start = start.next;
        start.prev = null;
    }
    return value;
}

}
