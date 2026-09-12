class Solution {
    Map<Integer, String> mp;
    List<String> ans;

    private void helper(String digits, int len, int idx, StringBuilder str) {
        if (idx >= len) {
            ans.add(str.toString());
            return;
        }

        int currIdx = digits.charAt(idx) - '0';
        String curr = mp.get(currIdx);

        for (int i = 0; i < curr.length(); i++) {
            str.append(curr.charAt(i));
            helper(digits, len, idx + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        mp = new HashMap<>();
        ans = new ArrayList<>();
        int len = digits.length();

        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");

        helper(digits, len, 0, new StringBuilder(""));
        return ans;
    }
}