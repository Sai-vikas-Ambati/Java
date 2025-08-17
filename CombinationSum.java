import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // optional: helps keep things clean
        int c_l = candidates.length;

        for (int i = 0; i < c_l; i++) {
            if (candidates[i] > target) {
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates[i]);

            if (candidates[i] == target) {
                // If the number equals target, it's a valid combination
                result.add(temp);
            } else {
                // Start recursive search to build combinations from here
                backtrack(candidates, target - candidates[i], i, temp, result);
            }
        }
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue; // Skip if it can't fit
            }

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result); // Not i + 1 because we can reuse
            current.remove(current.size() - 1); // Backtrack to try next option
        }
    }
}
