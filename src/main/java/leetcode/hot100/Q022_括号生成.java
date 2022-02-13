package leetcode.hot100;

import java.util.*;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/13 17:41
 */
public class Q022_括号生成 {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        list.forEach(o-> System.err.println(o));
    }


    //todo 动态规划的解法，没看明白



    /**
     * 方法一：深度优先遍历（做减法） 即left和right表示剩几个(和)没使用
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) { //初始 left和right都为n，当左右括号都用完了时，则将结果加入结果中；
            res.add(curStr);
            return;
        }
        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }



    /**
     * 方法二：深度优先遍历（做加法） 即left和right表示使用了多少个(和）
     * 这种更高理解点
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }


/*
* 广度优先算法
* */
    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }


    /**
     * 自己凭着记忆抄了一遍
     * @param n
     * @return
     */
    public List<String> generateParenthesisMy(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0){
            return list;
        }

        mydfs("", 0, 0, n, list);
        return list;
    }

    private void mydfs(String res, Integer left, Integer right, Integer n, List<String> list){
        if (left == n && right == n){
            list.add(res);
            return;
        }
        if(left < right){
            return;
        }

        if (left < n){
            mydfs(res+"(", left+1, right, n, list);
        }
        if (right < n){
            mydfs(res+")", left, right+1, n, list);
        }
    }

}
