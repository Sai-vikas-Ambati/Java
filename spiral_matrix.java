import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        
        int val = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (val <= n * n) {
            for (int i = left; i <= right; i++) {
                array[top][i] = val++;
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                array[i][right] = val++;
            }
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    array[bottom][i] = val++;
                }
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    array[i][left] = val++;
                }
                left++;
            }
        }

        return array;
    }
}
