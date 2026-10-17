class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i<nums.length; i++){
            counts[nums[i]]++;
        }

        int pointer = 0;
        for(int i = 0; i< counts.length; i++){
            for(int j=0; j < counts[i]; j++){
                nums[pointer]=i;
                pointer++;
                
            }
        }
    }
}