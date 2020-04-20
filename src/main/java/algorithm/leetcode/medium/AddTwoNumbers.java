package algorithm.leetcode.medium;

import algorithm.leetcode.easy.ListNode;

import java.util.Objects;
import java.util.Stack;

/**
 * @ClassName AddTwoNumbers
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/20
 * @no 2
 * @see https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = this.getReverseNum(l1);
        long num2 = this.getReverseNum(l2);

        String sumStr = String.valueOf(num1 + num2);
        char[] arr = sumStr.toCharArray();
        ListNode cur;
        ListNode prev = null;
        for (char c : arr) {
            cur = new ListNode(Integer.parseInt(String.valueOf(c)));
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }

    private long getReverseNum(ListNode head) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp;
        while (head != null) {
            tmp = new StringBuilder(String.valueOf(head.val));
            tmp.append(sb);
            sb = tmp;
            head = head.next;
        }
        return Long.parseLong(sb.toString());
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }
}
