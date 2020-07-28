package dataStructures.gog.searching;
public interface Search<T> {
	public int search(T searchFor, T[] input);
	public Object searchAndReturn(T searchFor, T[] input);
}
