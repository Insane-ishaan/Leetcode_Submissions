class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int currWealth = Arrays.stream(accounts[i]).sum();
            maxWealth = Math.max(currWealth, maxWealth);
        }

        return maxWealth;
    }
}