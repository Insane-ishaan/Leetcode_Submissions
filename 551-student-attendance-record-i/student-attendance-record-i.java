class Solution {
    public boolean checkRecord(String s) {
        int maxConsLCout = 0;
        int lCount = 0;
        int aCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                aCount += 1;
                lCount = 0;
            } else if (s.charAt(i) == 'L') {
                lCount += 1;
            } else {
                lCount = 0;
            }
            maxConsLCout = Math.max(maxConsLCout, lCount);
        }

        if (aCount < 2 && maxConsLCout < 3) {
            return true;
        }

        return false;
    }
}