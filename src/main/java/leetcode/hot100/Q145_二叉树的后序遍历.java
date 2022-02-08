package leetcode.hot100;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/8 16:48
 */
public class Q145_二叉树的后序遍历 {

    /**
     * 方法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);

        return list;
    }

    private void postorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }



    /**
     * 方法二：迭代
     * [这个有点难，我大概知道在讲什么，但是没有细想，没法达到能自己写的地步]
     * 时间复杂度：
     * 空间复杂度：
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

}










