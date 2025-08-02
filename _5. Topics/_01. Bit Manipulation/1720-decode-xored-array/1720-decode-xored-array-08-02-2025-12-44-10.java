class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] array = new int[encoded.length + 1];
            array[0] = first;

            for (int i = 1; i < array.length; i++) {
                array[i] = encoded[i - 1] ^ array[i - 1];
            }
            
            return array;
        }
    }