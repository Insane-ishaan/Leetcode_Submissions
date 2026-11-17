class Solution {
    public int subtractProductAndSum(int n) {
        long prod = 1;
        long sum = 0;
        while (n > 0) {
            int v = n % 10;
            prod *= v;
            sum += v;
            n = n / 10;
        }

        return (int) prod - (int) sum;
    }
}