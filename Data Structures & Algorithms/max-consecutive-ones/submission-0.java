class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int consecutive = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                consecutive++;
                if(consecutive > result){
                    result = consecutive;
                }
            } else {
                consecutive = 0;
            }
            
        }
        return result;
    }
}