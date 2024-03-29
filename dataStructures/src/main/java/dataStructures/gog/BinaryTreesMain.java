package dataStructures.gog;

import dataStructures.gog.ds.trees.*;

//https://www.geeksforgeeks.org/threaded-binary-tree-insertion/
//
public class BinaryTreesMain {
	public static void main(String args[]) throws Exception  {
		// caller class for testing
		/*
		BinaryTree<Integer> bInt = new BinaryTree<Integer>();
		bInt.insert(20);
		bInt.insert(10);
		bInt.insert(30);
		bInt.insert(5);
		bInt.insert(16);
		bInt.insert(14);
		bInt.insert(17);
		bInt.insert(13);
		
		BinaryTree<Integer> bIntLambda = new BinaryTree<Integer>((a,b) -> a.compareTo(b));
		p.PrintUtil.println("Lambda Outputs");
		bIntLambda.insert(20);
		bIntLambda.insert(10);
		bIntLambda.insert(30);
		bIntLambda.insert(5);
		bIntLambda.insert(16);
		bIntLambda.insert(14);
		bIntLambda.insert(17);
		bIntLambda.insert(13);
		
		
		
		BinaryTree<Character> bCharT = new BinaryTree<Character>((a,b) -> a.compareTo(b));
		p.PrintUtil.println("Lambda Outputs");
		bCharT.insert('H');
		bCharT.insert('K');
		bCharT.insert('P');
		bCharT.insert('A');
		bCharT.insert('C');
		bCharT.insert('Z');
		bCharT.insert('G');
		bCharT.insert('h');*/
		
		BinarySearchTree_Array<Integer> bInt = new BinarySearchTree_Array<Integer>(8);
		bInt.insert(20);
		bInt.insert(10);
		bInt.insert(30);
		bInt.insert(5);
		bInt.insert(16);
		bInt.insert(14);
		bInt.insert(17);
		bInt.insert(13);
		p.o.println(bInt.inOrderTraversal());
		p.o.println(bInt.preOrderTraversal());
		p.o.println(bInt.postOrderTraversal());
		
		BinarySearchTree_Array<Integer> bIntLambda = new BinarySearchTree_Array<Integer>(8,(a,b) -> a.compareTo(b));
		p.o.println("Lambda Outputs");
		bIntLambda.insert(20);
		bIntLambda.insert(10);
		bIntLambda.insert(30);
		bIntLambda.insert(5);
		bIntLambda.insert(16);
		bIntLambda.insert(14);
		bIntLambda.insert(17);
		bIntLambda.insert(13);
		p.o.println(bIntLambda.inOrderTraversal());
		p.o.println(bIntLambda.preOrderTraversal());
		p.o.println(bIntLambda.postOrderTraversal());
		
		
		
		BinarySearchTree_Array<Character> bCharT = new BinarySearchTree_Array<Character>(8,(a,b) -> a.compareTo(b));
		p.o.println("Lambda Outputs");
		bCharT.insert('H');
		bCharT.insert('K');
		bCharT.insert('P');
		bCharT.insert('A');
		bCharT.insert('C');
		bCharT.insert('Z');
		bCharT.insert('G');
		bCharT.insert('h');
		
		
		p.o.println(bCharT.inOrderTraversal());
		p.o.println(bCharT.preOrderTraversal());
		p.o.println(bCharT.postOrderTraversal());
		
	}
}