class Trie {
        private char letter;
        private Trie[] children;
        private boolean isWord;

        public Trie() {
            this.letter = '.';
            this.children = new Trie[26];
            this.isWord = false;
        }

        public void insert(String word) {
            char[] letters = word.toCharArray();
            int i = 0;
            Trie[] array = children;
            Trie lastNode = null;

            while (i < word.length() && array[letters[i] - 'a'] != null) {
                lastNode = array[letters[i] - 'a'];
                array = array[letters[i] - 'a'].children;
                i++;
            }
            
            while (i < word.length()) {
                Trie node = new Trie();
                node.letter = letters[i];
                array[letters[i] - 'a'] = node;
                array = node.children;
                i++;
                lastNode = node;
            }

            if (lastNode != null) {
                lastNode.isWord = true;
            }
        }

        public boolean search(String word) {
            char[] letters = word.toCharArray();
            Trie[] array = this.children;
            Trie lastNode = null;
            for (int i = 0; i < letters.length; i++) {
                if (array[letters[i] - 'a'] == null) {
                    return false;
                }
                if (i == letters.length - 1) {
                    lastNode = array[letters[i] - 'a'];
                }

                array = array[letters[i] - 'a'].children;
            }

            if (lastNode != null) {
                return lastNode.isWord;
            } else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
            char[] letters = prefix.toCharArray();
            Trie[] array = this.children;
            for (char c : letters) {
                if (array[c - 'a'] == null) {
                    return false;
                }

                array = array[c - 'a'].children;
            }

            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */