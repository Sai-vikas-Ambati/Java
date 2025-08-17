class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;
        while (power > 0) {
            if ((power % 2) == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }

        return result;
    }
}

//here we are using the fast exponential methodology which is an effecient method to solve this multiplication problem