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
		//done
		if(min)
			buildMinHeap();
		else
			buildMaxHeap();Ù
	    // invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
    }
    
    public boolean offer( AnyType x ){
	    if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	    if( currentSize + 1 == array.length )
	    doubleArray();

		//commencer par inserer x a la fin
	    currentSize++;
		int j=currentSize-1;
	   array[j]=x;

		if (min) { //A REVOIR
			while (j != 0 && array[(j - 1) / 2] > array[j]) {

				AnyType temp = arr[j];
				arr[j] = arr[(j - 1) / 2];
    		& arr[(j - 1) / 2] = temp;
				j = (j - 1) / 2;
			}
		}
		else
		{
			while (j != 0 && array[(j - 1) / 2] < array[j]) {

				AnyType temp = arr[j];
				arr[j] = arr[(j - 1) / 2];
    		&arr[(j - 1) / 2] = temp;
				j = (j - 1) / 2;

		}
	    modifications++;



	
	    return true;
    }
    
    public AnyType peek(){
	    if(!isEmpty())
	    return array[1];
	
	    return null;
    }
    
    public AnyType poll(){
		AnyType copyRoot= peek();

			//le root devient le dernier élément
		array[1]=array[currentSize-1];
		currentSize--;
		if(min)
			buildMinHeap(); // percolate?

		else
			buildMaxHeap(); //o



    	return copyRoot;
    }
    
    public Iterator<AnyType> iterator(){
	    return new HeapIterator();
    }
    
    private void buildMinHeap(){

			for( int j = currentSize / 2; j > 0; i-- )
				percolateDownMinHeap(j, currentSize);
    }
    
    private void buildMaxHeap(){

		for (int j=(currentSize)/2; i>0; i--)
		{
			perlocateDownMaxHeap(j, currentSize);
		}
    }
    
    public boolean isEmpty(){
	    return currentSize == 0;
    }
    
    public int size(){
	    return currentSize;
    }
    
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
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    { //done
		int child;

		AnyType tmp = array[hole];

		for (; hole * 2 <= currentSize; hole = child) {


			child = hole * 2;

			if (child != currentSize && // deux fils
					array[child + 1].compareTo(array[child]) < 0)
				child++; //fils droit

			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];

			break;

		}
		array[ hole ] = tmp;
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
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
		int child;

		AnyType tmp = array[hole];

		for (; hole * 2 <= currentSize; hole = child) {


			child = hole * 2;

			if (child != currentSize &&
					array[child + 1].compareTo(array[child]) >0)
				child++;

			if (array[child].compareTo(tmp) >0)
				array[hole] = array[child];

			break;

		}
		array[ hole ] = tmp;
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    { //done

		for( int i = a.length / 2; i >= 0; i-- )  {
			percolateDownMaxHeap(a, i, a.length, false);
		}

		for( int i = a.length - 1; i > 0; i-- ) {
			swapReferences( a, 0, i );

			percolateDownMaxHeap( a, 0, i, false );

		}
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//DONE
		for( int i = a.length / 2; i >= 0; i-- ){
			percolateDownMinHeap(a, i, a.length, false);
		}

		for( int i = a.length - 1; i > 0; i-- ) {
			swapReferences( a, 0, i );

			percolateDownMinHeap( a, 0, i, false );

		}

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
    
    private String printFancyTree( int index, String prefix)
    {
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
		if (this.index  <= currentSize)
			return true;
		return false;
	}

	public Object next() throws NoSuchElementException, 
				    ConcurrentModificationException, 
				    UnsupportedOperationException {
		if (hasNext()!=true)
			throw  new UnsupportedOperationException();
		else if() // suite
	}
	    //COMPLETEZ
		return null/**/;
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}
