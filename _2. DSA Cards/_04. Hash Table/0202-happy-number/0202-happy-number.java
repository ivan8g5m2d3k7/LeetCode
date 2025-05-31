class Solution {
    public boolean isHappy(int n) {
            for (int i = 0; i < 10000; i++) {
                int sum = 0;
                for (char j : String.valueOf(n).toCharArray()) {
                    sum += (int) Math.pow(Integer.parseInt(String.valueOf(j)), 2);
                }

                if (sum == 1) {
                    return true;
                }
                
                n = sum;
            }
            
            return false;
        }
}