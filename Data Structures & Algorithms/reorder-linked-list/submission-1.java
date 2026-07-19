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

        //find the mid of the ListNode
            //mid of the element can be found by moving with slow and fast pointers
        //divide into firstHalf and secondHalf
        //reverse the secondHalf
        
        ListNode firstHalf = head;
        ListNode secondHalf = head;

        while(secondHalf!=null && secondHalf.next!=null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next.next;
        }
        printNode("firstHalf",firstHalf);
        printNode("secondHalf",secondHalf);
        ListNode middleNode = firstHalf.next;
        firstHalf.next=null;
        ListNode reverseNode = reverseList(middleNode);
        printNode("reverseNode",reverseNode);

        ListNode startNode = head;
        secondHalf = reverseNode;
        while(secondHalf!=null) {
            ListNode tmp1 = startNode.next;
            ListNode tmp2 = secondHalf.next;
            startNode.next = secondHalf;
            secondHalf.next = tmp1;
            startNode = tmp1;
            secondHalf = tmp2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public void printNode(String name, ListNode node) {
        StringBuilder b = new StringBuilder();
        while(node!=null) {
            b.append(node.val+" ");
            node = node.next;
        }
        System.out.println("name : " + name + " value : "+ b);
    }
}
