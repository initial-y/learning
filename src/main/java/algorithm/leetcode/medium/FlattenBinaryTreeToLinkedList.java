package algorithm.leetcode.medium;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className FlattenBinaryTreeToLinkedList
 * @description
 * @date 2021/11/24
 * @num 114
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        // base case
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
        // why后续遍历? 因为需要先拉平左侧子树和右侧子树
        // 可以看做是自底向上的思想, 必须要根据子节点的值才能确定当前节点的结果

        // 左节点移动至右节点
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        // 迭代查找当前节点的最右侧叶子节点
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        // 原来的右侧节点续到移动后右侧叶子节点后面
        cur.right = right;
    }

}
