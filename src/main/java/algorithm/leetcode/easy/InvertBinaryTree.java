package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

/**
 * @author initial.y
 * @className InvertBinaryTree
 * @description
 * @date 2021/11/17
 * @num 226
 */
public class InvertBinaryTree {

    /**
     * 翻转整棵树就是交换每个节点的左右子节点，把交换左右子节点的代码放在了前序遍历的位置
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // √ 交换操作放前序遍历位置
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        this.invertTree(root.left);
        // × 不可以放在中序遍历
        // why? 中序遍历顺序: 左->根->右
        // 中序交换之后, 左节点交换到右边, 再交换右边节点,
        // 等于左节点交换到右边之后又被交换了一次, 而右节点换到左边后没有被交换到
        this.invertTree(root.right);
        // √ 也可以放在后续遍历位置
        return root;
    }


}
