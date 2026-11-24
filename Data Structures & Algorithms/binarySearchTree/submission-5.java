class TreeNode {
    int key;
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class TreeMap {
    private TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        if (root == null) {
            root = new TreeNode(key, val);
            return;
        }
        root = insert(root, key, val);
    }

    private TreeNode insert(TreeNode root, int key, int val) {
        if (root == null) {
            return new TreeNode(key, val);
        }

        TreeNode cur = root;
        if (key > cur.key) {
            cur.right = insert(cur.right, key, val);
        } else if (key < cur.key) {
            cur.left = insert(cur.left, key, val);
        } else {
            cur.val = val;
        }
        return root;
    }

    public int get(int key) {
        if (root == null) {
            return -1;
        }

        TreeNode cur = root;

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
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.val;
    }

    public void remove(int key) {
        if (root == null) {
            return;
        }

        root = remove(root, key);
    }

    private TreeNode remove(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.key) {
            root.right = remove(root.right, key);
        } else if (key < root.key) {
            root.left = remove(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                root.key = temp.key;
                root.val = temp.val;
                root.right = remove(root.right, temp.key);
            }
        }
        return root;
    }

    public List<Integer> getInorderKeys() {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> sol = new ArrayList<>();
        TreeNode cur = root;

        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            sol.add(temp.key);
            cur = temp.right;
        }
        return sol;
    }
}
