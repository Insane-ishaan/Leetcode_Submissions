class Solution {
    private boolean isValid(char[][] board, char d, int r, int c) {
        for (int i = 0; i < 9; i++) {
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

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, ch, i, j)) {
                            board[i][j] = ch;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}