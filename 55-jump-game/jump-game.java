class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if (dp[i] == false)
                continue;
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                dp[j] = true;
            }
        }

        return dp[len - 1];
    }
}