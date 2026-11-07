class Solution {
    public int[] numberGame(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if ((i % 2) == 0) {
                a.add(nums[i]);
            } else {
                b.add(nums[i]);
            }
        }

        int result[] = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if ((i % 2) == 0) {
                result[i] = b.remove(0);
            } else {
                result[i] = a.remove(0);
            }
        }

        return result;
    }
}