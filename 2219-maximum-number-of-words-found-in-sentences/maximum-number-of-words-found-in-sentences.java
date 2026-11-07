class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sentences.length; i++) {
            int len = sentences[i].split(" ").length;
            if (len > max) {
                max = len;
            }
        }

        return max;
    }
}
