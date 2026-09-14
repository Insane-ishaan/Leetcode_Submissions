class Solution {
    private List<List<String>> ans;
    private Set<Integer> st;
    private Set<Integer> leftD;
    private Set<Integer> rightD;

    private void solve(List<String> board, int row, int size) {
        if (row >= size) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < size; col++) {
            if (!st.contains(col) && !leftD.contains(row - col) && !rightD.contains(row + col)) {
                StringBuilder newRow = new StringBuilder(board.get(row));

                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());

                st.add(col);
                leftD.add(row - col);
                rightD.add(row + col);

                solve(board, row + 1, size);

                st.remove(col);
                leftD.remove(row - col);
                rightD.remove(row + col);

                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();

        st = new HashSet<>();
        leftD = new HashSet<>();
        rightD = new HashSet<>();

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
