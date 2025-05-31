class Solution {
    public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }

            int length = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < length) {
                    length = strs[i].length();
                    index = i;
                }
            }

            String shortest = strs[index];
            int maxIndex = -1;
            boolean broken = false;

            for (int i = length - 1; i >= 0; i--) {
                broken = false;
                for (int j = 0; j < strs.length; j++) {
                    if (j == index) {
                        continue;
                    }

                    if (!strs[j].startsWith(shortest.substring(0, i + 1))) {
                        broken = true;
                        break;
                    }
                }

                if (!broken) {
                    maxIndex = i;
                    break;
                }
            }

            return shortest.substring(0, maxIndex + 1);
        }
}