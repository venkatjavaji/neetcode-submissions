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

        //find the mid of the given ListNode
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        print("printing slow after finding mid", slow);
        //slow is at the middle of the ListNode
        //Now reverse the mid+1 to the length of the ListNode
        ListNode secondHalf = slow.next; //consider this as new root [1-2]-[4-5]
        slow.next= null; //why this has to be set to null!!? because we need to breack the head to point to middle of th listNode**

         print("printing slow after setting null to next", slow);
        ListNode shPrev = null; 
        
        ListNode current = secondHalf; // 4-5
        while(current!=null) {
            ListNode shNext = current.next; //5
            current.next = shPrev; //4-null
            shPrev = current;// 4-null
            current = shNext; //5
        }
    
        ListNode first = head;
        secondHalf = shPrev;
        while(secondHalf!=null) {
            ListNode tmp1 = first.next;//4
            ListNode tmp2 = secondHalf.next;//6
            first.next = secondHalf;//2-8
            secondHalf.next = tmp1;//8-4
            //2-8-4
            first = tmp1; //increment
            secondHalf = tmp2; //increment

        }

        
        
    }

    public void print(String message, ListNode node) {
            System.out.print("Printing : " + message + " \t");
            while(node!=null) {
                System.out.print(" - "+ node.val);
                node = node.next;
            }
            System.out.println();
        }
}
