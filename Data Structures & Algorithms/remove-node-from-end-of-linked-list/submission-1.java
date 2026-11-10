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
        ListNode temp = head;
        int size = 0;
        while(temp!=null) {
            temp = temp.next;
            size++;
        }
        System.out.println("size : "+size); 

        if(size == n) return head.next;
        int index = size-n-1;
        ListNode temp2 = head;
        for(int i=0;i<index;i++) {
            temp2 = temp2.next;
        }

        temp2.next = temp2.next.next;

        return head;

    }
}
