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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode check = head;
        for(int i=0; i< k; i++) {
            //checking to see if the ListNode size less than k then return the received Node
            if(check==null) return head;
            check = check.next;
        }

        //reverse the kGroup
        ListNode prev = null;
        ListNode curr = head;
        for(int j=0;j<k;j++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //curr points to the k+1 node and prev holds the reverse NodeList
        System.out.println("curr val : " +curr);
        head.next = reverseKGroup(curr,k);

        return prev;
      
    }
}
