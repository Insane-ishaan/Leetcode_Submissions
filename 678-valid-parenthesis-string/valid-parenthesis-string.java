class Solution {
    Boolean memo[][];

    private boolean helper(String str, int len, int i, int openCount) {
        if (i >= len) {
            return memo[i][openCount] = (openCount == 0);
        }

        if (memo[i][openCount] != null) {
            return memo[i][openCount];
        }

        boolean isValid = false;
        if (str.charAt(i) == '(') {
            isValid |= helper(str, len, i + 1, openCount + 1);
        } else if (str.charAt(i) == '*') {
            //Explore All Three Posibilities
            isValid |= helper(str, len, i + 1, openCount + 1);
            isValid |= helper(str, len, i + 1, openCount);
            if (openCount > 0) {
                isValid |= helper(str, len, i + 1, openCount - 1);
            }
        } else if (openCount > 0) {
            isValid |= helper(str, len, i + 1, openCount - 1);
        }

        return memo[i][openCount] = isValid;
    }

    public boolean checkValidString(String s) {
        memo = new Boolean[s.length() + 1][s.length() + 1];
        return helper(s, s.length(), 0, 0);
    }
}