class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            String[] words = sentence.split("\\s");
            String[] replacedWords = new String[words.length];
            int i = 0;
            for (String word : words) {
                for (String root : dictionary) {
                    if (word.startsWith(root)) {
                        if (replacedWords[i] == null || replacedWords[i].length() > root.length()) {
                            replacedWords[i] = root;
                        }
                    }
                }
                
                if (replacedWords[i] == null) {
                    replacedWords[i] = word;
                }
                i++;
            }

            StringBuilder sb = new StringBuilder();
            for (String str : replacedWords) {
                sb.append(str).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);

            return sb.toString();
        }
    }