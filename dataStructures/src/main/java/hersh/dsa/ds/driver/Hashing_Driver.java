package hersh.dsa.ds.driver;

import hersh.dsa.ds.driver.hashingMisc.Person;
import hersh.dsa.ds.implementations.hashing.implementions.SimpleHashStructure;

public class Hashing_Driver {

	public static void main(String args[])
	{
		// SimpleHashTest();
		 SimpleHashTestInt();
	}
	
	public static void SimpleHashTest()
	{
		p.o.whiteList();
		SimpleHashStructure<String, Person>  test = new SimpleHashStructure<String, Person>(52 , (a) -> Character.valueOf(a.charAt(0)).hashCode()%52); 
		p.o.whiteList(test.getClass());
		Person startA= new Person("Adhya", "Rana", 2.1d);
		test.put(startA.getFirstName(), startA);
		test.put("Hersh", new Person("Hersh", "Rana", 32.9d));
		test.put("Purvi", new Person("Purvi", "Rana", 28d));
		p.o.println(test.get("Adhya"));
		p.o.println(test.get("hersh"));
		p.o.println(test.get("Hersh"));
		test.put("Hersh", new Person("Hersh", "Rana2", 32.9d));
		p.o.println(test.get("Hersh"));
		p.o.println(test.get("Purvi"));
		p.o.println(test);
	}
	
	public static void SimpleHashTestInt()
	{
		p.o.whiteList();
		Integer[] key = p.u.getRandomIntegerArray(1000, 1000);
		Integer[] values = p.u.getRandomIntegerArray(1000, 1000);
		SimpleHashStructure<Integer, Integer>  test = new SimpleHashStructure<Integer, Integer>(key.length/2 , (a) -> a.hashCode()%(key.length/2)); 
		p.o.whiteList(test.getClass());
		for(int i = 0 ; i <key.length ; i++ )
			test.put(key[i], values[i]);
		p.o.println(test);
	}
}
