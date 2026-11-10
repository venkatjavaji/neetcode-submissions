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
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode temp = head; //1-2-null;
        while(temp != null) {
            ListNode cur = temp.next; // 2-null; | null
            temp.next = prev; // 1-null;  | 2-1-null;
            prev = temp; // 1-null; | 2-1-null
            temp = cur; //2-null; | null
        }

        return prev;
        
    }
}
