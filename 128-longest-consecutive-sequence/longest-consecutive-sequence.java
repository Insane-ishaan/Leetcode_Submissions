class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int val : nums) {
            st.add(val);
        }

        int count;
        int ans = 1;
        for (int val : st) {
            if (!st.contains(val - 1)) {
                count = 1;
                int value = val;
                while (st.contains(value)) {
                    count++;
                    value = value + 1;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans - 1;
    }
}