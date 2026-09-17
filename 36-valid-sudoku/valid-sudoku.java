class Solution {
    private boolean traverse(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        Set<Character> st = new HashSet<>();

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (st.contains(board[i][j])) {
                    return true;
                }
                st.add(board[i][j]);
            }
        }

        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            Set<Character> st = new HashSet<>();
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (st.contains(board[row][col])) {
                    return false;
                }
                st.add(board[row][col]);
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            Set<Character> st = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (st.contains(board[row][col])) {
                    return false;
                }
                st.add(board[row][col]);
            }
        }

        for (int sr = 0; sr < 9; sr += 3) {
            int er = sr + 2;
            for (int sc = 0; sc < 9; sc += 3) {
                int ec = sc + 2;
                if (traverse(board, sr, er, sc, ec)) {
                    return false;
                }
            }
        }

        return true;
    }
}