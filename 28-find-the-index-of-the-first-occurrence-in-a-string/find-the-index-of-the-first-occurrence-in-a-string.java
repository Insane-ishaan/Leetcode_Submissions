class Solution {
    private int helper(String s, String t) {
        int idx = 0;
        for (int i = 0; i <= (s.length() - t.length()); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }

                if (j == t.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        return helper(haystack, needle);
    }
}