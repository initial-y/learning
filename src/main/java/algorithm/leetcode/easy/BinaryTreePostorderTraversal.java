package algorithm.leetcode.easy;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树-后续遍历
 * @author xin.yang
 * @className BinaryTreePostorderTraversal
 * @description
 * @date 2021/10/11
 * @num 145
 */
public class BinaryTreePostorderTraversal {

    /**
     * 后续遍历-迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        this.dfs(root, nodeList);
        return nodeList;
    }

    private void dfs(TreeNode node, List<Integer> nodeList) {
        if (node != null) {
            this.dfs(node.left, nodeList);
            this.dfs(node.right, nodeList);
            nodeList.add(node.val);
        }
    }

    /**
     * 后续遍历-递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> nodeList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {
            // 找到当前节点最左侧叶节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 判断当前节点是否有右节点
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                // 有右节点, 从右节点重新开始
                cur = cur.right;
            } else {
                // 无右节点
                nodeList.add(cur.val);
                stack.pop();
                prev = cur;
                cur = null;
            }
        }

        return nodeList;
    }

}
