package dataStructures.tanenbaum;
class BinaryNode<T>
{
	T value;
	BinaryNode<T> leftChild;
	BinaryNode<T> rightChild;
	
	//just print Tokens constans
	public String sb = " [ ";
	public String eb = " ] ";
	public String pipe = " || ";
	public String arrow = " -> ";
	
	public String toString()
	{
		StringBuffer outputString = new StringBuffer(sb);
		outputString.append("root value "+arrow+value);
		outputString.append(pipe);
		outputString.append("leftChild"+arrow+leftChild);
		outputString.append(pipe);
		outputString.append("rightChild"+arrow+rightChild);
		outputString.append(eb);
		return outputString.toString();
	}
	
	public void inOrderTraversal(BinaryNode<T> startWith, StringBuffer sb)
	{
		if (startWith == null)
		{
			 sb.append(pipe+"_");
			 return;
		}
		inOrderTraversal(startWith.leftChild,sb);
			sb.append(pipe+startWith.value);
		inOrderTraversal(startWith.rightChild,sb);
/*		
		StringBuffer outputString = new StringBuffer("INO "+arrow+sb);
		outputString.append("leftChild"+arrow+leftChild);
		outputString.append(pipe);
		outputString.append("root value "+arrow+value);
		outputString.append(pipe);
		outputString.append("rightChild"+arrow+rightChild);
		outputString.append(eb);
		return outputString.toString();
*/
	}
	
	public void preOrderTraversal(BinaryNode<T> startWith, StringBuffer sb)
	{
		if (startWith == null)
		{
			 sb.append(pipe+"_");
			 return;
		}
		sb.append(pipe+startWith.value);
		
		preOrderTraversal(startWith.leftChild,sb);
			
		preOrderTraversal(startWith.rightChild,sb);
		/*
		StringBuffer outputString = new StringBuffer("PRE  "+arrow+sb);
		outputString.append("root value "+arrow+value);
		outputString.append(pipe);
		outputString.append("leftChild"+arrow+leftChild);
		outputString.append(pipe);
		outputString.append("rightChild"+arrow+rightChild);
		outputString.append(eb);
		return outputString.toString();
		*/
	}
	
	public void postOrderTraversal(BinaryNode<T> startWith, StringBuffer sb)
	{
		if (startWith == null)
		{
			 sb.append(pipe+"_");
			 return;
		}
		
		
		postOrderTraversal(startWith.leftChild,sb);
			
		postOrderTraversal(startWith.rightChild,sb);
		
		sb.append(pipe+startWith.value);
		/*
		StringBuffer outputString = new StringBuffer("POST "+arrow+sb);
		outputString.append("leftChild"+arrow+leftChild);
		outputString.append(pipe);
		outputString.append("rightChild"+arrow+rightChild);
		outputString.append(pipe);
		outputString.append("root value "+arrow+value);
		outputString.append(eb);
		return outputString.toString(); */
	}
	
	public Boolean valueEqualsTo(T compareValue)
	{
		if(value != null)
			return value.equals(compareValue);
		
		return false;
	}
	
	public void addLeftChild(T leftChildValue)
	{
		if(leftChild == null)
			leftChild = new BinaryNode<T>();
		leftChild.value = leftChildValue;
		
	}
	
	public void addRightChild(T rightChildValue)
	{
		if(rightChild == null)
			rightChild = new BinaryNode<T>();
		rightChild.value = rightChildValue;
		
	}
	
	public BinaryNode<T> getNodeFromValue(T findValue)
	{
		return getNodeFromValue(findValue,this);
	}
	
	public BinaryNode<T> getNodeFromValue(T findValue, BinaryNode<T> startWith)
	{
		if (startWith == null)
			return null;
		
		if(startWith.valueEqualsTo(findValue))
			return startWith;
		
		BinaryNode<T> retVal = getNodeFromValue(findValue, startWith.leftChild);
		if(retVal != null)
			 return retVal;
			
		retVal = getNodeFromValue(findValue, startWith.rightChild);
		if(retVal != null)
			 return retVal;
		return null;
	}

	
	public void addLeftChild(T leftChildValue, T atNodeValue)
	{
		//traverse till node
		BinaryNode<T> nodeToAddAt = 
		getNodeFromValue(atNodeValue);
		
		if(nodeToAddAt!= null)
			nodeToAddAt.addLeftChild(leftChildValue);
		//add to leftchild
	}
	
	public void addRightChild(T rightChildValue, T atNodeValue)
	{
		//traverse till node
		BinaryNode<T> nodeToAddAt = 
		getNodeFromValue(atNodeValue);
		
		if(nodeToAddAt!= null)
			nodeToAddAt.addRightChild(rightChildValue);
		//add to right child
	}
}

class BinaryTree<T>
{
	BinaryNode<T> rootNode ;
	public BinaryNode<T> startWithRoot(T value)
	{
		rootNode  = new BinaryNode<T>();
		rootNode.value = value;
		return rootNode;
	}
	
	public String toString()
	{
		//String outputString = "[value -> "+rootNode.value+"]";
		System.out.println(rootNode);
		return "";
	}
	
	public void addLeftChild(T leftChildValue)
	{
		rootNode.addLeftChild(leftChildValue);
	}
	
	public void addRightChild(T rightChildValue)
	{
		rootNode.addRightChild(rightChildValue);
	}
	
	public void addLeftChild(T atNodeValue,T leftChildValue)
	{
		rootNode.addLeftChild(leftChildValue,atNodeValue);
	}
	
	public void addRightChild(T atNodeValue, T rightChildValue)
	{
		rootNode.addRightChild(rightChildValue,atNodeValue);
	}
	
	public StringBuffer inOrderTraversal()
	{
		StringBuffer sb = new StringBuffer("IN  "+rootNode.arrow);
		 rootNode.inOrderTraversal(rootNode,sb);
		 return sb;
	}
	
	public StringBuffer preOrderTraversal()
	{
		StringBuffer sb = new StringBuffer("PRE "+rootNode.arrow);
		rootNode.preOrderTraversal(rootNode,sb);
		return sb;
	}

	public StringBuffer postOrderTraversal()
	{
		StringBuffer sb = new StringBuffer("POST"+rootNode.arrow);
		rootNode.postOrderTraversal(rootNode,sb);
		return sb;
	}
	
	public BinaryNode<T> getNodeFromValue(T findValue)
	{
		return rootNode.getNodeFromValue(findValue);
	}
	
	public void addChild(T atNodeValue, String side ,T childValue)
	{
		if(side.toUpperCase().startsWith("R"))
			rootNode.addRightChild(childValue, atNodeValue);
		else
			rootNode.addLeftChild(childValue, atNodeValue);
	}
	
}
public class BinaryTree_Main {
	static String right = "R";
	static String left = "L";
	public static void main(String args[])
	{
		CharTreeExample();
		IntTreeExample();
		CharTreeExample2();
	}

	static void CharTreeExample()
	{
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
		
		//charTree.addLeftChild('F', 'x');
		//charTree.addRightChild('F', 'y');
		
		//StringBuffer sb = new StringBuffer();
		System.out.println(charTree.preOrderTraversal()+"\n");
		System.out.println(charTree.inOrderTraversal()+"\n");
		//System.out.println(sb);
		System.out.println(charTree.postOrderTraversal()+"\n");
		
	}
	
	static void CharTreeExample2()
	{
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

		System.out.println(charTree.preOrderTraversal()+"\n");
		System.out.println(charTree.inOrderTraversal()+"\n");
		//System.out.println(sb);
		System.out.println(charTree.postOrderTraversal()+"\n");
		
	}
	
	
	static void IntTreeExample()
	{
		BinaryTree<Integer> binaryTreeInteger = new BinaryTree<Integer>();
		binaryTreeInteger.startWithRoot(10);
		binaryTreeInteger.addLeftChild(5);
		binaryTreeInteger.addRightChild(15);
		System.out.println(binaryTreeInteger.preOrderTraversal());
		//System.out.println(binaryTreeInteger.getNodeFromValue(-1));
		binaryTreeInteger.addLeftChild(15, 14);
		System.out.println(binaryTreeInteger.preOrderTraversal());

		binaryTreeInteger.addRightChild(15, 17);
		System.out.println(binaryTreeInteger.preOrderTraversal());
	}
}
