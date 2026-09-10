class Solution {
    List<List<Integer>> ans;

    private void helper(int[] candidates, int target, int len, List<Integer> list, int start) {
         if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if (target < 0 || start >= len) {
            return;
        }

        list.add(candidates[start]);
        helper(candidates, target - candidates[start], len, list, start + 1);
        list.remove(list.size() - 1);

        int next = start + 1;
        while (next < len && candidates[start] == candidates[next]) {
            next++;
        }

        helper(candidates, target, len, list, next);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);

        helper(candidates, target, candidates.length, new ArrayList<>(), 0);
        return ans;
    }
}