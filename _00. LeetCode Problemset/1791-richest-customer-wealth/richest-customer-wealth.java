class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < accounts.length; i++) {
                int currentWealth = 0;
                for (int j = 0; j < accounts[i].length; j++) {
                    currentWealth += accounts[i][j];
                }
                
                if (currentWealth > max) {
                    max = currentWealth;
                }
            }
            
            return max;
    }
}