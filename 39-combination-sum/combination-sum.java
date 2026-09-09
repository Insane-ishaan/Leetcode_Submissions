class Solution {
    List<List<Integer>> ans;
    Set<List<Integer>> st;

    private void helper(int[] arr, int start, int len, int target, List<Integer> list) {
        if (target < 0 || start >= len) {
            return;
        }

        if (target == 0) {
            if (!st.contains(list)) {
                ans.add(new ArrayList<>(list));
                st.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(arr[start]);
        helper(arr, start + 1, len, target - arr[start], list);
        helper(arr, start, len, target - arr[start], list);
        list.remove(list.size() - 1);
        helper(arr, start + 1, len, target, list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        st = new HashSet<>();
        helper(candidates, 0, candidates.length, target, new ArrayList<>());
        return ans;
    }
}