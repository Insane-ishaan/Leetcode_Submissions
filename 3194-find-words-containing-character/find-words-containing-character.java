class Solution {
    private boolean helper(String word, char x) {
        for (char w : word.toCharArray()) {
            if (w == x) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (helper(words[i], x)) {
                list.add(i);
            }
        }

        return list;
    }
}