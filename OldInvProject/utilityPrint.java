public class utilityPrint
{
	//move to new util class
	public static void newPage(int lines)
	{
		var skips=("\n").repeat(lines);
		System.out.println(skips);
	}

	
	public static String flatline(int length, String line)
	{
		String repeatVersion=line.repeat(length);
		return repeatVersion;

	}
}