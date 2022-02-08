package leetcode.hot100;

import leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/8 17:26
 */
public class Q002_两数相加 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        ListNode listNode = addTwoNumbers2(l11, l21);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }


    /**
     * 方法一：直接且暴力
     * 超时了
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> list1 = new ArrayList<>();
        while (l1 != null){
            list1.add(l1.val);
            l1 = l1.next;
        }

        int sum1 = 0;
        for (int i = 0; i < list1.size(); i++) {
            Integer num = list1.get(list1.size() - 1 - i);
            Double pow = Math.pow(10, i);
            sum1 = sum1 + pow.intValue() * num;
        }


        List<Integer> list2 = new ArrayList<>();
        while (l2 != null){
            list2.add(l2.val);
            l2 = l2.next;
        }

        int sum2 = 0;
        for (int i = 0; i < list2.size(); i++) {
            Integer num = list2.get(list2.size() - 1 - i);
            Double pow = Math.pow(10, i);
            sum2 = sum2 + pow.intValue() * num;
        }

        Integer sum = sum1 + sum2;

        ListNode head = new ListNode(0);
        ListNode point = head;

        int i = 1;
        Double r = 1.0;
        while(r != 0.0){
            Double pow = Math.pow(10, i++);
            r = sum % pow;
            ListNode listNode = new ListNode(r.intValue());
            point.next = listNode;
            point = point.next;
        }

        return head.next;

    }


    /**
     * 方法二：自己加，更巧
     * 时间复杂度(max(m,n)) m为l1长度，n为l2长度
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;

        while (l1 != null || l2 != null){
            l1 = l1 == null ? new ListNode(0) : l1;
            l2 = l2 == null ? new ListNode(0) : l2;
            Integer addRes = l1.val + l2.val + carry;
            carry = addRes / 10;
            int num = addRes % 10;
            point.next = new ListNode(num);
            point = point.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        //防止最高位的相加后还有进位，得再开辟一个节点
        if (carry != 0){
            point.next = new ListNode(carry);
        }

        return head.next;
    }



}
