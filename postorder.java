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
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastvisit = null;
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
                lastvisit = node;
            }
            else{
                TreeNode peek = stack.peek();
                if(peek.right != null && lastvisit != peek.right)
                    node = peek.right;
                else{
                    stack.pop();
                    res.add(peek.val);
                    lastvisit = peek;
                }
            }
        }
        return res;
    }
}