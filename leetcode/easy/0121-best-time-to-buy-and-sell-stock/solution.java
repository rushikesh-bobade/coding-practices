class Solution {
    public int maxProfit(int[] prices) {
        int count=0;
        int profit=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            profit=prices[i]-min;
            min=Math.min(min,prices[i]);
            count=Math.max(count,profit);
        }

        return count;
    }
}