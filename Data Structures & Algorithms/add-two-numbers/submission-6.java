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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
            129+341 = 470

            99+99 = 198
        */
        ListNode result = new ListNode(-1);
        ListNode n1 = result;
        int q =0;
        int r = 0;
        while(l1!=null || l2!=null) {
            int f = (l1==null) ? 0 : l1.val;
            int s = (l2==null) ? 0 : l2.val; 
            int sum = f + s + q;
            q = sum/10; //18/10 = 1
            r = sum%10; // 18%10 = 8
            n1.next = new ListNode(r);
            l1 = (l1==null) ? l1 : l1.next;
            l2 = (l2==null) ?  l2 : l2.next;
            n1 = n1.next;
        }

        if(q>0) {
            n1.next = new ListNode(q);
        }

        return result.next;
    }
}
