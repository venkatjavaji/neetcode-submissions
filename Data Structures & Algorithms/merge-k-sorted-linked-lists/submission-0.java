/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeKListsHelper(lists,0,lists.length-1);
    }
    
    public ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {

        if(start == end) return lists[start];

        if(start+1 == end) return mergeTwoLists(lists[start], lists[end]);

        int mid = start + (end-start)/2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid+1, end);

        return mergeTwoLists(left,right);

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(list1!=null && list2!=null) {

            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1!=null) {
            current.next = list1;
        }

        if(list2!=null) {
            current.next = list2;
        }

        return dummy.next;
    }
}
