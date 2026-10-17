class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int result = getMax(piles);
        int high = result;
        int low = 1;

       
        while(high>=low){
            int mid = (low + high) >>> 1;
            int hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours += (int) Math.ceil(piles[i]*1.0/mid);
            }
            
            if (hours > h){
                low = mid+1;
            }  else {
                high = mid - 1;
            }
            if(hours<=h && mid<result){  
                result = mid;
            }
        }
    
        
        return result;
    }

    private int getMax(int[] arr){
        int max = 0;
        for(int i=0; i<arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }   

}
