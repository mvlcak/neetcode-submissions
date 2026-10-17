class LinkedList {
    private Node first;
    private Node last;

    public LinkedList() {
    }

    public int get(int index) {
        int counter = 0;
        Node current = first;
        while(current != null){

            if(counter == index){
                return current.value;
            }

            current = current.next;
            counter++;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newHead = new Node(val, first);
        first = newHead;
        if(last == null){
            last = newHead;
        }
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
    }

    public boolean remove(int index) {
        int counter = 1;
        if(first == null || last == null){
            return false;
        }
        Node previous = first;
        Node current = first.next;
        
        
        if (index == 0){
            first = first.next;
            return true;
        }
       
        while (current != null){
        
            if(counter == index){
                if(current == last){
                    last = previous;
                    return true;
                }
                previous.next = current.next;
                return true;
            }
            
            
            previous = current;
            current = current.next;
            counter++;
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
