class Solution {
    List<List<Integer>> ans;

    private void helper(int size, int target, int start, int end, List<Integer> list) {
        if (target == 0 && list.size() == size) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || start >= end) {
            return;
        }

        list.add(start);
        helper(size, target - start, start + 1, end, list);
        list.remove(list.size() - 1);
        helper(size, target, start + 1, end, list);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        helper(k, n, 1, 10, new ArrayList<>());
        return ans;
    }
}