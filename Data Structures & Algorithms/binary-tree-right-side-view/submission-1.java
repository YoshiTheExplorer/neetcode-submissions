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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> sol = new ArrayList<>();

        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                if(i == count - 1){
                    sol.add(cur.val);
                }
            }
        }
        return sol;
    }
}
