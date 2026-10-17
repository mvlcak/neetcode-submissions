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
    ArrayDeque<ListNode> stack = new ArrayDeque<>();
    
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }
        for(int i =0; i< n; i++){
            if(lists[i]!=null){
                stack.add(lists[i]);
            }
        }

        if(stack.size() == 0){
            return null;
        }

        while(stack.size()!=1){
            int counter = 0;
            for(int i =0; i<n; i++){
                if(i % 2 == 1){
                    ListNode first = stack.size() != 0 ? stack.pop() : null;
                    ListNode second = stack.size() != 0 ? stack.pop() : null;
                    stack.offer(merge(first, second));
                    counter++;
                } 
            }
            n = n - counter;
        }
        
        return stack.pop();
            
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode acc = null;
        ListNode result = null;
        if(left == null){
            if(right == null){
                return null;
            } else {
                return right;
            }
        } else {
            if(right == null){
                return left;
            }
        }

        while(left != null && right != null){
            
            if(left.val < right.val){
                if(result == null){
                    result = new ListNode(left.val);
                    acc = result;
                } else {
                    acc.next = new ListNode(left.val);
                    acc = acc.next;
                }
                left = left.next;
            } else {
                if(result == null){
                    result = new ListNode(right.val);
                    acc = result;
                } else {
                    acc.next = new ListNode(right.val);
                    acc = acc.next;
                }
                right = right.next;
            }
        }

        while(left != null){
            if(result == null){
                result = new ListNode(left.val);
                acc = result;
            } else {
                acc.next = new ListNode(left.val);
                acc = acc.next;
            }
            left = left.next;
        }

        while(right != null){
            if(result == null){
                result = new ListNode(right.val);
                acc = result;
            } else {
                acc.next = new ListNode(right.val);
                acc = acc.next;
            }
            right = right.next;
        }

        return result;
    }


}
