package dataStructures.tanenbaum;

class BinaryNode<T> {
	// basic fields
	T value;
	BinaryNode<T> leftChild;
	BinaryNode<T> rightChild;

	// additional nodes
	BinaryNode<T> fatherNode;
	BinaryNode<T> siblingNode;

	// right threaded
	// True if right pointer points to predecessor
	// in Inorder Traversal
	boolean isRightThreadedNode = true;

	// True if left pointer points to predecessor
	// in Inorder Traversal
	boolean isLeftThreadedNode = true;

	// just print Tokens constans
	public String sb = " [ ";
	public String eb = " ] ";
	public String pipe = " || ";
	public String arrow = " -> ";

	public StringBuffer printInline(StringBuffer outputString) {
		if (outputString == null)
			outputString = new StringBuffer();
		outputString.append(sb);
		outputString.append("RooT " + arrow + value);
		outputString.append(pipe);
		if (leftChild != null)
			outputString.append("Lc" + arrow + leftChild.value);
		else
			outputString.append("Lc" + arrow + "_");
		outputString.append(pipe);

		if (rightChild != null)
			outputString.append("Rc" + arrow + rightChild.value);
		else
			outputString.append("Rc" + arrow + "_");

		outputString.append(pipe);

		if (fatherNode != null)
			outputString.append("Fn " + arrow + fatherNode.value);
		else
			outputString.append("Fn" + arrow + "_");
		outputString.append(pipe);

		if (siblingNode != null)
			outputString.append("Sn " + arrow + siblingNode.value);
		else
			outputString.append("Sn" + arrow + "_");
		outputString.append(pipe);
		if (isRightThreadedNode)
			outputString.append("Rt" + arrow + "Y");
		else
			outputString.append("Rt" + arrow + "N");
		outputString.append(eb);

		return outputString;
	}

	public String toString() {

		StringBuffer outputString = new StringBuffer();
		outputString.append(sb);
		outputString.append("RooT " + arrow + value);
		outputString.append(pipe);
		outputString.append("Lc" + arrow + leftChild);
		outputString.append(pipe);
		outputString.append("Rc" + arrow + rightChild);
		outputString.append(eb);

		return outputString.toString();
	}

	public void inOrderTraversal(BinaryNode<T> startWith, StringBuffer sb) {
		if (startWith == null) {
			sb.append(pipe + "_");
			return;
		}
		inOrderTraversal(startWith.leftChild, sb);
		sb.append(pipe + startWith.value);
		inOrderTraversal(startWith.rightChild, sb);
		/*
		 * StringBuffer outputString = new StringBuffer("INO "+arrow+sb);
		 * outputString.append("leftChild"+arrow+leftChild); outputString.append(pipe);
		 * outputString.append("root value "+arrow+value); outputString.append(pipe);
		 * outputString.append("rightChild"+arrow+rightChild); outputString.append(eb);
		 * return outputString.toString();
		 */
	}

	public void preOrderPrintAll(BinaryNode<T> startWith, StringBuffer sb) {
		if (startWith == null) {
			sb.append(pipe + "_");
			return;
		}
		sb.append(startWith.printInline(sb) + "\n");

		preOrderPrintAll(startWith.leftChild, sb);

		preOrderPrintAll(startWith.rightChild, sb);
	}

	public void preOrderTraversal(BinaryNode<T> startWith, StringBuffer sb) {
		if (startWith == null) {
			sb.append(pipe + "_");
			return;
		}
		sb.append(pipe + startWith.value);

		preOrderTraversal(startWith.leftChild, sb);

		preOrderTraversal(startWith.rightChild, sb);
		/*
		 * StringBuffer outputString = new StringBuffer("PRE  "+arrow+sb);
		 * outputString.append("root value "+arrow+value); outputString.append(pipe);
		 * outputString.append("leftChild"+arrow+leftChild); outputString.append(pipe);
		 * outputString.append("rightChild"+arrow+rightChild); outputString.append(eb);
		 * return outputString.toString();
		 */
	}

	public void postOrderTraversal(BinaryNode<T> startWith, StringBuffer sb) {
		if (startWith == null) {
			sb.append(pipe + "_");
			return;
		}

		postOrderTraversal(startWith.leftChild, sb);

		postOrderTraversal(startWith.rightChild, sb);

		sb.append(pipe + startWith.value);
		/*
		 * StringBuffer outputString = new StringBuffer("POST "+arrow+sb);
		 * outputString.append("leftChild"+arrow+leftChild); outputString.append(pipe);
		 * outputString.append("rightChild"+arrow+rightChild);
		 * outputString.append(pipe); outputString.append("root value "+arrow+value);
		 * outputString.append(eb); return outputString.toString();
		 */
	}

	public Boolean valueEqualsTo(T compareValue) {
		if (value != null)
			return value.equals(compareValue);

		return false;
	}

	public BinaryNode<T> addLeftChild(T leftChildValue) {
		if (leftChild == null)
			leftChild = new BinaryNode<T>();
		leftChild.value = leftChildValue;
		return leftChild;

	}

	public BinaryNode<T> addRightChild(T rightChildValue) {
		if (rightChild == null)
			rightChild = new BinaryNode<T>();
		rightChild.value = rightChildValue;
		return rightChild;
	}

	public BinaryNode<T> getNodeFromValue(T findValue) {
		return getNodeFromValue(findValue, this);
	}

	public BinaryNode<T> getNodeFromValue(T findValue, BinaryNode<T> startWith) {
		if (startWith == null)
			return null;

		if (startWith.valueEqualsTo(findValue))
			return startWith;

		BinaryNode<T> retVal = getNodeFromValue(findValue, startWith.leftChild);
		if (retVal != null)
			return retVal;

		retVal = getNodeFromValue(findValue, startWith.rightChild);
		if (retVal != null)
			return retVal;

		return null;
	}

	public BinaryNode<T> addLeftChild(T leftChildValue, T atNodeValue) {
		// traverse till node
		BinaryNode<T> nodeToAddAt = getNodeFromValue(atNodeValue);

		if (nodeToAddAt != null) {
			nodeToAddAt.addLeftChild(leftChildValue);
			nodeToAddAt.leftChild.fatherNode = nodeToAddAt;
			nodeToAddAt.leftChild.siblingNode = nodeToAddAt.rightChild;
			System.out.println("Left Child Added at " + atNodeValue);
			System.out.println(nodeToAddAt.leftChild.printInline(null));

			// added for threaded nodes in btree
			// new node left child = parent left child
			nodeToAddAt.leftChild.leftChild = nodeToAddAt.leftChild;

			// new node right child = parent
			nodeToAddAt.leftChild.rightChild = nodeToAddAt;
			nodeToAddAt.isLeftThreadedNode = false;

			return nodeToAddAt.leftChild;
		}
		// add to leftchild
		System.out.println("atNodeValue not found for " + atNodeValue);
		return null;

	}

	public BinaryNode<T> addRightChild(T rightChildValue, T atNodeValue) {
		// traverse till node
		BinaryNode<T> nodeToAddAt = getNodeFromValue(atNodeValue);

		if (nodeToAddAt != null) {
			nodeToAddAt.addRightChild(rightChildValue);
			nodeToAddAt.rightChild.fatherNode = nodeToAddAt;
			nodeToAddAt.rightChild.siblingNode = nodeToAddAt.leftChild;
			System.out.println("Right Child Added at " + atNodeValue);
			System.out.println(nodeToAddAt.rightChild.printInline(null));

			nodeToAddAt.rightChild.leftChild = nodeToAddAt;
			nodeToAddAt.rightChild.rightChild = nodeToAddAt.rightChild;
			nodeToAddAt.isRightThreadedNode = false;

			return nodeToAddAt.rightChild;
		}
		System.out.println("atNodeValue not found for" + atNodeValue);
		return null;

		// add to right child
	}
}

class BinaryTree<T> {
	BinaryNode<T> rootNode;

	public BinaryNode<T> startWithRoot(T value) {
		rootNode = new BinaryNode<T>();
		rootNode.value = value;
		rootNode.fatherNode = null;
		rootNode.siblingNode = null;
		return rootNode;
	}

	public String toString() {
		// String outputString = "[value -> "+rootNode.value+"]";
		System.out.println(rootNode);
		return "";
	}

	public void addLeftChild(T leftChildValue) {
		rootNode.addLeftChild(leftChildValue);
	}

	public void addRightChild(T rightChildValue) {
		rootNode.addRightChild(rightChildValue);
	}

	public void addLeftChild(T atNodeValue, T leftChildValue) {
		rootNode.addLeftChild(leftChildValue, atNodeValue);
	}

	public void addRightChild(T atNodeValue, T rightChildValue) {
		rootNode.addRightChild(rightChildValue, atNodeValue);
	}

	public StringBuffer inOrderTraversal() {
		StringBuffer sb = new StringBuffer("IN  " + rootNode.arrow);
		rootNode.inOrderTraversal(rootNode, sb);
		return sb;
	}

	public StringBuffer preOrderTraversalPrintAll() {
		StringBuffer sb = new StringBuffer("PRE " + rootNode.arrow);
		rootNode.preOrderPrintAll(rootNode, sb);
		return sb;
	}

	public StringBuffer preOrderTraversal() {
		StringBuffer sb = new StringBuffer("PRE " + rootNode.arrow);
		rootNode.preOrderTraversal(rootNode, sb);
		return sb;
	}

	public StringBuffer postOrderTraversal() {
		StringBuffer sb = new StringBuffer("POST" + rootNode.arrow);
		rootNode.postOrderTraversal(rootNode, sb);
		return sb;
	}

	public BinaryNode<T> getNodeFromValue(T findValue) {
		return rootNode.getNodeFromValue(findValue);
	}

	public void addChild(T atNodeValue, Boolean rightSide, T childValue) {
		if (rightSide)
			rootNode.addRightChild(childValue, atNodeValue);
		else
			rootNode.addLeftChild(childValue, atNodeValue);
	}

	public StringBuffer inlinePrint() {
		StringBuffer sb = new StringBuffer("InLine" + rootNode.arrow);
		rootNode.printInline(sb);
		return sb;
	}

}

public class BinaryTree_Main {
	static Boolean right = true;
	static Boolean left = false;

	public static void main(String args[]) {
		CharTreeExample();
		// IntTreeExample();
		// CharTreeExample2();
	}

	static void CharTreeExample() {
		BinaryTree<Character> charTree = new BinaryTree<Character>();
		charTree.startWithRoot('A');
		charTree.addLeftChild('A', 'B');
		charTree.addRightChild('A', 'C');
		charTree.addLeftChild('B', 'D');
		charTree.addRightChild('D', 'G');

		charTree.addLeftChild('C', 'E');
		charTree.addRightChild('C', 'F');

		charTree.addLeftChild('E', 'H');
		charTree.addRightChild('E', 'I');

		// charTree.addLeftChild('F', 'x');
		// charTree.addRightChild('F', 'y');
		/*
		 * //StringBuffer sb = new StringBuffer();
		 * System.out.println(charTree.preOrderTraversal()+"\n");
		 * System.out.println(charTree.inOrderTraversal()+"\n");
		 * //System.out.println(sb);
		 * System.out.println(charTree.postOrderTraversal()+"\n");
		 */
		System.out.println(charTree.inlinePrint());

		System.out.println(charTree.preOrderTraversalPrintAll());

	}

	static void CharTreeExample2() {
		BinaryTree<Character> charTree = new BinaryTree<Character>();
		charTree.startWithRoot('A');
		charTree.addChild('A', left, 'B');
		charTree.addChild('B', left, 'C');
		charTree.addChild('C', left, 'E');
		charTree.addChild('E', right, 'I');

		charTree.addChild('C', right, 'F');
		charTree.addChild('F', right, 'J');

		charTree.addChild('B', right, 'D');
		charTree.addChild('D', left, 'G');
		charTree.addChild('D', right, 'H');

		charTree.addChild('H', left, 'K');
		charTree.addChild('H', right, 'L');

		System.out.println(charTree.preOrderTraversal() + "\n");
		System.out.println(charTree.inOrderTraversal() + "\n");
		// System.out.println(sb);
		System.out.println(charTree.postOrderTraversal() + "\n");

	}

	static void IntTreeExample() {
		BinaryTree<Integer> binaryTreeInteger = new BinaryTree<Integer>();
		binaryTreeInteger.startWithRoot(10);
		binaryTreeInteger.addLeftChild(5);
		binaryTreeInteger.addRightChild(15);
		System.out.println(binaryTreeInteger.preOrderTraversal());
		// System.out.println(binaryTreeInteger.getNodeFromValue(-1));
		binaryTreeInteger.addLeftChild(15, 14);
		System.out.println(binaryTreeInteger.preOrderTraversal());

		binaryTreeInteger.addRightChild(15, 17);
		System.out.println(binaryTreeInteger.preOrderTraversal());
	}
}
