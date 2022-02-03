package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/4 0:48
 */
public class Q141_环形链表 {
    /**
     * 方法一：使用hash表存储
     * 时间复杂度：O(N)，其中N是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
     * 空间复杂度：O(N)，其中N是链表中的节点数。主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次。
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode temp = head;
        Set<ListNode> set = new HashSet();
        while(temp != null){
            if(set.contains(temp)){
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }


    /**
     * 方法一：快慢指针
     * 思路：慢指针每次走1步，快指针每次走2步，如果有环则最终会相遇
     * 时间复杂度：O(N)，其中 N是链表中的节点数。
     *      当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     *      当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动N轮。
     *
     * 空间复杂度：O(1)。我们只使用了两个指针的额外空间。
     */
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode temp1 = head;
        ListNode temp2 = head.next;

        while (true){
            if (temp2 == null || temp2.next == null){
                return false;
            }

            if (temp1 == temp2){
                return true;
            }

            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}



