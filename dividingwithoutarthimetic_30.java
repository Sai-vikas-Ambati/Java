class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean negative = (dividend < 0) != (divisor < 0);

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        int result = (int) recursivedivide(longDividend, longDivisor);

        return negative ? -result : result;
    }

    private long recursivedivide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        long count = 1;
        long sum = divisor;

        while (sum + sum <= dividend) {
            sum += sum;
            count += count;
        }

        return count + recursivedivide(dividend - sum, divisor);
    }
}