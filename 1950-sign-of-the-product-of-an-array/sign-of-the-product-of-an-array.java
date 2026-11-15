class Solution {
    public int arraySign(int[] nums) {
        int negCnt = 0;

        for (int n : nums) {
            if (n == 0)
                return 0;

            if (n < 0) {
                negCnt++;
            }
        }

        return (negCnt % 2) == 0 ? 1 : -1;
    }
}