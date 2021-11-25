package algorithm.leetcode.medium;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className SumRootToLeafNumbers
 * @description
 * @num 129
 * @date 2021/11/25
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return generateNum(root, 0);
    }


    private int generateNum(TreeNode root, int preSum) {
        // base case : 叶子节点的处理
        if (root.left == null && root.right == null) {
            return preSum*10 + root.val;
        }
        // 前序遍历: 自顶向下, 后续节点的值需要通过父节点的值计算
        preSum = preSum * 10 + root.val;
        if (root.right == null) {
            return generateNum(root.left, preSum);
        }
        if (root.left == null) {
            return generateNum(root.right, preSum);
        }

        return generateNum(root.left, preSum) + generateNum(root.right, preSum);

    }

}
