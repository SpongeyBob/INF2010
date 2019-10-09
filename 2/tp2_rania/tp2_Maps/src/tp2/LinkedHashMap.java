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
        if (shouldRehash())
        {
            this.capacity *= CAPACITY_INCREASE_FACTOR;
            Node<KeyType, DataType>[] map1 = this.map;
            this.clear();
            this.size = 0;
            Node<KeyType, DataType>[] map2 = new Node[this.capacity];

            for (int i = 0; i < map1.length; i++) {
                for (Node<KeyType, DataType> n = map1[i]; n != null; n = n.next) {
                   map2[i]=map1[i];
                   this.map[i]=map2[i];
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

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        boolean exist=false;
    for(int i=0; i<this.map.length;i++)
    for(Node<KeyType, DataType> n = this.map[i]; n != null; n = n.next)
    {
        if (n.key==key)
            exist=true;
    }
    return exist;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {

        DataType datatypeattached = null;

        if(this.containsKey(key))
        {
            int index= getIndex(key);

                for (Node<KeyType, DataType> n = this.map[index]; n != null; n = n.next)
                {
                    if (n.key == key)
                        datatypeattached = n.data;

                }
        }
        return datatypeattached;
    }

    /** TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value)
    {
        if (this.containsKey(key))
        {
            int index=getIndex(key);
           return this.map[index].data;
            this.map[index].data;
        }
        else
            return null;
        /*for (int i = 0; i < this.map.length; i++)
        {
            for (Node<KeyType, DataType> n = this.map[i]; n != null; n = n.next)
            {
                if (n.key == key)
                {
                    olddata = n.data;
                    n.data = value;
                }
            }

        }
        return olddata;

         */

    }

    /** TODO
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key)
        {
        DataType removed=null;
        if (this.containsKey(key))
        {
            for (int i = 0; i < this.map.length; i++)
            {
                for(Node<KeyType, DataType> n = this.map[i]; n != null; n = n.next)
                {
                    if (n.key == key)
                    {
                        this.map[i - 1].next = this.map[i + 1];
                        this.map[i].next = null;
                        removed = this.map[i].data;
                    }
                }
            }

        }

        //parcours trouver la key
        //(trouver lindex)pointeur next du avant le key pointe vers prochain de key
        //pointeur previous du apres du key == est le avant du key
        //key next==null

        return removed;
    }


    /** TODO
     * Removes all nodes contained within the map
     */
    public void clear() {
        this.map[0]= new Node<KeyType, DataType>(null,null);
        this.map[0].next=this.map[this.map.length];
        this.map[this.map.length]= new Node<KeyType, DataType>(null,null);
        this.map[this.map.length].next=this.map[0];

        /*for (int i=0, i<map.length; i++)
        {
        for(Node<KeyType, DataType> n = this.map[i]; n != null; n = n.next )
            {

            }
        }

         */

        this.size = 0;


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

