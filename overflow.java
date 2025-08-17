//this is the --atoi-- problem in leetcode

class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // only remove leading and trailing spaces
        if (s.isEmpty()) return 0;

        int i = 0;
        int sign = 1;
        int result = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        // Check for sign
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert characters to integer
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (result > (max - digit) / 10) {
                return (sign == 1) ? max : min;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}

//this is the output of the --atoi-- problem in leetcode
// Input: "   -42"
// Output: -42

// this majorly checks if the written input is overflowing or not