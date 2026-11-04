class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> ans = new ArrayList<>();
        for (int v : nums) {
            if (v == val) {
                continue;
            }
            ans.add(v);
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
            nums[i] = ans.get(i);
        }

        return ans.size();
    }
}