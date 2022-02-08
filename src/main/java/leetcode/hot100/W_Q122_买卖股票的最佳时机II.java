package leetcode.hot100;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/4 16:36
 */
public class W_Q122_买卖股票的最佳时机II {
    /**
     * 思路：如果今天股价比昨天股价，则昨天买入，今天卖出，如果明天股价比今天股价高，则今天买入明天卖出；我们只赚2天之间的上升的差额利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <=1){
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0){
                sum += (prices[i] - prices[i-1]);
            }
        }

        return sum;
    }

}
