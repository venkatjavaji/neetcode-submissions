/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return head;
        //create a Node and insert inbetween
        //1-2-3-nul;
        Node temp = head;
        while(temp!=null) {
            Node n1 = new Node(temp.val);
            n1.next = temp.next;
            temp.next = n1;
            temp = n1.next;
        }
        //1-1'-2-2'-3-3'null;
        temp = head;
        while(temp!=null) {
            //1-1'
            if(temp.random!=null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        temp = head;
        Node n2 = head.next;
        while(temp!=null) {   
           Node copy = temp.next; //1'
           temp.next = copy.next; //1-2
           copy.next = (temp.next!=null) ? temp.next.next : null; //1'-2'
           temp = temp.next;  
        }

        return n2;
        
    }
}
