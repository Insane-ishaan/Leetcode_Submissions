class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int end = 0;
        int maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (end == i) {
                count++;
                end = maxReach;
            }
        }

        return count;
    }
}