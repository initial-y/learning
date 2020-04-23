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

    /**
     * 向BST中插入元素
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的BST中插入元素e，  递归
     * 返回插入新节点后BST的根
     * @param node
     * @param e
     * @return
     */
    public Node add(Node node, E e) {
        if (node == null) {
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            // e < node.e 往左节点插入
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // e > node.e 往右节点插入
            node.right = add(node.right, e);
        }
        // e = node.e 不做处理
        return node;
    }


//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
//    }
//
//    /**
//     * 递归插入
//     * @param node
//     * @param e
//     */
//    private void add(Node node, E e) {
//
//        // 递归终止条件
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        // 递归条件
//        if (e.compareTo(node.e) < 0) {
//            // node.left != null
//            add(node.left, e);
//        } else {
//            // e.compareTo(node.e) > 0 && node.right != null
//            add(node.right, e);
//        }
//    }

    public boolean contains(E e) {
        return this.contains(root, e);
    }

    /**
     * 以node为根BST是否包含e
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return this.contains(node.left, e);
        } else {
            return this.contains(node.right, e);
        }
    }

    /**
     * 二叉树的前序遍历
     */
    public void preOrder() {
        this.preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("==");
        }
        return sb.toString();
    }
}
