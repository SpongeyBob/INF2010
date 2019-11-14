package Tp4;

import java.util.*;


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType> {
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType[] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications =0;    // Nombre de modifications apportees a ce monceau

    @SuppressWarnings("unchecked")
    public BinaryHeap(boolean min) {
        this.min = min;
        currentSize = 0;
        array = (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
    }

    @SuppressWarnings("unchecked")
    public BinaryHeap(AnyType[] items, boolean min) {
        this.min = min;
        currentSize = items.length;
        array = (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
        for (int i = 0; i < items.length; i++) {
            array[i + 1] = items[i];
        }
        if (min) buildMinHeap();
        else buildMaxHeap();
    }

    public boolean offer(AnyType x) {
        if (x == null)
            throw new NullPointerException("Cannot insert null in a BinaryHeap");

        if (currentSize + 1 == array.length)
            doubleArray();
        //if empty put as root
        if (currentSize == 0)
            array[++currentSize] = x;
        else {
            array[++currentSize] = x;
            int index = currentSize;
            if(min){
                while(array[index].compareTo(array[index/2])<0){
                    swapReferences(array,index,index/2);
                    index = index/2;
                    if (index == 1) break;
                }
            }else {
                while(array[index].compareTo(array[index/2])>0){
                    swapReferences(array,index,index/2);
                    index = index/2;
                    if (index == 1) break;
                }
            }
        }
        modifications++;
        return true;
    }

    public AnyType peek() {
        if (!isEmpty())
            return array[1];

        return null;
    }

    public AnyType poll() {
        AnyType retval = peek();
        swapReferences(array,1,currentSize);
        array[currentSize] = null;
        currentSize--;
        if(min) buildMinHeap();
        else buildMaxHeap();
        modifications++;
        return retval;
    }

    public Iterator<AnyType> iterator() {
        return new HeapIterator();
    }

    private void buildMinHeap() {
        if(currentSize ==2){
            if(array[1].compareTo(array[2]) > 0 ) swapReferences(1,2);
        }
        for (int i = currentSize/2; i > 0; i--) {
            percolateDownMinHeap(i, currentSize);
        }
    }

    private void buildMaxHeap() {
        for (int i = currentSize/2; i > 0; i--) {
            percolateDownMaxHeap(i, currentSize - 1);
        }
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        currentSize = 0;
        modifications = 0;
        array = (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
    }

    private static int leftChild(int i, boolean heapIndexing) {
        return (heapIndexing ? 2 * i : 2 * i + 1);
    }

    private void swapReferences(int index1, int index2) {
        swapReferences(array, index1, index2);
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void swapReferences(AnyType[] array, int index1, int index2) {

        AnyType tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    @SuppressWarnings("unchecked")
    private void doubleArray() {
        AnyType[] newArray;

        newArray = (AnyType[]) new Comparable[array.length * 2];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        array = newArray;
    }


    /**
     * @param hole Position a percoler
     * @param size Indice max du tableau
     */
    private void percolateDownMinHeap(int hole, int size) {
        percolateDownMinHeap(array, hole, size, true);
    }

    /**
     * @param array        Tableau d'element
     * @param hole         Position a percoler
     * @param size         Indice max du tableau
     * @param heapIndexing True si les elements commencent a l'index 1, false sinon
     */
    @SuppressWarnings("unchecked")
    private static <AnyType extends Comparable<? super AnyType>>
    void percolateDownMinHeap(AnyType[] array, int hole, int size, boolean heapIndexing) {

        int childIndex;
        AnyType min = array[hole];
        for(; leftChild(hole,heapIndexing)<size;hole=childIndex){
            childIndex=leftChild(hole,heapIndexing);
            if(childIndex <size&& array[childIndex].compareTo(array[childIndex+1])>0)
                childIndex++;
            if(min.compareTo(array[childIndex])>0)
                array[hole]=array[childIndex];
            else break;
        }
        array[hole]=min;
    }

    /**
     * @param hole Position a percoler
     * @param size Indice max du tableau
     */
    private void percolateDownMaxHeap(int hole, int size) {
        percolateDownMaxHeap(array, hole, size, true);
    }

    /**
     * @param array        Tableau d'element
     * @param hole         Position a percoler
     * @param size         Indice max du tableau
     * @param heapIndexing True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void percolateDownMaxHeap(AnyType[] array, int hole, int size, boolean heapIndexing) {
        int childIndex;
        AnyType max = array[hole];
        for(; leftChild(hole,heapIndexing)<size;hole=childIndex){
            childIndex=leftChild(hole,heapIndexing);
            if(childIndex !=size-1&& array[childIndex].compareTo(array[childIndex+1])<0)
                childIndex++;
            if(max.compareTo(array[childIndex])<0)
                array[hole]=array[childIndex];
            else break;
        }
        array[hole]=max;

    }

    @SuppressWarnings("unchecked")
    public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a) {

        for(int i =(a.length/2) ;i>=0;--i){ //met max a la racine
            percolateDownMaxHeap(a,i,a.length-1,false);
        }
        for(int i =(a.length-1) ;i>=0;--i){ //met max a la racine
            swapReferences(a,0,i);
            percolateDownMaxHeap(a,0,i,false);
        }

    }

    public static <AnyType extends Comparable<? super AnyType>>
    void heapSortReverse(AnyType[] a) {
        for(int i =(a.length/2) ;i>=0;--i){ //met min a la racine
            percolateDownMinHeap(a,i,a.length-1,false);
        }
        for(int i =(a.length-1) ;i>=0;--i){
            swapReferences(a,0,i);
            percolateDownMinHeap(a,0,i,false);
        }
    }

    public String nonRecursivePrintFancyTree() {
        String outputString = "";
        String prefix = "";
        int i = 1;
        boolean isleft = false;  //enfant de droite ou de gauche
        while (i > 0) {
            outputString += prefix + "|__" + array[i] + "\n";
            if (i * 2 <= currentSize) { // si il a un enfant
                if(isleft) prefix += "|   ";
                else prefix += "    ";
                isleft = true;
                i+=i;
            }
            else if (isleft && i + 1 <= currentSize) { //si il a un voisin
                isleft = false;
                i++;
            }
            else {
                while(i % 2 != 0 ){
                    i = i /2;
                    if(i > 0) prefix = prefix.substring(0, prefix.length() - 4);
                }

                if(i > 0) ++i;
                isleft =  false;
            }
        }
        return outputString;
    }

    public String printFancyTree() {
        return printFancyTree(1, "");
    }

    private String printFancyTree(int index, String prefix) {
        String outputString = "";

        outputString = prefix + "|__";

        if (index <= currentSize) {
            boolean isLeaf = index > currentSize / 2;

            outputString += array[index] + "\n";

            String _prefix = prefix;

            if (index % 2 == 0)
                _prefix += "|  "; // un | et trois espace
            else
                _prefix += "   "; // quatre espaces

            if (!isLeaf) {
                outputString += printFancyTree(2 * index, _prefix);
                outputString += printFancyTree(2 * index + 1, _prefix);
            }
        } else
            outputString += "null\n";

        return outputString;
    }
    public ArrayList<AnyType> getArrayList(){
        ArrayList<AnyType> ar = new ArrayList<>();
        for(int i =1; i<=currentSize;++i){
            ar.add(array[i]);
        }
        return ar;
    }
    private class HeapIterator implements Iterator {
        int index =0;
        int modif = new Integer(modifications);
        public boolean hasNext() {
            return index<currentSize;
        }

        public Object next() throws NoSuchElementException,
                ConcurrentModificationException,
                UnsupportedOperationException {
            if(modif != modifications) throw new ConcurrentModificationException("Heap is already being modified");
            if(hasNext()) return array[++index];
            else throw new NoSuchElementException("iterator don't have next");
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
