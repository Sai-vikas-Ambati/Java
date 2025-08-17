class Solution {
    public String minWindow(String s, String t) {
        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) targetFreq[c]++;

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int start = 0, count = 0;
        int[] windowFreq = new int[128];

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq[c]++;
            if (targetFreq[c] > 0 && windowFreq[c] <= targetFreq[c]) {
                count++;
            }

            // If we have found a valid window
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lChar = s.charAt(left);
                if (targetFreq[lChar] > 0 && windowFreq[lChar] <= targetFreq[lChar]) {
                    count--;
                }
                windowFreq[lChar]--;
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
