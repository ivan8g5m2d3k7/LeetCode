class Solution {
        public String addBinary(String a, String b) {
            if (b.length() > a.length()) {
                return addBinary(b, a);
            }

            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();

            while (i >= 0 || carry != 0) {
                int x = 0;
                if (i >= 0 && a.charAt(i) == '1') {
                    x = 1;
                }

                int y = 0;
                if (j >= 0 && b.charAt(j) == '1') {
                    y = 1;
                }

                int sum = x + y + carry;
                sb.append(sum % 2);
                carry = sum > 1 ? 1 : 0;

                i--;
                j--;
            }

            return sb.reverse().toString();
        }
    }