package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className BalancedBinaryTree
 * @description
 * @date 2021/8/3
 * @num 110
 * @link https://leetcode-cn.com/problems/balanced-binary-tree/description/
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);

    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = this.getDepth(node.left);
        int rightDepth = this.getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
