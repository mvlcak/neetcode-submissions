class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode next(){
        return next;
    }
}
class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size || index < 0){
            return -1;
        }
        ListNode result = head;
        for(int i = 0; i < index; i++){
            result = result.next();
        }
        return result.val;
    }
   
    
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);

        if(head == null){
            head = newHead;
            size++;
        } else{
            newHead.next = head;
            head = newHead; 
            size++;
        }
    }
    
    public void addAtTail(int val) {
        ListNode current = head;
        if(head == null){
            head =  new ListNode(val);
            size++;
            return;
        } 
        for(int i = 0; i < size-1; i++){
            current = current.next();
        }
        current.next = new ListNode(val);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if (index == 0) { addAtHead(val); return; }

        ListNode current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;

        ListNode newOne = new ListNode(val);
        newOne.next = current.next;
        current.next = newOne;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        if (index == 0) { head = head.next; size--; return; }

        ListNode current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;

        current.next = current.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */