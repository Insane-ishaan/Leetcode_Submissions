class Solution {
    List<List<Integer>> ans;

    private void helper(int[] nums, int len, List<Integer> list, int idx) {
        if (idx >= len) {
            ans.add(new ArrayList<>(list));
            return;
        }

        //take
        list.add(nums[idx]);
        helper(nums, len, list, idx + 1);

        //skip
        list.remove(list.size() - 1);
        helper(nums, len, list, idx + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, nums.length, new ArrayList<>(), 0);
        return ans;
    }
}