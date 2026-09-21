class Solution {
    private List<List<Integer>> ans;

    private void helper(int[] cd, int len, int target, List<Integer> currSum, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(currSum));
            return;
        }

        if (idx >= len || target < 0) {
            return;
        }

        currSum.add(cd[idx]);
        helper(cd, len, target - cd[idx], currSum, idx);
        currSum.remove(currSum.size() - 1);
        helper(cd, len, target, currSum, idx + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        helper(candidates, candidates.length, target, new ArrayList<>(), 0);
        return ans;
    }
}