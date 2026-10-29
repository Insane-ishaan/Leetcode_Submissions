class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left2right = new int[len];
        int[] right2left = new int[len];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] += left2right[i - 1];
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] += right2left[i + 1];
            }
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.max(left2right[i], right2left[i]);
        }

        return result;
    }
}