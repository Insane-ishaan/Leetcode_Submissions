class Pair {
    int count;
    int idx;

    public Pair(int count, int idx) {
        this.count = count;
        this.idx = idx;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Pair> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mp.containsKey(ch)) {
                Pair p = mp.get(ch);
                mp.put(ch, new Pair(p.count + 1, i));
            } else {
                mp.put(ch, new Pair(1, i));
            }
        }

        int idx = Integer.MAX_VALUE;
        for (Character key : mp.keySet()) {
            Pair curr = mp.get(key);
            if (curr.count == 1) {
                if (curr.idx < idx) {
                    idx = curr.idx;
                }
            }
        }

        return idx == Integer.MAX_VALUE ? -1 : idx;
    }
}