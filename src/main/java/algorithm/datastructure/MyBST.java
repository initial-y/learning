package algorithm.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * 二叉树的前序遍历-递归
     * @seq 访问节点 -> traverse(node.left) -> traverse(node.right)
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

    /**
     * 前序遍历-非递归
     * @desc 实现比递归复杂，需借助其他数据结构，应用不广泛
     */
    public void preOrderNonRecursive() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
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

    /**
     * 中序遍历
     * @seq traverse(node.left) -> 访问节点 -> traverse(node.right)
     * @desc BST 中序遍历的结果是顺序的
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后续遍历
     * @seq traverse(node.left) -> traverse(node.right) -> 访问节点
     * @desc 后续遍历的应用： 为二分搜索树释放内存（c++)
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
         }
    }

    /**
     * 获取BST最小元素
     * @return
     */
    public E getMin() {
        if (size == 0) {
            throw new IllegalArgumentException("empty BST");
        }
        return getMin(root).e;
    }

    private Node getMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    /**
     * 获取BST最大元素
     * @return
     */
    public E getMax() {
        if (size == 0) {
            throw new IllegalArgumentException("empty BST");
        }
        return getMax(root).e;
    }

    private Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    /**
     * 删除BST最小值
     * @return
     */
    public E removeMin() {
        E min = getMin();
        // 赋值新root
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node curRight = node.right;
            node.right = null;
            size--;
            return curRight;
        } else {
            // 递归
            node.left = removeMin(node.left);
            return node;
        }
    }

    /**
     * 删除BST最大值
     * @return
     */
    public E removeMax() {
        E max = getMax();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node curLeft = node.left;
            node.left = null;
            size--;
            return curLeft;
        } else {
            node.right = removeMax(node.right);
            return node;
        }
    }

    /**
     * 删除元素为e的节点
     * @return
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
           return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // e == node.e
            // 待删除节点左子树为空
            if (node.left == null) {
                Node curRight = node.right;
                node.right = null;
                size--;
                return curRight;
            }
            // 待删除节点右子树为空
            if (node.right == null) {
                Node curLeft = node.left;
                node.left = null;
                size--;
                return curLeft;
            }
            // 待删除节点左右子树均不为空
            // 找到比待删除节点大的最小节点（删除节点右子树的最小节点）-- 也可以用左子树节点最大值来替换这个节点
            // 用这个节点顶替待删除节点的位置
            Node successor = getMin(node.right);
            // size--
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }
}
