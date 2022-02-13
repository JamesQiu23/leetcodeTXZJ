package leetcode.hot100;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/10 0:29
 */
public class W_Q005_最长回文子串 {

    /**
     * 方法一：动态规划
     * 时间复杂度：O(n^2)，其中n是字符串的长度。动态规划的状态总数为 O(n^2)，对于每个状态，我们需要转移的时间为O(1)。
     * 空间复杂度：O(n^2) 即存储动态规划状态需要的空间。
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }

        int length = s.length();
        //1.dp[i][j]表示index为i和j的子串是否为回文
        //2.状态转移方程  si==sj时，dp[i][j]=dp[i+1][j-1]; si!=sj时，dp[i][j]=false;
        //3.设置边界条件
        Boolean[][] dp = new Boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        int flag = 0;
        int maxSubLength = 1; //注意这里不能为0，如果为"ab"，那么最小也是1

        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (charArray[left] == charArray[right]){
                    if (right-left -1 <= 1){ //两字符中间有0个和1个字符时，此子串则必为回文
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left+1][right-1];
                    }
                } else {
                    dp[left][right] = false;
                }

                if (dp[left][right] == true){
                    if (maxSubLength < right-left+1){
                        maxSubLength = right-left+1;
                        flag = left;
                    }
                }
            }
        }

        return s.substring(flag, flag + maxSubLength); //注意substring是[,)的情况
    }


    public static void main(String[] args) {
        String babad = longestPalindrome1("babad");
    }


    /**
     * 方法二：中心拓展法
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int max = 1;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] len1 = expandAroundCenter(s, i, i);
            int[] len2 = expandAroundCenter(s, i, i + 1);
            if (len1[0] > len2[0]){
                max = Math.max(len1[0], max);
                flag = len1[1];
            } else {
                max = Math.max(len2[0], max);
                flag = len2[1];
            }
        }
        return s.substring(flag, flag + max);
    }

    public static int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        int[] res = new int[2];
        res[0] = right - left + 1;
        res[1] = left;
        return res;
    }


}
