class Solution {
        public String countAndSay(int n) {
            StringBuilder sb = new StringBuilder("1");
            for (int i = 2; i <= n; i++) {
                StringBuilder curr = new StringBuilder();
                int j = 0;
                while (j < sb.length()) {
                    int k = j;
                    while (k + 1 < sb.length() && sb.charAt(k) == sb.charAt(k + 1)) {
                        k++;
                    }

                    if (k > j) {
                        int count = k - j + 1;
                        curr.append(count).append(sb.charAt(j));
                        j = k + 1;
                    } else {
                        curr.append("1").append(sb.charAt(j));
                        j++;
                    }
                }

                sb = curr;
            }
            
            return sb.toString();
        }
    }