class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        TreeNode cur = root, last = null;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                sum += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != last) {
                cur = cur.right;
            } else {
                if (cur.left == null && cur.right == null && targetSum == sum) {
                    return true;
                }
                last = stack.pop();
                sum -= last.val;
                cur = null;
            }
        }
        return false;
    }
}