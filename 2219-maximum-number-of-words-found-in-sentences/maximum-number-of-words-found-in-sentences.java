class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            max = Math.max(sentences[i].split(" ").length,max);
        }

        return max;
    }
}
