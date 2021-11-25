package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className MinimumDepthOfBinaryTree
 * @description
 * @date 2021/11/19
 * @num 111
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        // base case: 空节点
        if (root == null) {
            return 0;
        }
        // base case: 叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 左侧节点为空, 右侧节点不为空
        if (root.left == null) {
            return rightDepth + 1;
        }
        // 左侧节点不为空, 右侧节点为空
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右侧节点都不为空
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
