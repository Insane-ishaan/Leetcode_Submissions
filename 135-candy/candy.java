class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] counter = new int[len];
        Arrays.fill(counter, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                counter[i] += counter[i - 1];
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                counter[i] = Math.max(counter[i], counter[i + 1] + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result += counter[i];
        }

        return result;
    }
}