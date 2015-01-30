public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        // check for left
        int min = prices[0];
        left[0] = 0;
        right[prices.length - 1] = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(prices[i],min);
            left[i] = Math.max(prices[i] - min,left[i - 1]);
        }
        // check for right
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(prices[i],max);
            right[i] = Math.max(max - prices[i],right[i + 1]);
        }
        // sum
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            res = Math.max(res,left[i] + right[i]);
        }
        return res;
    }
}