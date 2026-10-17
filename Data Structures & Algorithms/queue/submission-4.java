class Deque {

    Node first;
    Node last;
    int size;

    public Deque() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
        if(last == null){
            Node newNode = new Node(value, null, null);
            last = newNode;
            first = newNode;
            size++;
            return;
        }
        Node temp = new Node(value, null, last);
        last.next = temp;
        last = temp;
        size++;
    }

    public void appendleft(int value) {
        if(first == null){
            Node newNode = new Node(value, null, null);
            last = newNode;
            first = newNode;
            size++;
            return;
        }
        Node temp = new Node(value, first, null);
        first.previous = temp;
        first = temp;
        size++;
    }

    public int pop() {
        if(size == 0){
            return -1;
        }
        int result = last.value;
        
        last = last.previous;
       
        if(last == null){
            first = null;
            size--;
            return result;
        }

        last.next = null;
        
        
        size--;
        return result;
    }

    public int popleft() {
        if(size == 0){
            return -1;
        }
        int result = first.value;
        first = first.next;
        
        if(first == null){
            last = null;
            size--;
            return result;
        }

        first.previous = null;
        
        
        size--;
        return result;

    }

}

class Node{
    int value;
    Node next;
    Node previous;
    

    public Node(int value, Node next, Node previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
