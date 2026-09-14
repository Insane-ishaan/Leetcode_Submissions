class Solution {
    private List<List<String>> ans;

    private boolean isValid(int row, int col, List<String> board, int size) {
        //COL UP
        for (int i = row - 1; i >= 0; i--) {
            if (i >= 0 && board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        //DIAGONAL RIGHT UP
        for (int i = row - 1, j = col + 1; i >= 0 && col < size; i--, j++) {
            if ((i >= 0 && j < size) && board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        //DIAGONAL LEFT UP
        for (int i = row - 1, j = col - 1; i >= 0 && col >= 0; i--, j--) {
            if ((i >= 0 && j >= 0) && board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void solve(List<String> board, int row, int size) {
        if (row >= size) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < size; col++) {
            if (isValid(row, col, board, size)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());

                solve(board, row + 1, size);

                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder("");
            for (int j = 0; j < n; j++) {
                row.append(".");
            }

            board.add(row.toString());
        }

        solve(board, 0, n);
        return ans;
    }
}
