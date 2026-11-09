/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } [a | b] [b | c] [c | d]
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save rest of list
            curr.next = prev; // reverse current pointer
            prev = curr; // move prev forward
            curr = next; // move curr forward
        }

        return prev;
    }
}
