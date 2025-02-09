class Solution {
    public String toHex(int num) {
            if (num == 0) {
                return "0";
            }

            char[] hexArray = "0123456789abcdef".toCharArray();
            long a = num;
            if (a < 0) {
                a = a + (long) Math.pow(2, 32);
            }
            StringBuilder sb = new StringBuilder();

            while (a > 0) {
                sb.append(hexArray[(int) (a % 16)]);
                a /= 16;
            }

            return sb.reverse().toString();
        }
}