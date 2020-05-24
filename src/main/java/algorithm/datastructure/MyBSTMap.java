package algorithm.datastructure;

/**
 * @ClassName MyBSTMap
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/5/24
 */
public class MyBSTMap<K extends Comparable<K>, V> implements IMyMap<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            // e < node.e 往左节点插入
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            // e > node.e 往右节点插入
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        // e = node.e 不做处理
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = this.getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // key == node.key
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


    private Node getMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
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

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("key isnt exist");
        }
        node.value = newValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
