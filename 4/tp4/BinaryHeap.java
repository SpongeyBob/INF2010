package Tp4;
import java.util.*;


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min ){
	    this.min = min;
	    currentSize = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }

    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min ){
	    this.min = min;
	    currentSize = items.length;
        array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
        for(int i =0;i<items.length;i++){
            array[i+1] = items[i];
        }
	    if(min) buildMinHeap();
	    else buildMaxHeap();
    }
    
    public boolean offer( AnyType x ){
	    if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	    if( currentSize + 1 == array.length )
	    doubleArray();
	    //if empty put as root
        if(currentSize == 0)
            array[++currentSize] = x;
        else{
            array[++currentSize] = x;                                   //put as last element
            if(min) percolateDownMinHeap(currentSize,currentSize);      // percolate depending if max or min
            else percolateDownMaxHeap(currentSize,currentSize);
        }
        return true;
    }
    
    public AnyType peek(){
	    if(!isEmpty())
	    return array[1];
	
	    return null;
    }
    
    public AnyType poll(){
	    //COMPLETEZ
    	return null/**/;
    }
    
    public Iterator<AnyType> iterator(){
	    return new HeapIterator();
    }
    
    private void buildMinHeap(){
        for(int i = currentSize;i>1;i--){
            percolateDownMinHeap(i,currentSize);
        }
    }
    
    private void buildMaxHeap(){
        for(int i = currentSize;i>1;i--){
            percolateDownMaxHeap(i,currentSize-1);
        }
    }
    
    public boolean isEmpty(){
	    return currentSize == 0;
    }
    
    public int size(){
	    return currentSize;
    }
    @SuppressWarnings("unchecked")
    public void clear(){
	    currentSize = 0;
	    modifications = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing ){
	            return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 ){
	    swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 ){
	
    	AnyType tmp = array[ index1 ];
	    array[ index1 ] = array[ index2 ];
	    array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray(){
	    AnyType [ ] newArray;
	
	    newArray = (AnyType []) new Comparable[ array.length * 2 ];
	for( int i = 0; i < array.length; i++ )
	    newArray[ i ] = array[ i ];
	    array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size ){
	     percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    @SuppressWarnings("unchecked")
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing ) {

        if(!heapIndexing) { //recall the function with a well index heap array
            AnyType[] retval = (AnyType[]) new Comparable[array.length+1];
            for(int i =0;i<array.length;i++){
                retval[i+1] = array[i];
            }
            percolateDownMinHeap(retval,hole,size+1,true);
        }
        else{

        }
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size ){
	    percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing ) {
        //copy-pasta from min heap with small changes
        if(!heapIndexing) {
            AnyType[] retval = (AnyType[]) new Comparable[array.length+1];
            for(int i =0;i<array.length;i++){
                retval[i+1] = array[i];
            }
            percolateDownMaxHeap(retval,hole,size+1,true);
        }
        else{
            int parentIndex = hole/2;
            if(parentIndex == 0 ) return;
            if(array[parentIndex].compareTo(array[hole])<0) {
                swapReferences(array, parentIndex, hole);
                percolateDownMaxHeap(array, parentIndex, size, true);
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static <AnyType extends Comparable<? super AnyType>> void heapSort( AnyType[] a ) {
        if(a.length <= 1) return;
        AnyType[] array = (AnyType[]) new Comparable[a.length];

        int indexMax = 0;
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//COMPLETEZ
    }
    
    public String nonRecursivePrintFancyTree()
    {
	String outputString = "";
	
	//COMPLETEZ

	return outputString;
    }
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix) {
        String outputString = "";

        outputString = prefix + "|__";

        if( index <= currentSize )
        {
            boolean isLeaf = index > currentSize/2;

            outputString += array[ index ] + "\n";

            String _prefix = prefix;

            if( index%2 == 0 )
                _prefix += "|  "; // un | et trois espace
            else
                _prefix += "   " ; // quatre espaces

            if( !isLeaf ) {
                outputString += printFancyTree( 2*index, _prefix);
                outputString += printFancyTree( 2*index + 1, _prefix);
            }
        }
        else
            outputString += "null\n";

        return outputString;
    }
    
    private class HeapIterator implements Iterator {
	
	public boolean hasNext() {
	    //COMPLETEZ
            return false/**/;
	}

	public Object next() throws NoSuchElementException, 
				    ConcurrentModificationException, 
				    UnsupportedOperationException {
	    //COMPLETEZ
		return null/**/;
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

}
