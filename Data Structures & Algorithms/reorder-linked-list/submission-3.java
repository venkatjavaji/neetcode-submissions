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
    public void reorderList(ListNode head) {

        //determine the mid
        //reverse the second half
        // join them now..

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode shalf = slow.next;
        slow.next = null; // making the head get truncated to first half;

        ListNode prev = null;
        ListNode temp = shalf; //1-2-null;
        while(temp!=null) {
            ListNode next = temp.next; //2-null; | null
            temp.next = prev; // 1-null | 2-1-null
            prev =  temp;// 1-null; | 2-1-null
            temp = next; //2-null | null
        }

        ListNode first = head;
        ListNode second = prev;
        while(second!=null) {
            ListNode n1 = first.next;
            ListNode n2 = second.next;
            first.next = second;
            second.next = n1;

            first = n1;
            second = n2;
            
        }
    }
}
