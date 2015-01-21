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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        inorder(root,pre,res);
        if(res.size() > 1){
            int temp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val = temp;
        }
    }
    private void inorder(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res){
        if(root == null) return ;
        inorder(root.left,pre,res);
        if(pre.get(0) != null && pre.get(0).val > root.val){
            if(res.size() == 0){
                res.add(pre.get(0));
                res.add(root);
            }
            else res.set(1,root);
        }
        pre.set(0,root);
        inorder(root.right,pre,res);
    }
}