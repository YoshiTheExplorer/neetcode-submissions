/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int l, int r){
        if(l == r) return lists[l];

        ListNode left = divide(lists, l, (l+r)/2);
        ListNode right = divide(lists, (l+r)/2 + 1, r);

        return conquer(left, right);
    }

    public ListNode conquer(ListNode left, ListNode right){
        ListNode sol = new ListNode(-1);
        ListNode curr = sol;
        while(left != null && right != null){
            if(left.val > right.val){
                curr.next = right;
                curr = curr.next;
                right = right.next;
            } else {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            }
        }

        while(left != null){
            curr.next = left;
            curr = curr.next;
            left = left.next;
        }

        while(right != null){
            curr.next = right;
            curr = curr.next;
            right = right.next;
        }

        return sol.next;
    }
}
