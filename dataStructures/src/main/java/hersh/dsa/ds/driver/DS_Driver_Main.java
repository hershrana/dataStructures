package hersh.dsa.ds.driver;


import hersh.dsa.ds.implementations.lists.SinglyLinkedList;
import hersh.dsa.ds.interfaces.AbstractNode;

public class DS_Driver_Main {
	public static void main(String args[])
	{
		//Integer[] inputs = {10,30,20,15,2,9,66};
		//singlyLinkedList(inputs);
		int i =10;
		do
		{
		singlyLinkedList(i);
		if(i%250 == 0)
			System.gc();
		i+=100;
		}while(i<5000);
	}
	
	public static Object[] singlyLinkedList(int testWithArraySize)
	{
		p.o.whiteList();
		p.o.println("Creating and populating  list with array size "+testWithArraySize);
		int maxVal = testWithArraySize*21;
		Integer[] testInputs =  p.u.getRandomIntegerArray(testWithArraySize, maxVal);// {183 , 75 , 72 , 89 , 56 , 136 , 141 , 21 , 143 , 41 };// p.u.getRandomIntegerArray(testWithArraySize, testWithArraySize*20);
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		for(int counter = 0 ;counter <testInputs.length;counter++)
		{
			sll.insertAtTail(testInputs[counter]);
		}
		p.o.println(" single list created and traversing here "+sll.traverse());
		p.o.debugBreak();
		int testindex =p.u.getRandomIntegerMaxRange(testWithArraySize-1); // 4;// 
		int offerVal =p.u.getRandomIntegerMaxRange(maxVal);//64;//p.u.getRandomIntegerMaxRange(maxVal);
		sll.insertAfterValue(testInputs[testindex], offerVal);
		p.o.println(" single list after sll.insertAfterValue("+testInputs[testindex]+", "+offerVal+") -> "+sll.traverse());
		p.o.debugBreak();
		testindex = p.u.getRandomIntegerMaxRange(testWithArraySize-1);
		offerVal  = testInputs[testindex];// 41;//testInputs[testindex];
		sll.delete(offerVal);
		p.o.println(" single list after sll.delete("+offerVal+") -> "+sll.traverse());
		p.o.debugBreak();
		AbstractNode<Integer> node;
		do
		{
		testindex = p.u.getRandomIntegerMaxRange(testWithArraySize-1);
		offerVal  = testInputs[testindex];
		node = sll.search(offerVal);
		p.o.println(" searching node with info "+offerVal+" -> "+node);
		} while(node == null);
		
		sll.delete(node);
		p.o.println(" after removing node "+node+" -> "+sll);
		p.o.debugBreak();
		offerVal = p.u.getRandomIntegerMaxRange(maxVal);
		testindex = p.u.getRandomIntegerMaxRange(testWithArraySize-1);
		sll.update(testInputs[testindex], offerVal);
		p.o.println(" after sll.update("+testInputs[testindex]+", "+offerVal+")"+sll);
		p.o.debugBreak();
		
		offerVal = p.u.getRandomIntegerMaxRange(maxVal);
		sll.insertAtTail(offerVal);
		
		p.o.println(" sll.insert("+offerVal+")"+sll);
		p.o.debugBreak();
		return testInputs;
	}
	
	static void singlyLinkedList(Integer[] inputs)
	{
		p.o.whiteList();
		p.o.println("Creating and populating linked list");
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		for(int i : inputs)
			sll.insertAtTail(i);
		p.o.println(sll.traverse(null));
		
		sll.insertAfterValue(9, 256);
		p.o.println("After sll.insertAfterValue(9, 256) ->"+sll.traverse(null));
		
		int del = 20;
		sll.delete(del);
		p.o.println("After sll.delete("+del+"); ->"+sll.traverse(null));
		
	}
}
