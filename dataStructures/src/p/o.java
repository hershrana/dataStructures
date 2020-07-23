package p;


import java.util.HashSet;


public class  o {
	static HashSet<String> whitelisted = new HashSet<String>();
	static HashSet<String> warned = new HashSet<String>();
	static HashSet<String> blacklisted = new HashSet<String>();
	public final static int forceAllPrint = 1;
	public final static int forceAllStop = 0;
	public final static int controlledPrint = 2;
	public static int currentMode = controlledPrint;
	public static int getCurrentMode() {
		return currentMode;
	}
	public static void setCurrentMode(int currentMode) {
		o.currentMode = currentMode;
	}
	//	static boolean init = false;
//	 static void initalized ()
//	{
//		whitelisted.add(Thread.currentThread().getStackTrace()[1].getClassName());
//		whitelisted.add(new PrintUtil().getClass().getName());
//		//whitelisted.add(new ShellSort_Main().getClass().getName());
//		init = true;
//	}
	public  static void whiteList()
	 {
		 whitelisted.add(Thread.currentThread().getStackTrace()[2].getClassName()); 
	 }
	 public static void deWhiteList()
	 {
		 whitelisted.remove(Thread.currentThread().getStackTrace()[2].getClassName()); 
	 }
	 
		public  static void blackList()
		 {
			 blacklisted.add(Thread.currentThread().getStackTrace()[2].getClassName()); 
		 }
		 public static void deBlackList()
		 {
			 blacklisted.remove(Thread.currentThread().getStackTrace()[2].getClassName()); 
		 }
//	public  static void println(String s)
//	{
//		if(currentMode == forceAllStop)
//			return;
//		if(currentMode == forceAllPrint)
//			System.out.println(s);
//		if(currentMode == controlledPrint)
//		{
//		String callingClass = Thread.currentThread().getStackTrace()[2].getClassName() ;
//		if(  whitelisted.contains( callingClass) && !blacklisted.contains(callingClass))
//		{
//			System.out.println(s);
//			return;
//		}
//		if ( ! warned.contains(callingClass))
//		{
//			warned.add(callingClass);
//			if(blacklisted.contains(callingClass))
//			{
//				System.out.println("##ERROR## Blacklisted "+callingClass);
//			}
//			else
//			{
//			System.out.println("##WARN## WhiteList "+callingClass);
//			}
//		}
//		}
//	}
//	public  static void println(StringBuffer s)
//	{
//		if(currentMode == forceAllStop)
//			return;
//		if(currentMode == forceAllPrint)
//			System.out.println(s);
//		if(currentMode == controlledPrint)
//		{
//		String callingClass = Thread.currentThread().getStackTrace()[2].getClassName() ;
//		if(  whitelisted.contains( callingClass) && !blacklisted.contains(callingClass))
//		{
//			System.out.println(s);
//			return;
//		}
//		if ( ! warned.contains(callingClass))
//		{
//			warned.add(callingClass);
//			if(blacklisted.contains(callingClass))
//			{
//				System.out.println("##ERROR## Blacklisted "+callingClass);
//			}
//			else
//			{
//			System.out.println("##WARN## WhiteList "+callingClass);
//			}
//		}
//		}
//		
//	}
	
	
	public  static void println(Object s)
	{
		if(currentMode == forceAllStop)
			return;
		if(currentMode == forceAllPrint)
			System.out.println(s);
		if(currentMode == controlledPrint)
		{
		String callingClass = Thread.currentThread().getStackTrace()[2].getClassName() ;
		if(  whitelisted.contains( callingClass) && !blacklisted.contains(callingClass))
		{
			System.out.println(s);
			return;
		}
		if ( ! warned.contains(callingClass))
		{
			warned.add(callingClass);
			if(blacklisted.contains(callingClass))
			{
				System.out.println("##ERROR## Blacklisted "+callingClass);
			}
			else
			{
			System.out.println("##WARN## WhiteList "+callingClass);
			}
		}
		}
	}
	
	
	
	public  static void print(Object s)
	{
		if(currentMode == forceAllStop)
			return;
		if(currentMode == forceAllPrint)
			System.out.print(s);
		if(currentMode == controlledPrint)
		{
		String callingClass = Thread.currentThread().getStackTrace()[2].getClassName() ;
		if(  whitelisted.contains( callingClass) && !blacklisted.contains(callingClass))
		{
			System.out.print(s);
			return;
		}
		if ( ! warned.contains(callingClass))
		{
			warned.add(callingClass);
			if(blacklisted.contains(callingClass))
			{
				System.out.println("##ERROR## Blacklisted "+callingClass);
			}
			else
			{
			System.out.println("##WARN## WhiteList "+callingClass);
			}
		}
		}
	}
}
