class Solution {
    private boolean isValid(char[][] board, char d, int r, int c) {
        for (int i=0; i<9; i++) {
            if (board[r][i] == d) {
                return false;
            }
            if (board[i][c] == d) {
                return false;
            }
        }

        int boxStartRowIdx = (r / 3) * 3;
        int boxStartColIdx = (c / 3) * 3;
        for (int row = boxStartRowIdx; row <= boxStartRowIdx + 2; row++) {
            for (int col = boxStartColIdx; col <= boxStartColIdx + 2; col++) {
                if (board[row][col] == d) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row >= 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow += 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, ch, row, col)) {
                board[row][col] = ch;
                if (solve(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}