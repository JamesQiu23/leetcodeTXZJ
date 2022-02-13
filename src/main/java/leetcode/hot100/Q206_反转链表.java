package leetcode.hot100;

import leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/9 1:45
 */
public class Q206_反转链表 {
    /**
     * 纯手写，空间和时间复杂度都很高
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }

        ListNode newHead = list.get(list.size()-1);
        for (int i = list.size()-1; i > 0; i--) {
            ListNode target = list.get(i);
            target.next = list.get(i-1);
        }
        list.get(0).next = null;

        return newHead;
    }


    /**
     * 方法二：直接在遍历节点时，就改变节点的引用指向
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode before = head;
        head.next = null;
        ListNode after = head.next;

        while (after != null){
            ListNode temp = after.next;
            after.next = before;
            before = after;
            after = temp;
        }
        head.next = null;

        return before;
    }
}
