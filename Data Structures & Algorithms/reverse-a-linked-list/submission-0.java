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
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    ListNode reverse(ListNode in, ListNode previous){
        if(in == null){
            return null;
        }
        ListNode orig = new ListNode(in.val, in.next);
        in.next = previous;
        if(orig.next == null){
            return new ListNode(orig.val, previous);
        }
        return reverse(orig.next, in);
    }
}

