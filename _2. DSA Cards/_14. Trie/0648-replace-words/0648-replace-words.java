class Solution {

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
        
        class Trie {
            private TrieNode root;
            
            public Trie() {
                this.root = new TrieNode('.');
            }
            
            public boolean insert(String word) {
                TrieNode[] array = this.root.array;
                boolean flag = false;
                for (int i = 0; i < word.length(); i++) {
                    if (array[word.charAt(i) - 'a'] != null) {
                        if (i == word.length() - 1) {
                            array[word.charAt(i) - 'a'].isWord = true;
                        }
                        array = array[word.charAt(i) - 'a'].array;
                        continue;
                    }
                    
                    flag = true;
                    TrieNode node = new TrieNode(word.charAt(i));
                    array[word.charAt(i) - 'a'] = node;
                    array = array[word.charAt(i) - 'a'].array;
                    
                    if (i == word.length() - 1) {
                        node.isWord = true;
                    }
                }
                
                return flag;
            }
            
            public String getShortestRoot(String word) {
                TrieNode current = this.root;
                for (int i = 0; i < word.length(); i++) {
                    if (current.array[word.charAt(i) - 'a'] != null) {
                        if (current.array[word.charAt(i) - 'a'].isWord) {
                            return word.substring(0, i + 1);
                        }
                        
                        current = current.array[word.charAt(i) - 'a'];
                    } else {
                        break;
                    }
                }
                
                return word;
            }
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            for (String root : dictionary) {
                trie.insert(root);
            }
            
            String[] words = sentence.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                words[i] = trie.getShortestRoot(words[i]);
            }
            
            return String.join(" ", words);
        }
    }