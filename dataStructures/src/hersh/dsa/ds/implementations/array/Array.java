package hersh.dsa.ds.implementations.array;

import hersh.dsa.ds.driver.Array_Driver;
import hersh.dsa.ds.implementations.lists.nodes.Index;

public class Array<T> {
	int currentSize=25;
	int elementesAdded = 0;
	double loadFactor = 0.9;
	double autoSizeMultiplier = 2;
	public double getLoadFactor() {
		return loadFactor;
	}
	public void setLoadFactor(double loadFactor) {
		this.loadFactor = loadFactor;
	}
	public boolean isAutoSize() {
		return autoSize;
	}
	public void setAutoSize(boolean autoSize) {
		this.autoSize = autoSize;
	}
	boolean autoSize = true;
	Index autoAdd = Index.init(0, 0, Integer.MAX_VALUE);
	T[] array;
	public Array() {
		array = (T[]) new Object[currentSize];
	}
	public Array(int intitalSize) {
		currentSize = intitalSize;
		array = (T[]) new Object[currentSize];
	}
	public Index getIndex(Integer inx) throws Exception
	{
		return new Index(inx, 0, currentSize);
	}
	public Index autoIndex() throws Exception
	{
		int count = 0;
		for (count =0 ;count < array.length ; count++)
		{
			if(array[count] == null)
				break;
		}
		return new Index(count, 0, currentSize);
	}
	public boolean setElementAsNull(Index index)
	{
		array[index.getValue()] = null;
		return true;
	}
	public boolean setElement(Index index,T value )
	{
		array[index.getValue()] = value;
		if(value != null)
			elementesAdded++;
		if(autoSize && (Double.valueOf((elementesAdded/currentSize)+"") > Double.valueOf(loadFactor)))
			restructure();
		return true;
	}
	
	public T getElement(Index index)
	{
		return array[index.getValue()];
	}
	
	public void restructure()
	{
		int filled = 0;
		for(T i : array)
		{
			if(i != null) filled++;
		}
		double currentLoadFactor =  (double)filled/ (double)array.length;
		p.o.println(" Load factor is "+currentLoadFactor);
		//p.o.debugBreak();
		if(currentLoadFactor >= getLoadFactor())
		{
			
			int newSize = ((int) (currentSize*autoSizeMultiplier))+1;
			p.o.println(" Restructing array from "+currentSize+" to "+newSize);
			T[] newArry = (T[]) new Object[newSize];
			for(int count  = 0 ; count <currentSize;count++)
				newArry[count] = array[count];
			currentSize = newSize;
			array = newArry;
			System.gc();
			p.o.println("Completed....");
			p.o.debugBreak();
		}
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer("[");
		for(T c  : array)
		{
			sb.append(c+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	public T[] getArray() {
		return array;
	}
	public void setArray(T[] array) {
		this.array = array;
	}
	
	public Index autoAdd(T info)
	{
		setElement(autoAdd.autoIncrement(), info);
		return autoAdd;
	}
	public static void main(String args[]) {
		p.o.whiteList();
		Array_Driver.arrayTest(1000);
	}
}
