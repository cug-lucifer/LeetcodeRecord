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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Long> levelSumArr = new ArrayList<Long>();

        while (!queue.isEmpty()){
            List<TreeNode> levelNodes = new ArrayList<TreeNode>(queue);
            queue.clear();
            long levelSum = 0L;
            for (TreeNode node:levelNodes){
                levelSum+=node.val;
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            levelSumArr.add(levelSum);
        }
        if (levelSumArr.size()<k){
            return -1L;
        }
        Collections.sort(levelSumArr);
        return levelSumArr.get(levelSumArr.size()-k);
    }
}