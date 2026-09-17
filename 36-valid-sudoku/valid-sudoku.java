class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> st = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                String x = board[i][j] + "row found at" + i;
                String y = board[i][j] + "col found at" + j;
                String box = board[i][j] + "found at " + (i / 3) + "," + (j / 3);
                if (st.contains(x) || st.contains(y) || st.contains(box)) {
                    return false;
                }
                st.add(x);
                st.add(y);
                st.add(box);
            }
        }

        return true;
    }
}