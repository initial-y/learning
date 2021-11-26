package algorithm.leetcode.medium;

import algorithm.leetcode.Node;

import java.util.ArrayDeque;
import java.util.Queue;

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

    /**
     * dfs
     * @param node1
     * @param node2
     */
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

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 当前层级节点数量
            int levelSize = queue.size();

            // 暂存前一个节点
            Node prev = null;
            for (int i = 0; i < levelSize; i++) {
                // 弹出队首
                Node cur = queue.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

    }
}
