class Solution {
    public int differenceOfSums(int n, int m) {
        int d1 = 0;
        int d2 = 0;
        for (int i = 1; i <= n; i++) {
            if ((i % m) == 0) {
                d2 += i;
            } else {
                d1 += i;
            }
        }

        return d1-d2;
    }
}