public class RBTree<E extends Comparable<E>> extends
		BinarySearchTreeWithRotate<E> {
	public boolean addReturn;

	public static class RBNode<E> extends Node<E> {
		private boolean isRed;

		public RBNode(E item) {
			super(item);
			isRed = true;
		}

		@Override
		public String toString() {
			if (isRed)
				return "Red : " + super.toString();
			else
				return "Black : " + super.toString();
		}
	}

	public boolean add(E item) {
		if (root == null) {
			root = new RBNode<E>(item);
			((RBNode<E>) root).isRed = false;
			return true;
		} else {
			root = add((RBNode<E>) root, item);
			((RBNode<E>) root).isRed = false;
			return addReturn;
		}
	}

	private Node<E> add(RBNode<E> localRoot, E item) {
		addReturn = true;
		if (item.compareTo(localRoot.data) < 0) {
			if (localRoot.left == null) {
				localRoot.left = new RBNode<E>(item);
				return localRoot;
			} else {
				moveBlackDown(localRoot);
				localRoot.left = add((RBNode<E>) localRoot.left, item);
				if (((RBNode<E>) localRoot.left).isRed) {
					if (localRoot.left.left != null
							&& ((RBNode<E>) localRoot.left.left).isRed) {
						((RBNode<E>) localRoot.left).isRed = false;
						localRoot.isRed = true;
						return rotateRight(localRoot);
					} else if (localRoot.left.right != null
							&& ((RBNode<E>) localRoot.left.right).isRed) {
						localRoot.left = rotateLeft(localRoot.left);
						((RBNode<E>) localRoot.left).isRed = false;
						localRoot.isRed = true;
						return rotateRight(localRoot);
					}
				}
				return localRoot;
			}
		}
		else if (item.compareTo(localRoot.data) > 0) {
			if (localRoot.right == null) {
				localRoot.right = new RBNode<E>(item);
				return localRoot;
			} else {
				moveBlackDown(localRoot);
				localRoot.right = add((RBNode<E>) localRoot.right, item);
				if (((RBNode<E>) localRoot.right).isRed) {
					if (localRoot.right.right != null
							&& ((RBNode<E>) localRoot.right.right).isRed) {
						((RBNode<E>) localRoot.right).isRed = false;
						localRoot.isRed = true;
						return rotateLeft(localRoot);
					} else if (localRoot.right.left != null
							&& ((RBNode<E>) localRoot.right.left).isRed) {
						localRoot.right = rotateRight(localRoot.right);
						((RBNode<E>) localRoot.right).isRed = false;
						localRoot.isRed = true;
						return rotateLeft(localRoot);
					}
				}
				return localRoot;
			}
		}
		else{
			addReturn = false;
			return localRoot;
		}
	}

	private void moveBlackDown(RBNode<E> localRoot){
		if(localRoot.left != null && localRoot.right != null){
		if (((RBNode<E>) localRoot.left).isRed && ((RBNode<E>) localRoot.right).isRed) {
			((RBNode<E>) localRoot.left).isRed = false;
			((RBNode<E>) localRoot.right).isRed = false;
			((RBNode<E>) localRoot).isRed = true;
		}}
	}
}