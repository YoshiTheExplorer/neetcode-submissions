/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

        if (root != null) {
            queue.add(root);
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int nodes = queue.size();
            sol.add(new ArrayList<>());
            for (int i = 0; i < nodes; i++) {
                TreeNode parent = queue.removeFirst();
                sol.get(level).add(parent.val);
                if (parent.left != null) {
                    queue.add(parent.left);
                }
                if (parent.right != null) {
                    queue.add(parent.right);
                }
            }
            level++;
        }

        return sol;
    }
}
