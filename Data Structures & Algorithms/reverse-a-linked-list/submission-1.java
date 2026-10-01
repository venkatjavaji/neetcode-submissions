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

        ListNode temp = head;
        ListNode prev = null;
        //1-2-3-n
        while(temp!=null) {
            ListNode cur = temp.next;  //2-3-n   1. Save the rest of the list (e.g., node 2)
            temp.next = prev;   // 1-n 2. Reverse the current node's pointer
            prev = temp; // 1-n 3. Move prev forward to the current node
            temp = cur; //2-3-n 4. Move the loop pointer forward using your saved reference
        }
        return prev;
        
    }
}
