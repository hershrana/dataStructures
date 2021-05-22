package hersh.dsa.ds.implementations.hashing.implementions;

import hersh.dsa.ds.implementations.hashing.abstracts.Hash;
import hersh.dsa.ds.implementations.lists.nodes.Index;
import hersh.dsa.ds.interfaces.AbstractDataStrutcureInterface;

public class Hash_OpenAddress<K,T> extends Hash<K, T>  {

	int addToNextIndex = 1;
	public Index getValidIndexFrom(Index index)
	{
		while(! hashLookUpArray.isEmpty(index))
		{
			index.inccrementBy(addToNextIndex);
		}
		if(hashLookUpArray.restructureRequired(index))
			hashLookUpArray.forceRestructure();
		return index;
	}
	@Override
	public boolean put(K key, T info) {
		try {
			Index proIndex = hashLookUpArray.getIndex(hashLamba.apply(key));
			proIndex = getValidIndexFrom(proIndex);
			hashLookUpArray.setElement(proIndex, info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public T get(K key) {
		// TODO Auto-generated method stub
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

}