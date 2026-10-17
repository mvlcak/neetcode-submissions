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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;

        if(list1 == null){

            head = list1;
        } else {
            if (list2 == null){
                head = list2;
            } 
        }

        if(getNumber(list1) > getNumber(list2)){
            head = list2;
            list2 = list2 == null ? null : list2.next;
        } else{
            head = list1;
            list1 = list1 == null ? null : list1.next;
        }
        ListNode nextOne = head;
        //list1 = [1,2], list2 = [3]
        while(list1 != null || list2 != null){
            int one = list1 == null ? 1000 : list1.val;
            int two = list2 == null ? 1000 : list2.val;
            if (one < two){
                nextOne.next = list1;
                list1 = list1 == null ? null : list1.next;
            } else {
                nextOne.next = list2;
                list2 = list2 == null ? null : list2.next;
            }
            nextOne = nextOne.next;
        }
        return head;
    }

    int getNumber(ListNode list1){
        return list1 == null ? 1000 : list1.val;
    }
}