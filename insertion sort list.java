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
        if(head == null) return head;
        //ListNode node = head;
        ListNode ret = new ListNode(0);
        while(head != null){
            ListNode pre = ret;
            while(pre.next != null && pre.next.val < head.val){
                    pre = pre.next;
            }
                ListNode next = head.next;
                head.next = pre.next;
                pre.next = head;
                head = next;
        }
        return ret.next;
    }
}