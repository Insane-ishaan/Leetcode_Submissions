class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, intervals);
        list.add(newInterval);
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int j = 1;
        int len = list.size();
        List<int[]> result = new ArrayList<>();

        while (j < len) {
            int cs = list.get(i)[0];
            int ce = list.get(i)[1];
            int ns = list.get(j)[0];
            int ne = list.get(j)[1];

            if (ce >= ns) {
                list.set(i, new int[] { cs, Math.max(ce, ne) });
                j++;
            } else {
                result.add(new int[] { cs, ce });
                i = j;
                j++;
            }
        }

        result.add(list.get(i));

        int ans[][] = new int[result.size()][2];

        for (i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i)[0];
            ans[i][1] = result.get(i)[1];
        }

        return ans;
    }
}