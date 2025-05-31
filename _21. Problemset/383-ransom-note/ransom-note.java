class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> needed = new HashMap<>();
            Map<Character, Integer> available = new HashMap<>();
            
            for (char letter : ransomNote.toCharArray()) {
                if (needed.containsKey(letter)) {
                    needed.put(letter, needed.get(letter) + 1);
                } else {
                    needed.put(letter, 1);
                }
            }
            
            for (char letter : magazine.toCharArray()) {
                if (available.containsKey(letter)) {
                    available.put(letter, available.get(letter) + 1);
                } else {
                    available.put(letter, 1);
                }
            }
            
            for (char letter : needed.keySet()) {
                if (!available.containsKey(letter) || needed.get(letter) > available.get(letter)) {
                    return false;
                }
            }
            
            return true;
    }
}