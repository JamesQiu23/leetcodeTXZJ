package leetcode.hot100;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/8 16:34
 */
public class Q094_二叉树的中序遍历 {

    /**
     * 方法一：递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middle(root, list);

        return list;
    }

    private void middle(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }

        middle(root.left, list);
        list.add(root.val);
        middle(root.right, list);
    }



    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


}

















