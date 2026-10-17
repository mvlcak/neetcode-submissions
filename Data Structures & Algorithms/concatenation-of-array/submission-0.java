class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for(int i = 0; i< (nums.length * 2); i++){
            ans[i]=nums[i - (i >= nums.length ? nums.length : 0)];
        }
        return ans;
    }
}