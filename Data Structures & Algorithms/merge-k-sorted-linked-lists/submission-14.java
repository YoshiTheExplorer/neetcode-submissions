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
        if (lists.length == 0) return null;
        for(int i = 1; i < lists.length; i++){
            lists[i] = merge(lists[i], lists[i-1]);
        }
        return lists[lists.length-1];
    }

    public ListNode merge(ListNode listA, ListNode listB) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(listA != null && listB != null){
            if(listA.val > listB.val){
                curr.next = listB;
                listB = listB.next;
                curr = curr.next;
            } else {
                curr.next = listA;
                listA = listA.next;
                curr = curr.next;
            }
        }

        while(listA != null){
            curr.next = listA;
            listA = listA.next;
            curr = curr.next;
        }

        while(listB != null){
            curr.next = listB;
            listB = listB.next;
            curr = curr.next;
        }

        return dummy.next;
        
    }
}
