package tp2;

public class LinkedHashMap<KeyType, DataType> {

    private static final double COMPRESSION_FACTOR = 2; // 50%
    private static final int DEFAULT_CAPACITY = 20;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int capacity;
    private int size = 0;

    public LinkedHashMap() {
        capacity = DEFAULT_CAPACITY;
        map = new Node[DEFAULT_CAPACITY];
    }

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * @param key Value used to access to a particular instance of a DataType within map
     * @return The index value attached to a particular key
     */
    private int getIndex(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return keyHash < 0 ? -keyHash : keyHash;
    }

    private boolean shouldRehash() {
        return size * COMPRESSION_FACTOR > capacity;
    }

    /** TODO
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        capacity *= CAPACITY_INCREASE_FACTOR;
        Node<KeyType,DataType> [] oldMap = map;
        map = new Node[capacity];
        size=0;
        for(int i=0; i< oldMap.length; i++){
            if(oldMap[i] != null) {
                put(oldMap[i].key, oldMap[i].data);
                Node nextNode = oldMap[i].next;
               while(nextNode != null){
                    put((KeyType) nextNode.key, (DataType)nextNode.data);
                    nextNode = nextNode.next;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Done
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        int index = getIndex(key);
        if(map[index] == null ) return false;
        Node<KeyType, DataType> node = map[index];
        while(node != null){
            if(node.key == key) return true;
            node=node.next;
        }
        return false;
    }

    /**
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        if(!containsKey(key)) return null;
        int index = getIndex(key);
        Node<KeyType, DataType> node = map[index];
        while(node != null){
            if (node.key == key) return node.data;
            node=node.next;
        }
        //this line should never run
        return null;

    }

    /**
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value)
    {
        if (shouldRehash()) rehash();
        int index = getIndex(key);
        if(containsKey(key)) { //key exist
            Node<KeyType, DataType> node = map[index];
            while(node != null) {
                if (node.key == key) { //replace value and return old value
                    DataType retVal = node.data;
                    node.data = value;
                    return retVal;
                }
                node=node.next;
            }
        }
        size++; // new addition

        //no collision just place
        if(map[index] == null ){
            map[index] = new Node<KeyType,DataType>(key,value);
            return null;
        }
        //collision happened
        Node<KeyType,DataType> node = new Node<KeyType,DataType>(key,value);
        node.next = map[index];
        return null;
    }

    /**
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key)
        {
        int index =this.getIndex(key);
        DataType retVal = null;
        if (this.containsKey(key)) {
            Node<KeyType, DataType> node = map[index];
            while(node!=null) {
                if (node.key == key) {
                    retVal = node.data;
                    node = node.next;
                    size--;
                    return retVal;
                }
                node=node.next;
            }
        }


        return null;

    }


    /** TODO
     * Removes all nodes contained within the map
     */
    public void clear() {
        for(int i =0; i< map.length ; ++i){
            if (map[i] != null ) {
                map[i] = null;
            }
        }
        size = 0;
    }


    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}


