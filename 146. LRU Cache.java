public class LRUCache {
    class Node {
        Node next;
        Node prev;
        int value;
        int key;
        public Node (int key, int value) {
            this.value = value;
            this.key = key;
            next = null;
            prev = null;
        }
    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int count;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        count = 0;
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            deleteNode(tmp);
            insertHead(tmp);
            return tmp.value;
        } else {
            return -1;
        }
    }
    public void insertHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }
    public void deleteNode(Node node) {
        Node next = node.next;
        node.prev.next = next;
        next.prev = node.prev;
    }
    
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.value = value;
            deleteNode(tmp);
            insertHead(tmp);
        } else {
            Node insert = new Node(key, value);
            map.put(key, insert);
            
            if (count >= cap) {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                insertHead(insert);
            } else {
                insertHead(insert);
                count++;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
