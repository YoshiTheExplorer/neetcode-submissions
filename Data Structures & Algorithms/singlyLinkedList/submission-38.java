class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    ListNode head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (head == null || index < 0 || index >= size)
            return -1;
        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val, head);
        head = newHead;
        size++;
    }

    public void insertTail(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new ListNode(val);
        }

        size++;
    }

    public boolean remove(int index) {
        if (head == null || index < 0 || index >= size)
            return false;

        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        ListNode temp = head;

        int count = index;

        while (count > 1) {
            temp = temp.next;
            count--;
        }

        temp.next = temp.next.next;
        size--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> sol = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            sol.add(temp.val);
            temp = temp.next;
        }
        return sol;
    }
}
