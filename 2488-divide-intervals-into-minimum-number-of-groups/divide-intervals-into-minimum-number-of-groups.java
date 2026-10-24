class Pair implements Comparable<Pair> {
    int ed;

    public Pair(int ed) {
        this.ed = ed;
    }

    @Override
    public int compareTo(Pair p2) {
        return this.ed - p2.ed;
    }
}

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int it[] : intervals) {
            int currSt = it[0];
            int currEd = it[1];

            if (!pq.isEmpty() && pq.peek().ed < currSt) {
                pq.poll();
            }

            pq.offer(new Pair(currEd));
        }

        return pq.size();
    }
}