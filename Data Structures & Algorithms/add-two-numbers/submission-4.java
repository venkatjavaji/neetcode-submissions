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

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        int quotient = 0;
        int reminder = 0;
        while(l1!=null || l2!=null) {
            int f = l1==null? 0: l1.val;
            int s = l2==null ? 0: l2.val;
            
            int sum = f+s+quotient;
            quotient = sum/10;
            reminder = sum%10;

            ListNode temp = new ListNode(reminder); //if reminder=1 :: temp[1,null]
            result.next = temp; //[-1->1->null]
            result = result.next;//[-1->1->null]

            l1 = l1!=null? l1.next : null;
            l2 = l2!=null ? l2.next : null;
            if(quotient!=0 && (l1==null && l2==null)) {
                ListNode tempQ = new ListNode(quotient);
                result.next = tempQ;
                result = result.next;
            }

        }
        return dummy.next;
        
    }
}
