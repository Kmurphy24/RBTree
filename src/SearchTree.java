public interface SearchTree <E> {
   /** inserts item where it belongs in the tree;
       Returns true if item is inserted; false if the
       item is not inserted (it is already in the tree)
     */
   public boolean add(E item);

   /**
     Returns true if target is found in the tree
    */
   public boolean contains(E target);

   /** Returns a reference to the data in the node
       that is equal to target.  If no such node is
       found, returns null. count holds the number of
       comparisons done for this search
     */
   public E find (E target, IntObject count);

   /** Removes target (if found) from tree and returns
       it; otherwise, returns null
     */
   public E delete(E item);

   /** Removes target (if found) from tree and returns true;
       otherwise, returns false.
     */
  public boolean remove(E item);

} // end SearchTreeInterface
