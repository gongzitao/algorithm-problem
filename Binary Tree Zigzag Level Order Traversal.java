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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        boolean reverse = false;
        int pre_count = 1;
        int cur_count = 0;
        ArrayList<Integer> item = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            pre_count--;
            if(!reverse)
                item.add(node.val);
            else item.add(0,node.val);
            if(node.left != null){
                queue.add(node.left);
                cur_count++;
            }
            if(node.right != null){
                queue.add(node.right);
                cur_count++;
            }
            if(pre_count == 0){
                pre_count = cur_count;
                cur_count = 0;
                reverse = !reverse;
                res.add(item);
                item = new ArrayList<Integer>();
            }
        }
        return res;
    }
}

    