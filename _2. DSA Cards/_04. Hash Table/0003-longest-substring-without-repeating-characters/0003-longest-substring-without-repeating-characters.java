class Solution {
    public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2) {
                return s.length();
            }

            Set<Character> seen = new HashSet<>();
            int left = 0;
            int right = 1;
            seen.add(s.charAt(0));
            int max = 0;
            
            while (right < s.length()) {
                char c = s.charAt(right);
                if (seen.contains(c)) {
                    seen.remove(s.charAt(left++));
                } else {
                    seen.add(c);
                    right++;
                }
                
                max = Math.max(max, seen.size());
            }
            
            return max;
        }
}