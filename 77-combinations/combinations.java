class Solution {
    List<List<Integer>> ans;

    private void helper(int start, List<Integer> list, int k, int n) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (start > n) {
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(i + 1, list, k - 1, n);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        helper(1, new ArrayList<>(), k, n);
        return ans;
    }
}