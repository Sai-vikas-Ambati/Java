class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int result = -1;

        result = recursive_search_left(left, mid, nums, target);
        if (result != -1) {
            return result;
        }

        result = recursive_search_right(mid + 1, right, nums, target);
        if (result != -1) {
            return result;
        }

        // If target not found, find insertion point
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    private int recursive_search_left(int start, int end, int[] nums, int target) {
        for (int i = start; i <= end && i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private int recursive_search_right(int start, int end, int[] nums, int target) {
        for (int i = start; i <= end && i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
