class Solution {
    private List<Integer> helper(String ex) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < ex.length(); i++) {
            char ch = ex.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftHalf = helper(ex.substring(0, i));
                List<Integer> rightHalf = helper(ex.substring(i + 1));

                for (int l : leftHalf) {
                    for (int r : rightHalf) {
                        if (ch == '*') {
                            result.add(l * r);
                        } else if (ch == '+') {
                            result.add(l + r);
                        } else {
                            result.add(l - r);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(ex));
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String e) {
        return helper(e);
    }
}