package algorithm.leetcode.easy;


import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className MaximumDepthOfBinaryTree
 * @description
 * @date 2021/8/2
 * @num 104
 * @link https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {

    /**
     * DFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = this.maxDepth(root.left);
        int rightDepth = this.maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
