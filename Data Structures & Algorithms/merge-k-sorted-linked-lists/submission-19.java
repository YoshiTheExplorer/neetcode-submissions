class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length);
    }

    private ListNode divide(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return null;
        if (hi - lo == 1) return lists[lo];

        int mid = lo + (hi - lo) / 2;
        ListNode left = divide(lists, lo, mid);
        ListNode right = divide(lists, mid, hi);
        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;
        return dummy.next;
    }
}