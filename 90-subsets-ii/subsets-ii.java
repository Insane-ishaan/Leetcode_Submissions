class Solution {
    List<List<Integer>> ans;
    Set<List<Integer>> st;

    private void helper(int nums[], int len, int start, List<Integer> list) {
        if (start >= len) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[start]);
        helper(nums, len, start + 1, list);
        list.remove(list.size() - 1);
        int next = start+1;
        while(next < len && nums[start] == nums[next]){
            next++;
        }

        helper(nums, len, next, list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        st = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, nums.length, 0, new ArrayList<>());
        return ans;
    }
}