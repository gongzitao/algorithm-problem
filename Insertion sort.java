/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode res = new ListNode(0);
        //res.next = head;
        ListNode node = head;
        while(node != null){
            ListNode first = res;
            while(first.next != null && node.val >= first.next.val){
                first = first.next;
            }
            ListNode next = node.next;
            node.next = first.next;
            first.next = node;
            node = next;
        }
        return res.next;
    }
}