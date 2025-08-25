class Solution {
        public int maxProduct(String[] words) {
            int max = 0;
            for (int i = 0; i < words.length; i++) {
                int first = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    first |= (1 << (words[i].charAt(j) - 97));
                }

                for (int k = i + 1; k < words.length; k++) {
                    int second = 0;
                    for (int j = 0; j < words[k].length(); j++) {
                        second |= (1 << (words[k].charAt(j) - 97));
                    }

                    boolean skip = false;
                    for (int b = 0; b < 25; b++) {
                        if ( ( (first >> b) & (second >> b) ) == 1) {
                            skip = true;
                            break;
                        }
                    }

                    if (!skip) {
                        max = Math.max(max, words[i].length() * words[k].length());
                    }
                }
            }

            return max;
        }
    }