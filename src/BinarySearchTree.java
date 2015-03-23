public class BinarySearchTree <E extends Comparable <E>>
        extends BinaryTree <E> implements SearchTree <E> {
   // this version uses iteration instead of recursion in search,
   // insert and delete

   // denotes whether the addition is successful
   // protected boolean addReturn;

   // denotes whether the deletion is successful
   // protected boolean deleteReturn;

   /**
     Constructor - initializes the tree to an empty tree
     */
   public BinarySearchTree () {
      super() ;
   }

   public BinarySearchTree(E data, BinarySearchTree <E> left,
          BinarySearchTree <E> right)  {
	   super(data, left, right);
   }

   /**
     Searches for a given element in the binary search tree
     @param
        someElement element to be searched
     @return
        true - if someElement is found in the tree; false
                  otherwise
     */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public boolean contains( E someElement) {
	   if(root == null)return false;      // empty tree
	   else return contains(root, someElement);
   }

   /**
   Searches for a given element in the binary search tree
   @param
      someElement element to be searched
   @param node root of the tree
   @return
      true - if someElement is found in the tree; false
                otherwise
   */
   private boolean contains(Node<E> node, E someElement){
	   if(someElement.compareTo(node.data) == 0)
		   return true;
	   if(someElement.compareTo(node.data) < 0 && node.left != null)
		   return contains(node.left, someElement);
	   if(someElement.compareTo(node.data)> 0 && node.left != null)
		   return contains(node.right, someElement);
	   else return false;
   }

   /**
     Searches for a given element in the binary search tree
     @param
           someElement element to be searched
     @return
           E - if someElement is found in the tree; null
                     otherwise
    */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public E find (E someElement, IntObject count) {
      return find(root, someElement, count);
    }
   
   /**
    * Searches for a given element in the binary search tree
    * @param node local root of the tree
    * @param someElement element to be searched
    * @param count amount of nodes searched for the element
    * @return E - if someElement is found; null otherwise
    */
   private E find(Node<E> node, E someElement, IntObject count){
	   if(node == null)
		   return null;
	   int compValue = someElement.compareTo(node.data);
	   if(compValue < 0){
		   count.setData(count.getData() + 1);
		   return find(node.left, someElement, count);
	   }
	   if(compValue > 0){
		   count.setData(count.getData() + 1);
		   return find(node.right, someElement, count);
	   }
	   else{
		   count.setData(count.getData() + 1);
		   return node.data;
	   }
   }

    /**
     inserts an element into a BST
     @param
        someElement element that needs to be inserted
     @param
        count keeps track of the number of comparisons
        done for this insert
     @return true if the insertion is successful, false otherwise
     */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public boolean add(E someElement) {
	   if(root == null){
		   root = new Node<E> (someElement);  // tree is empty so inserted at the root
		   return true;
	   }
	   else return add(root, someElement);
   }

   /**
    * inserts an element into a BST
    * @param node root of the tree
    * @param someElement element to be inserted
    * @return true if inserted; false if element is already in the tree
    */
   private boolean add(Node<E> node, E someElement){
	   if (someElement.compareTo(node.data) < 0){
		   if (node.left == null){
			  node.left = new Node<E>(someElement); 
			  return true;
		   }
		   else return add(node.left, someElement);
	   }
	   if (someElement.compareTo(node.data) > 0){
		   if (node.right == null){
			   node.right = new Node<E>(someElement);
			   return true;
		   }
		   else return add(node.right, someElement);
	   }
	   else return false; //element already in tree
   }

   /**
     removes an element from a BST
     @param
       someElement element that needs to be deleted
     @return
	    returns true if someElement is found in the tree and is
	    successfully deleted; returns false if someElement is
        not found in the tree.
    */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public boolean remove(E someElement) {
	   if(delete(someElement) == null)
		   return false;
	   else return true;
   }

   /** @return the minimum element in the Set */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)


   public E first() {
	   if(root == null) return null;    //empty tree
	   else return root.getLeftMostData();	   
   }

   /** @return the maximum element in the Set */
   // Complexity: O(h) - where h is the height of the tree.
   // In the worst case it could be O(n).  But on aveage
   // we can expect a complexity of O(log n)
   public E last() {
	   if(root == null)return null;        //empty tree
	   else return root.getRightMostData();
   }

   /**
    * Deletes an element from the tree
    * @param 
    * 	someElement element to be deleted from the tree
    * @return
    * 	returns the element that was deleted from the tree, or null if
    * 	the element isn't in the tree or tree is empty.
    */
   public E delete(E someElement) {
	   root = delete(root, someElement);
	   return someElement;
   }
   
   /**
    * Deletes an element from the tree
    * @param node the node to start at or the local root
    * @param someElement element to be deleted from the tree
    * @return the tree with the element removed
    */
   private Node<E> delete(Node<E> node, E someElement){
	   if(node == null){		//element not in the tree
		   someElement = null;
		   return node;
	   }
	  if(someElement.compareTo(node.data) == 0){ // element is at the local root
		   if(node.left == null)	//node has a right child or no children
			   return node.right;
		   if(node.right == null)	// node only has a left child
			   return node.left;
		   else{	//node has two children
			   node.data = node.left.getRightMostData(); //sets the node data to the highest value of the left sub tree
			   node.left = node.left.removeRightMost();  //removes the highest value of the left sub tree
		   }
	   }else{
		   if(someElement.compareTo(node.data) < 0)
			   node.left = delete(node.left, someElement); //element is less than the local root
		   else
			   node.right = delete(node.right, someElement); //element is larger than the local root
	   }
	   return node;   
   }
}

