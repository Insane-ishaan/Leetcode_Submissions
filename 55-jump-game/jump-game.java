class Solution {
    Boolean dp[];

    private boolean helper(int[] n, int len, int i) {
        if (len - 1 == i) {
            return dp[i] = true;
        }

        if (len <= i) {
            return dp[i] = false;
        }

        if (dp[
            i] != null) {
            return dp[i];
        }

        for (int idx = 1; idx <= n[i]; idx++) {
            if (helper(n, len, idx + i)) {
                return dp[idx] = true;
            }
        }

        return dp[i] = false;
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        dp = new Boolean[len + 1];
        return helper(nums, len, 0);
    }
}