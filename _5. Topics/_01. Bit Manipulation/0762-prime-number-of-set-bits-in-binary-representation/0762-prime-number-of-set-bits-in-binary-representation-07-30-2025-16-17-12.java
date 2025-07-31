class Solution {
        public int countPrimeSetBits(int left, int right) {
            int count = 0;

            for (int num = left; num <= right; num++) {
                int bits = Integer.bitCount(num);
                if (bits < 2) {
                    continue;
                }
                if (bits == 2 || bits == 3) {
                    count++;
                    continue;
                }
                int sqrt = (int) Math.sqrt(bits);
                boolean isPrime = true;

                for (int i = 2; i <= sqrt; i++) {
                    if (bits % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    count++;
                }
            }

            return count;
        }
    }