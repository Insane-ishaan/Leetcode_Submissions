class Solution {
    public boolean canTransform(int[] source, int[] target) {
        if (source.length != target.length) {
            return false;
        }

        long srcSum = Arrays.stream(source).asLongStream().sum();
        long targetSum = Arrays.stream(target).asLongStream().sum();

        return srcSum == targetSum;
    }
}