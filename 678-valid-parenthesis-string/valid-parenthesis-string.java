class Solution {
    Boolean memo[][];

    private boolean helper(String str, int i, int openCnt, int len) {
        if (i >= len) {
            return memo[i][openCnt] = (openCnt == 0);
        }

        if(memo[i][openCnt] != null){
            return memo[i][openCnt];
        }

        boolean isValid = false;
        if (str.charAt(i) == '(') {
            isValid |= helper(str, i + 1, openCnt + 1, len);
        } else if (str.charAt(i) == '*') {
            isValid |= helper(str, i + 1, openCnt + 1, len);
            isValid |= helper(str, i + 1, openCnt, len);
            if (openCnt > 0) {
                isValid |= helper(str, i + 1, openCnt - 1, len);
            }
        } else if (openCnt > 0) {
            isValid |= helper(str, i + 1, openCnt - 1, len);
        }

        return memo[i][openCnt] = isValid;
    }

    public boolean checkValidString(String s) {
        memo = new Boolean[s.length() + 1][s.length() + 1];
        return helper(s, 0, 0, s.length());
    }
}