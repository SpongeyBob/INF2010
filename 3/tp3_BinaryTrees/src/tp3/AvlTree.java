package tp3;

import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class AvlTree<ValueType extends Comparable<? super ValueType> > {

    private BinaryNode<ValueType> root;

    public AvlTree() { }

    /**
     * Adds value to the tree and keeps it as a balanced AVL Tree
     * @param value value to add to the tree
     */
    public void insert(ValueType value) {
        if (root == null) {
            root = new BinaryNode<ValueType>(value, null);
        } else {
            insert(value, root);
        }
    }

    /**
     * Removes value from the tree and keeps it as a balanced AVL Tree
     * @param value value to add to the tree
     */
    public void remove(ValueType value){
        remove(value, root);
    }

    /**
     * Verifies if the tree contains value
     * @param value value to verify
     * @return if value already exists in the tree
     */
    public boolean contains(ValueType value) {
        return contains(value, root);
    }

    /**
     * Returns the max level contained in our root tree
     * @return Max level contained in our root tree
     */
    public int getHeight() {
        return getLevelCount(root) - 1;
    }

    /**
     * Returns the minimal value contained in our root tree
     * @return Minimal value contained in our root tree
     */
    public ValueType findMin() {
        BinaryNode<ValueType> minimalNode = findMin(root);
        if (minimalNode == null) return null;
        return minimalNode.value;
    }

    /**
     * Returns all values contained in the root tree in ascending order
     * @return Values contained in the root tree in ascending order
     */
    public List<ValueType> infixOrder() {
        List<ValueType> items = new LinkedList<ValueType>();
        infixOrder(root, items);
        return items;
    }

    /**
     * Returns all values contained in the root tree in level order from top to bottom
     * @return Values contained in the root tree in level order from top to bottom
     */
    public List<ValueType> levelOrder(){
        List<ValueType> items = new LinkedList<ValueType>();

        ArrayDeque<BinaryNode<ValueType>> nodesToCheck = new ArrayDeque<BinaryNode<ValueType>>();

        if (root != null){
            nodesToCheck.push(root);
            levelOrder(nodesToCheck, items);
        }

        return items;
    }

    /** TODO O -- DONE
     * Adds value to the tree and keeps it as a balanced AVL Tree
     * Should call balance only if insertion succeeds
     * AVL Trees do not contain duplicates
     *
     * @param value value to add to the tree
     * @param currentNode Node currently being accessed in this recursive method
     * @return if parent node should balance
     */
    private boolean insert (ValueType value, BinaryNode<ValueType> currentNode){
        if(value == null) return false;
        if(currentNode== null ) return false;

        if(currentNode.value.compareTo(value)==0) return false;
        if(currentNode.value.compareTo(value) < 0 ) {//node < value
            if(currentNode.right == null){
                currentNode.right = new BinaryNode<>(value,currentNode);
                balance(currentNode.parent);
                return true;
            }
            return insert(value,currentNode.right);

        }
        else{
            if(currentNode.left == null){
                currentNode.left = new BinaryNode<>(value,currentNode);
                balance(currentNode.parent);
                return true;
            }
            return insert(value,currentNode.left);

        }
    }

    /** TODO O ( log n ) -- DONE
     * Removes value from the tree and keeps it as a balanced AVL Tree
     * Should call balance only if removal succeeds
     * @param value value to remove from the tree
     * @param currentNode Node currently being accessed in this recursive method
     * @return if parent node should balance
     */
    private boolean remove(ValueType value, BinaryNode<ValueType> currentNode) {

        if(currentNode == null) return false; //not found
        int compareResult = value.compareTo(currentNode.value);
        
        if(compareResult == 0){ //found

            if(currentNode.left != null && currentNode.right != null) { //2 children

                currentNode.value = findMin(currentNode.right).value;
                remove(currentNode.value, currentNode.right);
            }
            else{
                currentNode = (currentNode.right != null) ? currentNode.right : currentNode.left;
            }
            balance(root);
            return true;
        }
        else if(compareResult < 0) return remove(value,currentNode.left);
        else return remove(value,currentNode.right);
    }

    /** TODO O( n ) -- Rania
     * Balances the subTree
     * @param subTree SubTree currently being accessed to verify if it respects the AVL balancing rule
     */
    private void balance(BinaryNode<ValueType> subTree) {

        //break recursion
        if(subTree==null) return;
        //check if rotations needed
        int height = getLevelCount(subTree.left) - getLevelCount(subTree.right);
        if(height >= -1 && height <= 1) { //respect AVL rules
            balance(subTree.left);
            balance(subTree.right);
        }
        if(height > 1){ // left bigger than right
            if(getLevelCount(subTree.left.left) > getLevelCount(subTree.left.right)) //left-left
                rotateLeft(subTree);
            else    //left-right
                doubleRotateOnLeftChild(subTree);
        }
        else if(height < -1 ){ //right bigger than left
            if(getLevelCount(subTree.right.right)> getLevelCount(subTree.right.left)) // right-right
                rotateRight(subTree);
            else //right-left
                doubleRotateOnRightChild(subTree);
        }

    }

    /** TODO O( 1 )-- Rania
     * Single rotation to the left child, AVR Algorithm
     * @param node1 Node to become child of its left child
     */
    private void rotateLeft(BinaryNode<ValueType> node1) {
        BinaryNode<ValueType> node = node1.left;
        node1.left = node.right;
        node.right = node1;
        BinaryNode<ValueType> parent=node1.parent;
        node.parent = parent;
        if (node1.parent != null) {
            if (node1.parent.left == node1) node1.parent.left = node;
            else node1.parent.right = node;
        }
        node1.parent = node;
        if (node1.value.equals(root.value)) root = node;
    }

    /** TODO O( 1 ) -- Rania
     * Single rotation to the right, AVR Algorithm
     * @param node1 Node to become child of its right child
     */
    private void rotateRight(BinaryNode<ValueType> node1) {

        BinaryNode<ValueType> node = node1.right;
        node1.right = node.left;
        node.left = node1;

        node.parent = node1.parent;
        if(node1.parent!=null) {
            if (node1.parent.right == node1) node1.parent.right = node;
            else node1.parent.left = node;
        }
        node1.parent = node;
        if(node1.value.equals(root.value)) root = node;

    }

    /** TODO O( 1 ) -- Rania
     * Double rotation on left child, AVR Algorithm
     * @param node1 Node to become child of the right child of its left child
     */
    private void doubleRotateOnLeftChild(BinaryNode<ValueType> node1){
        rotateRight(node1.left);
        rotateLeft(node1);

    }


    /** TODO O( 1 ) -- Rania
     * Double rotation on right child, AVR Algorithm
     * @param node1 Node to become child of the left child of its right child
     */
    private void doubleRotateOnRightChild(BinaryNode<ValueType> node1) {
        rotateLeft(node1.right);
        rotateRight(node1);
    }

    /** TODO O( log n ) -- DONE
     * Verifies if the root tree contains value
     * @param value value to verify
     * @param currentNode Node currently being accessed in this recursive method
     * @return if value already exists in the root tree
     */
    private boolean contains(ValueType value, BinaryNode<ValueType> currentNode){
        if(currentNode == null) return false;

        int compareResult = value.compareTo(currentNode.value);

        if(compareResult<0) return contains(value,currentNode.left);
        if(compareResult>0) return contains(value,currentNode.right);
        else return true;
    }

    /** TODO O( n ) -- DONE
     * Returns the number of level contained in subTree including subTree node level
     * @return Number of level contained in subTree including subTree node level
     */
    private int getLevelCount(BinaryNode<ValueType> subTree){
        if(subTree==null) return 0;
        int levelRight =0,
            levelLeft = 0;
        levelRight = getLevelCount(subTree.right)+ 1;
        levelLeft = getLevelCount(subTree.left) + 1 ;
        return Integer.max(levelLeft,levelRight);

    }

    /** TODO O( log n ) -- DONE
     * Returns the node which has the minimal value contained in our root tree
     * @return Node which has the minimal value contained in our root tree
     */
    private BinaryNode<ValueType> findMin(BinaryNode<ValueType> currentNode) {
        if(currentNode == null) return null;
        if(currentNode.left == null) return currentNode;
        else return findMin(currentNode.left);
    }

    /** TODO O( n ) -- DONE
     * Builds items which should contain all values within the root tree in ascending order
     * @param currentNode Node currently being accessed in this recursive method
     * @param items List being modified to contain all values in the root tree in ascending order
     */
    private void infixOrder(BinaryNode<ValueType> currentNode, List<ValueType> items){
        if(currentNode.left != null)  infixOrder(currentNode.left,items);
        items.add(currentNode.value);
        if(currentNode.right != null) infixOrder(currentNode.right,items);
    }

    /** TODO O( n ) -- DONE
     * Builds items which should contain all values within the root tree in level order from top to bottom
     * @param nodesToCheck Queue for non-recursive algorithm
     * @param items List being modified to contain all values in the root tree in level order from top to bottom
     */
    private void levelOrder(ArrayDeque<BinaryNode<ValueType>> nodesToCheck, List<ValueType> items) {
        BinaryNode<ValueType> currentNode;
        while(!nodesToCheck.isEmpty()){
            currentNode = nodesToCheck.pollFirst();
            items.add(currentNode.value);
            if(currentNode.left != null)
                nodesToCheck.addLast(currentNode.left);
            if(currentNode.right != null)
                nodesToCheck.addLast(currentNode.right);
        }

    }
    
    static class BinaryNode<ValueType> {
        ValueType value;

        BinaryNode<ValueType> parent; // Pointer to the node containing this node

        BinaryNode<ValueType> left = null; // Pointer to the node on the left which should contain a value below this.value
        BinaryNode<ValueType> right = null; // Pointer to the node on the right which should contain a value above this.value

        BinaryNode(ValueType value, BinaryNode<ValueType> parent)
        {
            this.value = value;
            this.parent = parent;
        }
    }
}