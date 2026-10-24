class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = 1;
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();

        while (j < len) {
            int cs = intervals[i][0];
            int ce = intervals[i][1];
            int ns = intervals[j][0];
            int ne = intervals[j][1];

            if (ce >= ns) {
                intervals[i][1] = Math.max(ce, ne);
                j++;
            } else {
                result.add(new int[] { cs, ce });
                i = j;
                j++;
            }
        }

        result.add(new int[] { intervals[i][0], intervals[i][1] });

        return result.toArray(new int[result.size()][2]);
    }
}