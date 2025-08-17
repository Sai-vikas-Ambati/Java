class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        if (!canConstruct(board, word)) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] word, int index) {
        if (index == word.length) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word[index])
            return false;

        char temp = board[i][j];
        board[i][j] = '#';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1)) {
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }

    private boolean canConstruct(char[][] board, String word) {
        int[] boardFreq = new int[128];
        int[] wordFreq = new int[128];

        for (char[] row : board) {
            for (char c : row) {
                boardFreq[c]++;
            }
        }

        for (char c : word.toCharArray()) {
            wordFreq[c]++;
            if (wordFreq[c] > boardFreq[c]) return false;
        }

        return true;
    }
}
