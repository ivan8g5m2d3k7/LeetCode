class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int totalXor = 0;
        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }

        int XorWithoutFirst = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            XorWithoutFirst ^= encoded[i];
        }

        int array0 = totalXor ^ XorWithoutFirst;
        int[] array = new int[n];
        array[0] = array0;

        for (int i = 1; i < n; i++) {
            array[i] = array[i - 1] ^ encoded[i - 1];
        }

        return array;
    }
}