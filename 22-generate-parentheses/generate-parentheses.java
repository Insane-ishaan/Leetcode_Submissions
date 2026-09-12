class Solution {
    List<String> ans;

    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count += 1;
            } else {
                count -= 1;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    private void helper(int len, StringBuilder str, int openCount, int closeCount) {
        if (str.length() > (2 * len)) {
            return;
        }

        if (str.length() == (2 * len)) {
            if (isValid(str.toString())) {
                ans.add(str.toString());
            }
            return;
        }

        if (openCount <= len) {
            str.append("(");
            helper(len, str, openCount + 1, closeCount);
            str.deleteCharAt(str.length() - 1);
        }
        if (closeCount <= len) {
            str.append(")");
            helper(len, str, openCount, closeCount + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper(n, new StringBuilder(""), 0, 0);
        return ans;
    }
}