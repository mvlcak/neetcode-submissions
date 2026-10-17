class LinkedList {
    private Node first;
    private Node last;
    int size;

    public LinkedList() {
    }

    public int get(int index) {
        if (index >= size || index < 0){
            return -1;
        }
    
        Node current = first;
        for(int i=0; i <= index; i++){

            if(i == index){
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newHead = new Node(val, first);
        first = newHead;
        if(last == null){
            last = newHead;
        }
        size++;
    }

    public void insertTail(int val) {
        Node newTail = new Node(val, null);
        if(first == null){
            first = newTail;
        }
        if(last != null){
            last.next = newTail;
        }
        last = newTail;
        size++;
    }

    public boolean remove(int index) {
        if (index >= size || index < 0){
            return false;
        }
        if(first == null || last == null){
            return false;
        }
        Node previous = first;
        Node current = first.next;
        
        
        if (index == 0){
            first = first.next;
            size--;
            return true;
        }
       
        for(int i=1 ; i< size; i++){
            if(i == index){
                if(current == last){
                    last = previous;
                    size--;
                    return true;
                }
                previous.next = current.next;
                size--;
                return true;
            }
            
            
            previous = current;
            current = current.next;
        }
        
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = first;
        while (current != null){
            result.add(current.value);
            current = current.next;
        }

        return result;
    }
}

class Node{
    int value;
    Node next;

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
}
