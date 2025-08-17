import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            // If num already processed as part of a sequence, skip it
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);   // length of sequence ending just before num
                int right = map.getOrDefault(num + 1, 0);  // length of sequence starting just after num

                // Current sequence length including num
                int length = left + 1 + right;

                // Update max length found so far
                maxLen = Math.max(maxLen, length);

                // Update boundaries with new length
                map.put(num, length);
                map.put(num - left, length);
                map.put(num + right, length);
            }
            // If num already in map, it means it was processed as part of another sequence, so skip
        }

        return maxLen;
    }
}
w