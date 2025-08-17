import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--; // convert to 0-based index
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
        }

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / fact;
            result.append(nums.get(index));
            nums.remove(index);

            k %= fact;
            if (i > 1)
                fact /= (i - 1);
        }

        return result.toString();
    }
}
