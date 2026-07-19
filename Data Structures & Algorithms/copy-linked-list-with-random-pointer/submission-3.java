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
        if(head == null) return null;
        //create a new node and copy the new-node in-between current
        Node curr = head;
        while(curr!=null) {
            Node copy = new Node(curr.val); //1'
            Node next = curr.next; // 2
            curr.next = copy; //1 ==> 1-1'
            copy.next = next; // 1' ==> 1'-2
            curr = copy.next; // 2
        }

        // now copy the random nodes
        curr = head; //1-
        while(curr!=null) {
            Node copyNode = curr.next; //2 -> 2'
            Node currRandom = curr.random; // 2 random - 3
            if(currRandom!=null) {
                //make sure to copy the correct value, null check is needed
                copyNode.random = currRandom.next; //2'.random = 3.next = 3'
            }
            curr = curr.next.next; //move to the next currentNode 
        }

        // this is curr -> 1-1'-2-2'-3-3'  make it to 1'-2'-3'
        curr = head;
        Node newHead = head.next;
        while(curr!=null) {
            Node copy = curr.next; // 1'
            curr.next = copy.next; // 1 => 1-2
            copy.next = (copy.next!=null)? copy.next.next : null; // 1' => 1'-2'
            curr = curr.next; //2
        }
        return newHead;
    }
}
