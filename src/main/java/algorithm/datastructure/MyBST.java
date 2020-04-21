package algorithm.datastructure;

/**
 * @ClassName MyBST
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/4/21
 */
public class MyBST<E extends Comparable<E>>  {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    private int size;

    public MyBST() {
        this.root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 递归插入
     * @param node
     * @param e
     */
    private void add(Node node, E e) {

        // 递归终止条件
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        // 递归条件
        if (e.compareTo(node.e) < 0) {
            // node.left != null
            add(node.left, e);
        } else {
            // e.compareTo(node.e) > 0 && node.right != null
            add(node.right, e);
        }
    }
}
