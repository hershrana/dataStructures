package hersh.dsa.ds.implementations.lists.nodes;

public class Index {
	protected Integer i = 0;
	int max = Integer.MAX_VALUE;
	int min  = 0;//Integer.MIN_VALUE
	public Index(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	public Index(Integer i, Integer min , Integer  max) throws Exception {
		super();
		if(max !=null)
			this.max = max;
		if (min!=null)
			this.min = min;
		if(isInBounds(i))
			this.i = i;
		else
			throw new Exception("Unsafe index value = "+i+" should be between "+min+" and "+max);
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) throws Exception {
		this.max = max;
		if(! isInBounds())
			throw new Exception("Unsafe index value = "+i+" should be between "+min+" and "+max);
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) throws Exception {
		this.min = min;
		if(! isInBounds())
			throw new Exception("Unsafe index value = "+i+" should be between "+min+" and "+max);
	}
	public Index(int i2) {
		i =i2;
	}
	public static Index init(int i)
	{
		return new Index(i);
	}
	public static Index init(int i,int min,int max)
	{
		try
		{
		return new Index(i,min,max);
		}
		catch(Exception r)
		{
			r.printStackTrace();
		}
		return null;
	}
	public Integer getValue()
	{
		return i;
	}
	public boolean isInBounds()
	{
		return isInBounds(i);
	}
	public boolean isInBounds(int index)
	{
		return index >= min && index <= max;
	}
	public  Index autoIncrement()
	{
		try
		{
		return new Index(i++, min ,max);
		}
		catch(Exception r)
		{
			r.printStackTrace();
		}
		return null;
	}
}
