package Easy;

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int ans = 0;

        while(right < prices.length) {
            int currentProfit = prices[right] - prices[left];
            if(ans < currentProfit) {
                ans = currentProfit;
            }
            if(prices[left]>=prices[right]) {
                left = right;
                right++;
            } else {
                right++;
            }
        }

        return ans;
    }
}
