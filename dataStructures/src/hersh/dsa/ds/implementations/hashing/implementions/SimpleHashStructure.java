package hersh.dsa.ds.implementations.hashing.implementions;

import java.util.function.Function;

import hersh.dsa.ds.driver.Hashing_Driver;
import hersh.dsa.ds.implementations.hashing.abstracts.Hash;
import hersh.dsa.ds.interfaces.AbstractDataStrutcureInterface;

public class SimpleHashStructure<K, T> extends Hash<K, T> {

	
	public SimpleHashStructure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimpleHashStructure(int initalSize) {
		super(initalSize);
		// TODO Auto-generated constructor stub
	}

	public SimpleHashStructure(int initalSize, Function<K, Integer> hashLamba) {
		super(initalSize, hashLamba);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean put(K key, T info) {
		try
		{
		hashLookUpArray.setElement(hashLookUpArray.getIndex(getHashLamba().apply(key)), info);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public T get(K key) {
		try
		{
		return hashLookUpArray.getElement(hashLookUpArray.getIndex(hashLamba.apply(key)));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AbstractDataStrutcureInterface<T> getEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractDataStrutcureInterface<T> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main (String args[])
	{
		Hashing_Driver.SimpleHashTest();
	}

}
