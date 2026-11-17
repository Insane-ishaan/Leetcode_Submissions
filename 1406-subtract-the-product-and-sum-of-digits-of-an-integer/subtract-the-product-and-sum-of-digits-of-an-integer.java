class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while (n > 0) {
            int v = n % 10;
            prod *= v;
            sum += v;
            n = n / 10;
        }

        return prod - sum;
    }
}