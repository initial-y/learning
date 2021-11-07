package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.*;

/**
 * 二叉树-前序遍历
 * @author intial.y
 * @className BinaryTreePreorderTraversal
 * @description
 * @date 2021/10/11
 * @num 144
 */
public class BinaryTreePreorderTraversal {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        this.dfs(root, nodeList);
        return nodeList;
    }

    private void dfs(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            nodeList.add(node.val);
            this.dfs(node.left, nodeList);
            this.dfs(node.right, nodeList);
        }
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 沿着**当前TreeNode**一直到最左侧叶节点
            while (cur != null) {
                // 根在前
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            // 从最左叶节点开始遍历
            cur = stack.pop();
            cur = cur.right;
        }

        return result;
    }
}
