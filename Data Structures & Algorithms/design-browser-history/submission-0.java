public class Node {
    String data;
    Node prev;
    Node next;

    public Node(String data, Node prev, Node next)
    {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}



class BrowserHistory {

    Node currentNode;
    public BrowserHistory(String homepage) {
        currentNode = new Node(homepage, null, null);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++){
            if(currentNode.prev == null){
                return currentNode.data;
            } else {
                currentNode = currentNode.prev;
            }
        }
        return currentNode.data;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++){
            if(currentNode.next == null){
                return currentNode.data;
            } else {
                currentNode = currentNode.next;
            }
        }
        return currentNode.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */