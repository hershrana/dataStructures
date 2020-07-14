package dataStructures.gog;

import dataStructures.gog.ds.trees.*;

//https://www.geeksforgeeks.org/threaded-binary-tree-insertion/
//
public class BinaryTreesMain {
	public static void main(String args[]) throws Exception  {
		// caller class for testing
		
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
		System.out.println("Lambda Outputs");
		bIntLambda.insert(20);
		bIntLambda.insert(10);
		bIntLambda.insert(30);
		bIntLambda.insert(5);
		bIntLambda.insert(16);
		bIntLambda.insert(14);
		bIntLambda.insert(17);
		bIntLambda.insert(13);
		
		
		
		BinaryTree<Character> bCharT = new BinaryTree<Character>((a,b) -> a.compareTo(b));
		System.out.println("Lambda Outputs");
		bCharT.insert('H');
		bCharT.insert('K');
		bCharT.insert('P');
		bCharT.insert('A');
		bCharT.insert('C');
		bCharT.insert('Z');
		bCharT.insert('G');
		bCharT.insert('h');
	}
}