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
        public void dfs(TreeNode v, int l, int r){
        if (v == null){
            return ;
        }
        if (v.val>=l && v.val<=r){
            this.Sum+=v.val;
        }
        if (v.val<=l){
            dfs(v.right,l,r);
        }else{
            if (v.val>=r){
                dfs(v.left,l,r);
            }else{
                dfs(v.left,l,r);
                dfs(v.right,l,r);
            }
        }
    }
    public int Sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return this.Sum;
    }
}