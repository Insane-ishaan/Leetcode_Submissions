class Solution {
    List<List<Integer>> ans;

    private void helper(int[] arr, int start, int len, int target, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < len; i++) {
            list.add(arr[i]);
            helper(arr, i, len  , target - arr[i], list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        helper(candidates, 0, candidates.length, target, new ArrayList<>());
        return ans;
    }
}