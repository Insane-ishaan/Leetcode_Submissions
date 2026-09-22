class Solution {
    private boolean helper(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean firstCharMatched = false;
        if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            firstCharMatched = true;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            boolean take = (firstCharMatched && helper(s.substring(1), p));
            boolean notTake = helper(s, p.substring(2));

            return take || notTake;
        } else {
            return (firstCharMatched && helper(s.substring(1), p.substring(1)));
        }
    }

    public boolean isMatch(String s, String p) {
        return helper(s, p);
    }
}