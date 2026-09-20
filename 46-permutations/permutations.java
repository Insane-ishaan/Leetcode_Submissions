class Solution {
    private List<List<Integer>> ans;

    private void helper(int[] nums, int len, List<Integer> list) {
        if (list.size() == len) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                helper(nums, len, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, nums.length, new ArrayList<>());
        return ans;
    }
}