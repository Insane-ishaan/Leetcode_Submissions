class Solution {
    private List<List<String>> ans;

    private boolean isValid(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private void helper(String s, int len, int idx, List<String> list) {
        if (idx >= len) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < len; i++) {
            String temp = s.substring(idx, i + 1);
            if (isValid(temp)) {
                list.add(temp);
                helper(s, len, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();

        helper(s, s.length(), 0, new ArrayList<>());
        return ans;
    }
}