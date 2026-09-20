class Pair {
    int value;
    int idx;

    public Pair(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}

class Solution {
    List<List<Integer>> ans;

    private void helper(int[] nums, List<Integer> list, Map<Integer, Integer> mp, int len) {
        if (len == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int key : mp.keySet()) {
            if (mp.get(key) > 0) {
                list.add(key);
                mp.put(key, mp.get(key) - 1);
                helper(nums, list, mp, len);
                list.remove(list.size() - 1);
                mp.put(key, mp.get(key) + 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int key : nums) {
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        helper(nums, new ArrayList<>(), mp, nums.length);

        return ans;
    }
}