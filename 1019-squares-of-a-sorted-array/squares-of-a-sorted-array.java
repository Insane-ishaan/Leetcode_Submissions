class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        for (int n : nums) {
            nums[i++] = n * n;
        }

        Arrays.sort(nums);
        return nums;
    }
}