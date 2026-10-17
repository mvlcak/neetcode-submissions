class MinStack {
    int[] base;
    int length;
    int numberOfElements;

    public MinStack() {
        base = new int[12];
        length = 12;
        numberOfElements = 0;
    }
    
    public void push(int val) {
        if(length > numberOfElements){
            base[numberOfElements] = val;
            numberOfElements++;
        } else{
            enlarge(val);
        }
    }
    
    public void pop() {
        base[numberOfElements-1] = 0;
        numberOfElements--; 
    }
    
    public int top() {
        return base[numberOfElements-1];
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i< numberOfElements; i++){
            if(base[i]<min){
                min = base[i];
            }
        }
        return min;
    }

    private void enlarge(int val){
        length = length * 2;
        base = Arrays.copyOf(base, length);
        base[numberOfElements]=val;
        numberOfElements++;
    }

}
