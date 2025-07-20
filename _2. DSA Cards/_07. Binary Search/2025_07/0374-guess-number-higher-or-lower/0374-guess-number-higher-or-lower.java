public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1;
            int right = n;

            while (left <= right) {
                int mid = left + ( (right - left) / 2);
                int comp = guess(mid);

                if (comp == 0) {
                    return mid;
                } else if (comp < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            return -1;
        }
    }