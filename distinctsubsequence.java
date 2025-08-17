class Solution {
    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        
        // dp[i][j] = number of ways to form t[0..j-1] from s[0..i-1]
        int[][] dp = new int[sl + 1][tl + 1];

        // Initialize base cases
        for (int i = 0; i <= sl; i++) {
            dp[i][0] = 1; // Any s prefix can match empty t in 1 way
        }

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= tl; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sl][tl];
    }
}
