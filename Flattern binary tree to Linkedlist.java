/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
public class Solution {
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(root == null) return;
        res.add(null);
        preorder(root,res);
    }
    private void preorder(TreeNode root, ArrayList<TreeNode> res){
        if(root == null) return;
        TreeNode right = root.right;
        if(res.get(0) != null){
            res.get(0).right = root;
            res.get(0).left = null;
        }
        else res.add(root);
        res.set(0,root);
        preorder(root.left,res);
        preorder(right,res);
    }
}