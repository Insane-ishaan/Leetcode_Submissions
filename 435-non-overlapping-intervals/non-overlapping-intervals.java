class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;

        int len = intervals.length;
        int i = 0;
        int j = 1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        while (i < len && j < len) {
            if (j < len - 1 && i == j) {
                j++;
            }
            if (i == j) {
                return count;
            }

            int cs = intervals[i][0];
            int ce = intervals[i][1];
            int ns = intervals[j][0];
            int ne = intervals[j][1];

            if (ce > ns) {
                if (ce < ne) {
                    j++;
                } else {
                    i++;
                }
                count++;
            } else {
                i = j;
                j++;
            }
        }

        return count;
    }
}