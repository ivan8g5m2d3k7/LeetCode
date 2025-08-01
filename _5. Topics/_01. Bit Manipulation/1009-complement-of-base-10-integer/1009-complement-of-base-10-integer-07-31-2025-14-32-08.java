class Solution {
        public int bitwiseComplement(int n) {
            String string = Integer.toBinaryString(n);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }

            return Integer.parseInt(sb.toString(), 2);
        }
    }