package hersh.dsa.ds.implementations.hashing.abstracts;

import java.util.function.Function;

import hersh.dsa.ds.implementations.array.Array;
import hersh.dsa.ds.interfaces.AbstractDataStrutcureInterface;

public abstract class Hash<K,T> implements AbstractDataStrutcureInterface<T>{

	protected Array<T> hashLookUpArray;
	protected int initalSizeOfHashTable = 10;
	boolean autoSize = false;
	public Function<K, Integer> getHashLamba() {
		return hashLamba;
	}

	public void setHashLamba(Function<K, Integer> hashLamba) {
		this.hashLamba = hashLamba;
	}
	protected Function<K,Integer> hashLamba = (a) -> (a.hashCode());
	
	public Hash() {
		hashLookUpArray = new Array<T>(initalSizeOfHashTable);
		hashLookUpArray.setAutoSize(autoSize);
	}
	
	public Hash(int initalSize) {
		hashLookUpArray = new Array<T>(initalSizeOfHashTable);
		hashLookUpArray.setAutoSize(autoSize);
	}
	
	public Hash(int initalSize,Function<K, Integer> hashLamba) {
		this.hashLamba = hashLamba;
		this.initalSizeOfHashTable = initalSize;
		hashLookUpArray = new Array<T>(initalSizeOfHashTable);
		hashLookUpArray.setAutoSize(autoSize);
	}
	
	public abstract boolean put(K key,T info);
	public abstract T get(K key);
	public abstract AbstractDataStrutcureInterface<T> getEntry();
	public abstract AbstractDataStrutcureInterface<T> getKeys();

}
