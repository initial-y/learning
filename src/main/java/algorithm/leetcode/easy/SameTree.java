package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className SameTree
 * @description
 * @date 2021/11/22
 * @num 100
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
