class Solution {
    public String reverseWords(String s) {
            String[] words = s.trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                StringBuilder current = new StringBuilder(word);
                sb.append(current.reverse()).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            
            return sb.toString();
        }
}