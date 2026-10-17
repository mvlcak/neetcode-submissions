class Solution {
    public int removeElement(int[] nums, int val) {
        int counter = 0;
    
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                nums[i] = -1;
                counter++;
            }
        }

        int shifter = counter;
        int shift = 0;
        for (int i = 0; i < nums.length - counter; i++){
            shift = checkMinus(nums,i,shift);
            nums[i] = nums[i+shift];
        }

        return nums.length-counter;
    }

    int checkMinus(int[] nums, int i, int shift){
        if(i < nums.length - shift && nums[i+shift] == -1){
            shift++;
        } else {
            return shift;
        }
        return checkMinus(nums, i, shift);
    }
}