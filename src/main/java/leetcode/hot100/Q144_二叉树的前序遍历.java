package leetcode.hot100;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/7 18:34
 */
public class Q144_二叉树的前序遍历 {

    /**
     * 方法一：递归
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次
     * 空间复杂度：O(n)，为递归过程中栈的开销，平均情况下为O(logn)，最坏情况下树呈现链状，为O(n)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }

    private void pre(TreeNode root, List<Integer> list){
        if (root != null){
            list.add(root.val);
            pre(root.left, list);
            pre(root.right, list);
        }
    }




    /**
     * 方法二：迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

}




















