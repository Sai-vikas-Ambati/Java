class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE; // this is the output value
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        //base case 
        if(n == 1){
            return nums[0];
        }
        return divide_conquer(nums, n, result, left, right, mid);
    }

    private int divide_conquer(int[] nums, int n, int result, int left, int right, int mid) {
        // this is for checking the maximum subarray
        if (left < right) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + nums[i]; // fixed: originally it was sum += sum + nums[i], which is wrong
                result = Math.max(sum, result);
                if (sum < 0) {
                    sum = 0;
                }
            }
        }
        return result;
    }
}

// here the kadane equation takes the sum = 0,max = 0, and check the resultant every round, to check if the current sum is greater than the older one