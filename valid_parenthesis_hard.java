class Solution {
    public int longestValidParentheses(String s) {
        int s_l = s.length(); // checking the length of the string s
        int res;
        res = checkparenthesis(s, s_l);
        return res;
    }

    private int checkparenthesis(String s, int s_l) {
        // checking the count of the parenthesis
        int count = 0;
        int in = 0;
        int out = 0;
        for (int i = 0; i < s_l; i++) {
            if (s.charAt(i) == '(') {
                in = in + 1;
            } else if (s.charAt(i) == ')') {
                out = out + 1;
            }

            if (in == out) {
                count = Math.max(count, 2 * out);
            } else if (out > in) {
                in = out = 0;
            }
        }

        // reset and check from right to left
        in = out = 0;
        for (int i = s_l - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                out = out + 1;
            } else if (s.charAt(i) == '(') {
                in = in + 1;
            }

            if (in == out) {
                count = Math.max(count, 2 * in);
            } else if (in > out) {
                in = out = 0;
            }
        }

        return count;
    }
}

