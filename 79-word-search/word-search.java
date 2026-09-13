class Solution {
    private int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private boolean helper(char[][] board, String word, int m, int n, int idx) {
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length || board[m][n] == '$'
                || board[m][n] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        char temp = board[m][n];
        board[m][n] = '$';

        for (int i = 0; i < 4; i++) {
            int newR = m + dir[i][0];
            int newC = n + dir[i][1];

            if (helper(board, word, newR, newC, idx + 1)) {
                return true;
            }
        }

        board[m][n] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}