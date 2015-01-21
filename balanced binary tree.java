/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int res = getDepth(root);
        if(res == -1) return false;
        else return true;
    }
    private int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        else return Math.max(left,right) + 1;
    }
}