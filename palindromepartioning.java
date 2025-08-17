import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        
        if (s.length() == 1) {
            List<String> singleChar = new ArrayList<>();
            singleChar.add(s);  
            result.add(singleChar);
            return result;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        
        // Fill the DP table
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        
        backtrack(s, 0, new ArrayList<>(), result, dp);
        
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, result, dp);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }
}
