package algorithm.leetcode.medium;

import algorithm.leetcode.easy.ListNode;

/**
 * @ClassName AddTwoNumbers
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/20
 * @no 2
 * @see https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    /**
     * 测试用例未覆盖完全版本
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersWrong(ListNode l1, ListNode l2) {
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

    /**
     * long类型也抵不住24位的test case
     * @param head
     * @return
     */
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

    /**
     * 纯链表操作版本
     * 关注对应链表节点的值
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 虚拟头结点,简化操作
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 不破坏l1, l2结构
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        // 进位
        int carry = 0;
        while (tmp1 != null || tmp2 != null) {
            // 处理空节点
            int num1 = (tmp1 == null) ? 0 : tmp1.val;
            int num2 = (tmp2 == null) ? 0 : tmp2.val;

            // 计算节点值与进位值
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            // 节点后移
            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
        }
        // 循环完毕还需要进位
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
