/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        h = head;
        int length = getLength(head);
        return build(0,length - 1);
    }
    private TreeNode build(int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = build(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = build(mid + 1,end);
        root.left = left;
        root.right = right;
        return root;
    }
    private int getLength(ListNode head){
        if(head == null) return 0;
        ListNode list = head;
        int length = 0;
        while(list != null){
            length++;
            list = list.next;
        }
        return length;
    }
}