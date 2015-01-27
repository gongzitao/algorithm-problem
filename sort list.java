/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        ListNode node = head;
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return sort(0,length - 1, head);
    }
    private ListNode sort(int start, int end, ListNode head){
        if(start > end) return null;
        if(start == end) return head;
        // find the mid node
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        int mid = (start + end) / 2;
        ListNode left = sort(start,mid,head);
        ListNode right = sort(mid + 1, end, node);
        return merge(left,right);
    }
    private ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        ListNode node = new ListNode(0);
        ListNode ret = node;
        while(left != null && right != null){
            if(left.val > right.val){
                ret.next = right;
                right = right.next;
                ret = ret.next;
            }
            else{
                ret.next = left;
                left = left.next;
                ret = ret.next;
            }
        }
        if(left != null) ret.next = left;
        if(right != null) ret.next = right;
        return node.next;
    }
}