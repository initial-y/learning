package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树-后续遍历
 * @author xin.yang
 * @className BinaryTreePostorderTraversal
 * @description
 * @date 2021/10/11
 * @num 145
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        if (root != null) {
            this.dfs(root.left, nodeList);
            this.dfs(root.right, nodeList);
            nodeList.add(root.val);
        }

        return nodeList;
    }

    private void dfs(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            this.dfs(node.left, nodeList);
            this.dfs(node.right, nodeList);
            nodeList.add(node.val);
        }
    }

}
