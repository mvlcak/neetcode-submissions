class Solution {
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        result[arr.length-1] = -1;
        int previousMax=arr[arr.length-1];
        for(int i = arr.length-2; i>=0; i--){
            result[i]=previousMax;
            if(previousMax < arr[i]){
                previousMax = arr[i];
            }
        }
        return result;
    }
}