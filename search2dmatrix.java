class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true; 
                }
            }
        }
        
        return false;  
    }
}

// 
//This is the binary approach 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int n = matrix.length;      
        int m = matrix[0].length;   
        
        int left = 0;
        int right = n * m - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / m][mid % m];
            
            if (midValue == target) {
                return true;  
            } else if (midValue < target) {
                left = mid + 1;  
            } else {
                right = mid - 1; 
            }
        }
        
        return false;  
    }
}
//
