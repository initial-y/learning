package algorithm.leetcode.medium;

import algorithm.leetcode.Node;

/**
 * @author initial.y
 * @className PopulatingNextRightPointersInEachNode
 * @description
 * @date 2021/11/24
 * @num 116
 */
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
//        // 只能处理节点内的next, 不能处理跨节点的情况(node1.right -> node2.left)
//        root.left.next = root.right;
//        Node left = connect(root.left);
//        Node right = connect(root.right);

        if (root == null) {
            return null;
        }

        connectTwoNodes(root.left, root.right);
        return root;
    }

    private void connectTwoNodes(Node node1, Node node2) {
        // 题设给定是完全二叉树, 按理只用判断node1不为空就可以
        if (node1 == null || node2 == null) {
            return;
        }
        // 前序遍历
        node1.next = node2;
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node1.right, node2.left);
        connectTwoNodes(node2.left, node2.right);
    }
}
