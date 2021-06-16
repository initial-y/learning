package algorithm.leetcode;

/**
 * @ClassName ListNode
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/15
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // 构造函数
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("empty arr");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("Null");
        return sb.toString();
    }
}
