class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer,Node> map;
    Node head, tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail; //null <- head <-> tail -> null
        this.tail.prev = this.head;
        this.map = new HashMap<>();
        
    }

    public void remove(Node node) {
        // A <-> B <-> C :: assume removing B
        node.prev.next = node.next;  // A -> C
        node.next.prev = node.prev; // C <- A
        // A <-> C
    }

    public void insertAtHead(Node node) {
        //head <->B :: assume insert A at the Head
        node.prev = head;   // head <- A
        node.next = head.next; // A -> B
        head.next.prev = node; // A <- B
        head.next = node; // head -> A
        //head <-> A <-> B
    }
    
    public int get(int key) {

        if(!map.containsKey(key)) return -1;
        
        //return the val from head.next
        Node current = map.get(key);

        //now move this current next to head :: LRU
        //1 - remove it from current position
        remove(current);
        //2 - inset At head
        insertAtHead(current);
        // 3 - return the val
        return current.val;

    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)) {
            //replace the value in map
            // remove the node from current position
            // move it next to the head
            Node oldNode = map.get(key);
            remove(oldNode);
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
            return;
        }
        //brand new value
        // check if map.size reached capacity
        if(map.size() >= capacity) {
            //remove the node prev to tail
            Node lessused = tail.prev;
            remove(lessused);
            map.remove(lessused.key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtHead(newNode);
        
    }
}
