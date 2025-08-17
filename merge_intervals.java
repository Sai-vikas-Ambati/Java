import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort the intervals by the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];
        res.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap, move to the next interval
                current = next;
                res.add(current);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
//here we sorted initially based on the start time and the then used the end time to merge the intervals