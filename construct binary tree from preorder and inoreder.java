/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashMap;
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = builtTree(0,preorder.length - 1,preorder,0,inorder.length - 1,inorder,map);
        return root;
    }
    private TreeNode builtTree(int start, int end, int[] preorder,int left, int right,int[] inorder, HashMap<Integer,Integer> map){
        if(start > end || left > right) return null;
        int index = map.get(preorder[start]);
        TreeNode root = new TreeNode(preorder[start]);
        TreeNode leftnode = builtTree(start + 1,start + index - left,preorder,left,index - 1,inorder, map);
        TreeNode rightnode = builtTree(start + index - left + 1,end,preorder,index + 1,right,inorder,map);
        root.left = leftnode;
        root.right = rightnode;
        return root;
    }
}