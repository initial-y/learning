package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

/**
 * @author xin.yang
 * @className MinimumDepthOfBinaryTree
 * @description
 * @date 2021/11/19
 * @num 111
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth);
    }
}
