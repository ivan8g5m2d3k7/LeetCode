class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
            int currMax = temperatures[temperatures.length - 1];
            int[] res1 = new int[temperatures.length];
            for (int i = temperatures.length - 2; i >= 0; i--) {
                if (temperatures[i] >= currMax) {
                    res1[i] = 0;
                    currMax = temperatures[i];
                } else {
                    if (temperatures[i] < temperatures[i + 1]) {
                        res1[i] = 1;
                    } else if (temperatures[i] == temperatures[i + 1]) {
                        res1[i] = res1[i + 1] + 1;
                    } else {
                        int j = i + 1;
                        while (j < temperatures.length && temperatures[i] >= temperatures[j]) {
                            if (res1[j] == 0) {
                                j++;
                            } else {
                                j = j + res1[j];
                            }
                        }

                        res1[i] = j - i;
                    }
                }
            }

            return res1;
        }
}