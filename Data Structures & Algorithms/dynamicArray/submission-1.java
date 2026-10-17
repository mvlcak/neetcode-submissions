class DynamicArray {

    private int[] array;
    private int filled;

    public DynamicArray(int capacity) {
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        filled++;
        if(filled > array.length){
           resize();
        }
        array[filled-1]=n;
    }

    public int popback() {
        int result = array[filled-1];
        filled--;
        return result;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i< array.length; i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }

    public int getSize() {
        return filled;
    }

    public int getCapacity() {
        return array.length;
    }
}
