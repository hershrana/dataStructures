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
	
	public String inOrderTraversal()
	{
		StringBuffer outputString = new StringBuffer(sb);
		outputString.append("leftChild"+arrow+leftChild);
		outputString.append(pipe);
		outputString.append("root value "+arrow+value);
		outputString.append(pipe);
		outputString.append("rightChild"+arrow+rightChild);
		outputString.append(eb);
		return outputString.toString();
	}
	
	public String preOrderTraversal()
	{
		StringBuffer outputString = new StringBuffer("PRE "+arrow+sb);
		outputString.append("root value "+arrow+value);
		outputString.append(pipe);
		outputString.append("leftChild"+arrow+leftChild);
		outputString.append(pipe);
		outputString.append("rightChild"+arrow+rightChild);
		outputString.append(eb);
		return outputString.toString();
	}
	
	public String postOrderTraversal()
	{
		StringBuffer outputString = new StringBuffer(sb);
		outputString.append("leftChild"+arrow+leftChild);
		outputString.append(pipe);
		outputString.append("rightChild"+arrow+rightChild);
		outputString.append(pipe);
		outputString.append("root value "+arrow+value);
		outputString.append(eb);
		return outputString.toString();
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

class BinaryTree<DataType>
{
	BinaryNode<DataType> rootNode ;
	public BinaryNode<DataType> startWithRoot(DataType value)
	{
		rootNode  = new BinaryNode<DataType>();
		rootNode.value = value;
		return rootNode;
	}
	
	public String toString()
	{
		//String outputString = "[value -> "+rootNode.value+"]";
		System.out.println(rootNode);
		return "";
	}
	
	public void addLeftChild(DataType leftChildValue)
	{
		rootNode.addLeftChild(leftChildValue);
	}
	
	public void addRightChild(DataType rightChildValue)
	{
		rootNode.addRightChild(rightChildValue);
	}
	
	public void addLeftChild(DataType leftChildValue, DataType atNodeValue)
	{
		rootNode.addLeftChild(leftChildValue);
	}
	
	public void addRightChild(DataType rightChildValue, DataType atNodeValue)
	{
		rootNode.addRightChild(rightChildValue);
	}
	
	public String inOrderTraversal()
	{
		return rootNode.inOrderTraversal();
	}
	
	public String preOrderTraversal()
	{
		return rootNode.preOrderTraversal();
	}
	
	public String postOrderTraversal()
	{
		return rootNode.postOrderTraversal();
	}
	
}
public class BinaryTree_Main {
	
	public static void main(String args[])
	{
		BinaryTree<Integer> binaryTreeInteger = new BinaryTree<Integer>();
		binaryTreeInteger.startWithRoot(10);
		binaryTreeInteger.addLeftChild(5);
		binaryTreeInteger.addRightChild(15);
		System.out.println(binaryTreeInteger.preOrderTraversal());
		binaryTreeInteger.addLeftChild(10,1);
		System.out.println(binaryTreeInteger.preOrderTraversal());
	}

}
