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
        Node cur = head;
        while(cur!=null) {
            Node n1 = new Node(cur.val);
            n1.next = cur.next;
            cur.next = n1;
            cur = n1.next;
        }
        //1-1'-2-2'-3-3'null;
        cur = head;
        while(cur!=null) {
            //1-1'
            if(cur.random!=null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node n2 = head.next;
        while(cur!=null) {   
           Node copy = cur.next; //1'
           cur.next = copy.next; //1-2
           copy.next = (cur.next!=null) ? cur.next.next : null; //1'-2'
           cur = cur.next;  
        }

        return n2;
        
    }
}
