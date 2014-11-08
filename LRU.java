import java.util.HashMap;
public class LRUCache {
    private HashMap<Integer,DoubleLinkedListNode> map = new HashMap<Integer,DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private int len;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            setHead(map.get(key));
            return map.get(key).val;}
        else return -1;
    }
    
    public void set(int key, int value) {
        DoubleLinkedListNode node = new DoubleLinkedListNode(key,value);
        if(len == 0){
            setHead(node);
            map.put(key,node);
            len++;
        }
        if(map.containsKey(key)){
            DoubleLinkedListNode cur = map.get(key);
            cur.val = value;
            remove(map.get(key));
            setHead(cur);
        }
        else{
            if(len < capacity){
                map.put(key,node);
                len++;
                setHead(node);
            }
            else{
                map.remove(end.key);
                end = end.pre;
                if(end != null)
                    end.next = null;
                setHead(node);
                map.put(key,node);
            }
        }
    }
    
    public void setHead(DoubleLinkedListNode node){
        node.next = head;
        node.pre = null;
        if(head != null)
            head.pre = node;
        head = node;
        if(end == null)
            end = node;
    }
    
    public void remove(DoubleLinkedListNode node){
        DoubleLinkedListNode pre = node.pre;
        DoubleLinkedListNode next = node.next;
        if(pre != null)
            pre.next = next;
        else head = next;
        if(next != null)
            next.pre = pre;
        else end = pre;
    }
}
class DoubleLinkedListNode{
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;
    public int key;
    public int val;
    public DoubleLinkedListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}