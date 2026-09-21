class Solution {
    List<List<Integer>> ans;
    Set<List<Integer>> st;

    private void helper(int nums[], int len, List<Integer> list, int idx) {
        if (idx >= len) {
            if (!st.contains(list)) {
                ans.add(new ArrayList<>(list));
                st.add(list);
            }
            return;
        }

        //take
        list.add(nums[idx]);
        helper(nums, len, list, idx + 1);

        //skip
        list.remove(list.size() - 1);
        helper(nums, len, list, idx + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        st = new HashSet<>();
        Arrays.sort(nums);
        
        helper(nums, nums.length, new ArrayList<>(), 0);
        return ans;
    }
}