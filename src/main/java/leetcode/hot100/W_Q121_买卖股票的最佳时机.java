package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/4 14:57
 */
public class W_Q121_买卖股票的最佳时机 {

    /**
     * 暴力破解
     * 对于每组i和j（其中j>i）我们需要找出max(prices[j]−prices[i])
     * 如何设置j要大于i？ 只需要在内层for循环中，设置j=i+1即可
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                max = temp > max ? temp : max;
            }
        }

        return max;
    }

}
