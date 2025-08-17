class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.size();
        if(n == 0 && m == 0){
            return true;
        }

        Set<String> wordSet = new HashSet<>(wordDict);

        int minLen = Integer.MAX_VALUE;
        int maxLen = 0;
        for(String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = Math.max(0, i - maxLen); j <= i - minLen; j++) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
