class Pair implements Comparable<Pair> {
    int value;
    int idx;

    public Pair(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }

    @Override
    public int compareTo(Pair p2) {
        return p2.value - this.value;
    }
}

class idxBasedPair implements Comparable<idxBasedPair> {
    int val;
    int idx;

    public idxBasedPair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(idxBasedPair p2) {
        return this.idx - p2.idx;
    }
}

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> valPq = new PriorityQueue<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            valPq.offer(new Pair(nums[i], i));
        }

        PriorityQueue<idxBasedPair> idxPq = new PriorityQueue<>();

        while (k > 0) {
            Pair nextGreater = valPq.poll();
            idxPq.offer(new idxBasedPair(nextGreater.value, nextGreater.idx));
            k--;
        }

        int answer[] = new int[idxPq.size()];
        int i = 0;
        while (!idxPq.isEmpty()) {
            answer[i++] = idxPq.poll().val;
        }

        return answer;
    }
}