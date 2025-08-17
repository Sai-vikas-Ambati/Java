class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n];  
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  
                return digits;
            }
            digits[i] = 0;  
        }
        
        // If all digits were 9, create a new array with one extra space
        int[] newRes = new int[n + 1];
        newRes[0] = 1;
        return newRes;
    }
}
