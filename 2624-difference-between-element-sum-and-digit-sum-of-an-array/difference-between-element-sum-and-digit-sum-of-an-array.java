class Solution {
    private int helper(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder;
            n = n / 10;
        }

        return sum;
    }

    public int differenceOfSum(int[] nums) {
        int elSum = 0;
        for (int i = 0; i < nums.length; i++) {
            elSum += nums[i];
        }

        int digitSum = 0;
        for (int i = 0; i < nums.length; i++) {
            digitSum += helper(nums[i]);
        }

        return Math.abs(digitSum - elSum);
    }
}