import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        ListNode solution = solution(l1, l2);
        System.out.println(solution);
    }

    public static ListNode solution(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, current = head;
        int carry = 0; // 进位
        while (p != null || q != null){
            int p_next = p == null ? 0 : p.val;
            int q_next = q == null ? 0 : q.val;
            current.next = new ListNode((p_next + q_next + carry) % 10);
            carry = (p_next + q_next + carry ) / 10;
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry != 0) current.next = new ListNode(1);
        return  head.next;
    }

}


 // Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     @Override
     public String toString() {
         return "ListNode{" +
                 "val=" + val +
                 ", next=" + next +
                 '}';
     }
 }
