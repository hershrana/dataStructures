package Util;


import java.util.HashSet;


public class  PrintUtil {
	static HashSet<String> whitelisted = new HashSet<String>();
	static HashSet<String> warned = new HashSet<String>();
	static HashSet<String> blacklisted = new HashSet<String>();
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
	public  static void println(String s)
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
	public  static void println(StringBuffer s)
	{
		String callingClass = Thread.currentThread().getStackTrace()[2].getClassName() ;
		if(  whitelisted.contains( callingClass) && !blacklisted.contains(callingClass))
		{
			System.out.println(s);
			return;
		}
		if ( ! warned.contains(callingClass))
		{
			if(blacklisted.contains(callingClass))
			{
				System.out.println("##ERROR## Blacklisted "+callingClass);
			}
			else
			{
			}
		}
		
	}
	
	
	public  static void println(Object s)
	{
		String callingClass = Thread.currentThread().getStackTrace()[2].getClassName() ;
		if(  whitelisted.contains( callingClass) && !blacklisted.contains(callingClass))
		{
			System.out.println(s.toString());
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
	
	
	
	public  static void print(Object s)
	{
		String callingClass = Thread.currentThread().getStackTrace()[2].getClassName() ;
		if(  whitelisted.contains( callingClass) && !blacklisted.contains(callingClass))
		{
			System.out.println(s.toString());
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
