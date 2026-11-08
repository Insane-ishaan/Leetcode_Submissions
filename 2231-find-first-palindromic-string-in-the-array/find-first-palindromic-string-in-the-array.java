class Solution {
    private boolean helper(String str, int i, int j) {
        if (i > j) {
            return true;
        }

        if (str.charAt(i) != str.charAt(j)) {
            return false;
        }

        return helper(str, i + 1, j - 1);
    }

    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (helper(words[i], 0, words[i].length() - 1)) {
                return words[i];
            }
        }

        return "";
    }
}