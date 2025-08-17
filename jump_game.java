class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;//length of the nums 
        int first = nums[0];//this is the initial location 
        int farthest = 0;
        for(int i=0;i<n;i++){
            if(i>farthest){
                return false;
            }
            farthest = Math.max(farthest,i+nums[i]);
        }
        return true;
    }
}