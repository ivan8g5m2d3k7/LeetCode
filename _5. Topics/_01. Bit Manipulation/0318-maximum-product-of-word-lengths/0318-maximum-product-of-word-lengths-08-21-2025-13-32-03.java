import java.util.*;

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        int[] len  = new int[n];

        for (int i = 0; i < n; i++) {
            int m = 0;
            String w = words[i];
            for (int k = 0; k < w.length(); k++) {
                m |= 1 << (w.charAt(k) - 'a');
            }
            mask[i] = m;
            len[i]  = w.length();
        }

        int best = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    int prod = len[i] * len[j];
                    if (prod > best) best = prod;
                }
            }
        }
        return best;
    }
}
