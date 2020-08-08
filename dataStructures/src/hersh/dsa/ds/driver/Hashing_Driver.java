package hersh.dsa.ds.driver;

import hersh.dsa.ds.driver.hashingMisc.Person;
import hersh.dsa.ds.implementations.hashing.implementions.SimpleHashStructure;

public class Hashing_Driver {

	public static void main(String args[])
	{
		 SimpleHashTest();
	}
	
	public static void SimpleHashTest()
	{
		p.o.whiteList();
		SimpleHashStructure<String, Person>  test = new SimpleHashStructure<String, Person>(24 , (a) -> Character.valueOf(a.charAt(0)).hashCode()%24); 
		Person startA= new Person("Adhya", "Rana", 2.1d);
		test.put(startA.getFirstName(), startA);
		p.o.println(test.get("Adhya"));
	}
}
