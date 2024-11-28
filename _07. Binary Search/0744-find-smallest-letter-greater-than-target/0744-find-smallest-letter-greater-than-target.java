class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
            int left = 0, right = letters.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                char curr = letters[mid];
                if (curr <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            if (letters[left] > target) {
                return letters[left];
            } else {
                return letters[0];
            }
        }
}