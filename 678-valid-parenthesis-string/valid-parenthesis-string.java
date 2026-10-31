class Solution {
    public boolean checkValidString(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            } else {
                count++;
            }
        }

        count = 0;
        for (int i = len-1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                count--;
                if (count < 0) {
                    return false;
                }
            } else {
                count++;
            }
        }

        return true;
    }
}