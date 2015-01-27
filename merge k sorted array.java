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
import java.util.ArrayList;
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null) return null;
        int length = lists.size();
        return divide(0,length - 1,lists);
    }
    private ListNode divide(int start, int end, ArrayList<ListNode> lists){
        if(start > end) return null;
        if(start == end) return lists.get(start);
        int mid = (start + end) / 2;
        ListNode left = divide(start,mid,lists);
        ListNode right = divide(mid + 1, end,lists);
        return merge(left,right);
    }
    private ListNode merge(ListNode list1, ListNode list2){
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = new ListNode(list1.val);
                list1 = list1.next;
                head = head.next;
            }
            else{
                head.next = new ListNode(list2.val);
                list2 = list2.next;
                head = head.next;
            }
        }
        if(list1 != null){
            head.next = list1;
        }
        if(list2 != null){
            head.next = list2;
        }
        return res.next;
    }
}