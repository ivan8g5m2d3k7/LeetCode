class WordDictionary {

        class TrieNode {
            private Character letter;
            private TrieNode[] array = new TrieNode[26];
            private boolean isWord;

            public TrieNode() {

            }

            public TrieNode(char c) {
                this.letter = c;
            }
        }

        private TrieNode root = new TrieNode('-');

        public WordDictionary() {

        }

        public void addWord(String word) {
            TrieNode current = this.root;
            for (int i = 0; i < word.length(); i++) {
                if (current.array[word.charAt(i) - 'a'] == null) {
                    TrieNode node = new TrieNode(word.charAt(i));
                    current.array[word.charAt(i) - 'a'] = node;
                }

                current = current.array[word.charAt(i) - 'a'];
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            TrieNode current = this.root;
            return dfs(word, 0, current);
        }

        public boolean dfs(String word, int i, TrieNode current) {
            if (i == word.length()) {
                return current.isWord;
            }

            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < current.array.length; j++) {
                    if (current.array[j] != null) {
                       if (dfs(word, i + 1, current.array[j])) {
                           return true;
                       }
                    }
                }
            } else {
                if (current.array[c - 'a'] == null) {
                    return false;
                }
                
                if (dfs(word, i + 1, current.array[c - 'a'])) {
                    return true;
                }
            }
            
            return false;
        }
    }