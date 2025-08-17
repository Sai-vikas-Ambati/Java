import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> seen = new HashSet<>();
    
    public boolean isHappy(int n) {
        return Happy(n); 
    }

    private boolean Happy(int n){
        if (n == 1) return true;
        if (seen.contains(n)) return false; 
        seen.add(n);

        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }

        return Happy(sum); 
    }
}
