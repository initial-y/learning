package algorithm.leetcode.easy;

/**
 * @ClassName RemoveLinkedListElements
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/12
 * @no 203
 * @see https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    /**
     * 比较 & 删除， 需处理头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // head.val = val
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        // head.val != val, 通过prev遍历
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val != val) {
                prev = prev.next;
            } else {
                prev.next = prev.next.next;
            }
        }
        return head;
    }

    /**
     * 通过虚拟头结点删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsWithDummyHead(ListNode head, int val) {
        // 按理应该赋值null, 这里题设指定了数据接口
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        head = dummyHead;

        // 设置了虚拟头结点 从head.next开始遍历
        while (head.next != null ) {
            if (head.next.val == val) {
                // 值匹配则跳过
                head.next = head.next.next;
            } else {
                // 值不匹配修改head(等价于修改removeElements的prev)
                head = head.next;
            }
        }
        return dummyHead.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        // 构造函数
        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("empty arr");
            }
//            ListNode cur = new ListNode(arr[0]);
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

}
