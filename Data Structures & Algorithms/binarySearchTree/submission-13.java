class Node {
    int key;
    int val;
    Node left;
    Node right;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        left = null;
        right = null;
    }
}

class TreeMap {
    Node root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        if (root == null) {
            root = new Node(key, val);
            return;
        }
        Node newNode = new Node(key, val);
        Node cur = root;
        while (cur != null) {
            if (key > cur.key) {
                if (cur.right == null) {
                    cur.right = newNode;
                    return;
                }
                cur = cur.right;
            } else if (key < cur.key) {
                if (cur.left == null) {
                    cur.left = newNode;
                    return;
                }
                cur = cur.left;
            } else {
                cur.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        if (root == null) {
            return -1;
        }
        Node cur = root;
        while (cur != null) {
            if (key > cur.key) {
                cur = cur.right;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                return cur.val;
            }
        }
        return -1;
    }

    public int getMin() {
        if (root == null) {
            return -1;
        }

        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }

        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.val;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    private Node removeHelper(Node cur, int key) {
        if (cur == null) {
            return null;
        }
        if (key > cur.key) {
            cur.right = removeHelper(cur.right, key);
        } else if (key < cur.key) {
            cur.left = removeHelper(cur.left, key);
        } else {
            if (cur.left == null && cur.right == null) {
                return null;
            }
            if (cur.left == null) {
                return cur.right;
            }
            if (cur.right == null) {
                return cur.left;
            }

            Node replacement = cur.right;
            while (replacement.left != null) {
                replacement = replacement.left;
            }
            cur.val = replacement.val;
            cur.key = replacement.key;
            cur.right = removeHelper(cur.right, replacement.key);
        }
        return cur;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(Node root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.key);
            inorderTraversal(root.right, result);
        }
    }
}
