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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //move the fast pointer by n places
        // and then move the ponter by one place
        //by the time the fast point next points to null then you can replace the next ele of slow pointer :)

        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<n;i++) {
            fast = fast.next;
        }
        // when n == list size, fast will be at the null position
        if(fast==null) {
            return head.next;
        }
        
        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
