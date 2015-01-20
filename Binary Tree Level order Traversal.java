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
import java.util.LinkedList;
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if(root == null) return res;
        int pre_count = 1;
        int cur_count = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            item.add(node.val);
            pre_count --;
            if(node.left != null){
                cur_count++;
                queue.add(node.left);
            }
            if(node.right != null){
                cur_count++;
                queue.add(node.right);
            }
            if(pre_count == 0){
                pre_count = cur_count;
                cur_count = 0;
                res.add(0,item);
                item = new ArrayList<Integer>();
            }
        }
        return res;
    }
}