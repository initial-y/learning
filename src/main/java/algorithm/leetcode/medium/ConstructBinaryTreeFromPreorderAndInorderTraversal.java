package algorithm.leetcode.medium;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className ConstructBinaryTreeFromPreorderAndInorderTraversal
 * @description
 * @date 2021/11/18
 * @num 105
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLow, int preHigh,
                          int[] inorder, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh) {
            return null;
        }
        // 根据根节点将中序一分为2
        int rootIndex = 0;
        int rootValue = preorder[preLow];
        for (int i = inLow; i <= inHigh; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
            }
        }

        /**
         * 确定下标过程
         * 在中序遍历中, root左侧节点的数据范围inorder[inLow, rootIndex - 1], 节点个数 = rootIndex - inLow
         *            root右侧节点的数据范围inorder[rootIndex + 1, inHigh]
         * 在前序遍历中, 第一个节点为根节点, 根节点左子节点的范围preorder[preLow + 1, preLow + leftSize]
         *                             根节点右子节点的范围preorder[preLow + leftSize +1, preHigh]
         */
        int leftSize = rootIndex - inLow;
        // 前序确定根节点
        TreeNode root = new TreeNode(preorder[preLow]);
        // 递归查找左右节点
        root.left = this.build(preorder, preLow + 1 , preLow + leftSize, inorder, inLow, rootIndex - 1);
        root.right = this.build(preorder, preLow + leftSize + 1 , preHigh, inorder, rootIndex + 1, inHigh);
        return root;
    }
}
