package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className PathSum
 * @description
 * @date 2021/11/14
 * @num 112
 */
public class PathSum {

    /**
     * 递归
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

}
