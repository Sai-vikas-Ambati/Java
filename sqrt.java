class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long estimate = x;
        while (estimate * estimate > x) {
            estimate = (estimate + x / estimate) / 2;
        }

        return (int) estimate;
    }
}
