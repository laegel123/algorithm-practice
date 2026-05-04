public class leetcode121 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (i == 0 || buy > price) {
                buy = price;
                continue;
            }

            result = Math.max(result, price - buy);
        }

        return result;
    }
}
