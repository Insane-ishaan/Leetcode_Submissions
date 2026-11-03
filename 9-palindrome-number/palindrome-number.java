class Solution {
    Boolean dp[][];

    private boolean helper(String s, int j, int i) {
        if (i >= j) {
            return dp[i][j] = true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        return dp[i][j] = helper(s, j - 1, i + 1);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = Integer.toString(x);
        dp = new Boolean[str.length() + 1][str.length() + 1];
        return helper(str, str.length() - 1, 0);
    }
}