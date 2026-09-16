class Solution {
    private Boolean dp[];

    private boolean helper(String s, int len, int start, List<String> wordDict) {
        if (start == len) {
            return true;
        }

        if(dp[start] != null){
            return dp[start];
        }

        if (wordDict.contains(start)) {
            return true;
        }

        for (int end = start + 1; end <= len; end++) {
            String temp = s.substring(start, end);
            if (wordDict.contains(temp) && helper(s, len, end, wordDict)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[301];
        return helper(s, s.length(), 0, wordDict);
    }
}