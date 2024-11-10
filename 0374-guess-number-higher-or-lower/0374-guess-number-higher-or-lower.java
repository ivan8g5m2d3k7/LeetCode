/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
                long left = 1;
                long right = n;

                while (left <= right) {
                    long mid = (left + right) / 2;
                    int res = guess((int) mid);
                    if (res == 0) {
                        return (int) mid;
                    } else if (res > 0) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                return -1;
            }
}