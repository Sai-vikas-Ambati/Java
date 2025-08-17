class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        elif n == 2:
            return 2
        elif n > 2:
            return self.climbing(n, {})
        else:
            return None

    def climbing(self, n: int, memo: dict) -> int:
        if n in memo:
            return memo[n]
        if n == 0:
            return 1
        elif n < 0:
            return 0
        memo[n] = self.climbing(n - 1, memo) + self.climbing(n - 2, memo)
        return memo[n]
