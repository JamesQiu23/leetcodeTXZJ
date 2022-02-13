package leetcode.hot100;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/12 1:59
 */
public class W_Q019_删除链表的倒数第N个结点 {

    public static void main(String[] args) {
//        [1,2,3,4,5]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode listNode = removeNthFromEnd1(node1, 3);
    }


    /**
     * 方法一：使用集合保存
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return null;
        }

        ListNode point = head;
        List<ListNode> list = new ArrayList<>();
        while (point != null){
            list.add(point);
            point = point.next;
        }

        int length = list.size();
        if (n>1 && n < list.size()){ //如果是在首尾节点中间的节点
            list.get(length-n-1).next = list.get(length-n+1);
        } else if(n == 1){ //如果是首节点
            list.get(length-1-n).next = null;
        } else if(n == length){ //如果是尾节点
            head = head.next;
        }

        return head;
    }


    /**
     * 方法二：快慢指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        return null;
    }
}
