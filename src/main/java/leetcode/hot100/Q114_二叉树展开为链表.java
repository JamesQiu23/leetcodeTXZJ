package leetcode.hot100;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/7 18:31
 */
public class Q114_二叉树展开为链表 {

    /**
     * 方法一：递归
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        pre(root, list);

        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    public void pre(TreeNode root, List<TreeNode> list){
        if (root != null){
            list.add(root);
            pre(root.left, list);
            pre(root.right, list);
        }
    }


    /**
     * 方法二：迭代
     */
    class Solution {
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    list.add(node);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }
    }

}
