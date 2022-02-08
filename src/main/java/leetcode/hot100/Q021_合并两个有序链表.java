package leetcode.hot100;

import leetcode.datastructure.ListNode;

import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/8 1:11
 */
public class Q021_合并两个有序链表 {

    /**
     * 方法一：递归
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(n+m)  递归调用mergeTwoLists函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用n+m 次，因此空间复杂度为O(n+m)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        //如何理解这段代码？
        //如果确定当前节点是最低，那么将此节点的下一个节点和另一个链的节点比较，永远找出一个最低的连在当前节点的后面
        if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    /**
     * 方法二：迭代
     * 思路：自己创建一个头结点，用来不断从原有的两链表中拿最低值的数据
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(1) 只增加了一个头结点用来展开新链
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);

        ListNode point = start;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }

        if (l1 == null){
            point.next = l2;
        } else {
            point.next = l1;
        }

        return start.next;
    }


}
