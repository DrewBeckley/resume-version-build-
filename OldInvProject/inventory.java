import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.*;
public class inventory extends ConsoleProgram implements Runnable 
{	
	public final String[] Cammands={"Add", "Remove", "Entries","Entry","ammounts","ammount","all cammands","change","log","check","inv",};
	public String[] testing={"joe","bob","moe","john", "Drew","Tom"};


	public String[] mode={"logbook","IBD", "rec files"};
	//testing a object instead of two arrays
	public  ArrayList <Entries> entriesA=new ArrayList<Entries>();

	/*this was the oringinal being text based inventory with all classes combined.currently feels like a big ball of  mud. I could refactor towards imutablity/functional and pure functions. also start to Apply the soild where possible
	Started to refactor this with new skills on 6/6/21 
	refactor
		Goal 1: Look where I can use function/built in java functions
		Goal 2: Try hashMap<String,Double> to optimize/split int
		goal 3: use suppliers and consumer for smaller print syntax
		Optional: Look into immutablity/pure functions
	*/
	//was 330 some lines before 



//printing methods********************************************************************
//now it is the suppliers/consumers then use apply on the print consumer I had


	public Supplier<String> CammandsList=()->Arrays.stream(Cammands).collect(Collectors.joining(", ","The cammands are:\n",""));

	public Supplier<String> IBDcall1=()->"\n".repeat(10)+CammandsList.get();
	
	
	public Supplier<String> CurrentInventory=()->{
		var buffer=new StringBuffer();
		int size=entriesA.size();
		buffer.append(size+" items in the system\n");
		int i=0;
		for (Entries n:entriesA)
		{
			buffer.append(n+utilityPrint.flatline(19,"_")+Entries.amountsArray.get(i)+"\n");
			i++;
		}
		return buffer.toString();
	};
	
	
	
	//c and p template
	//public Supplier<String> undefined=()->

	private Consumer<String>print=(text)->System.out.println(text);

	public Supplier<String> TBD=()->"not implimented yet";
	
	public void run()
	{
		
		//from testing pre save system implemetion Just a list of names just for testing currently
		if(true)
		{
			
			int x=0;
			for(String n:testing)
			{
				addEntry(n,x,false); 
				x++;
			}
		}

		print.accept(CurrentInventory.get());
		//System.out.print(IBDcall1);
		while(true)
		{
			String ok=readLine("what do you want me to do: ");
			Checker(ok);
			print.accept(CurrentInventory.get());
		}
	}



	//TBD are not impelimented yep
	public void Checker(String tester)
	{
		
		//simplyfy with anymatch 
		boolean ismodeSwitch=Arrays.stream(mode).anyMatch(i->i.equals(tester));
		
		
		//trying to use pairs for a dynamicicly solution and avoid the switch hunt 
		//could shift printing out
		var  linkedActions=new HashMap<String, Supplier<String>>();
		
		
		linkedActions.put("IBD",IBDcall1);
		linkedActions.put("logbook",TBD);

		var x=linkedActions.containsKey(tester);
		//"invoke" the supplier 
		if(x){
			linkedActions.get(tester).get();
		}
		//System.out.println("is a mode switch: "+x);
		switch(tester)
		{
			case "IBD":
				//System.out.println("IBD popup");
				System.out.println(IBDcall1.get());
				break;
			case "logbook":
				System.out.println("add mode");
				break;
			default:
				break;
			
		};
		boolean isValid=Arrays.stream(Cammands)
		.map(String::toLowerCase)
		.anyMatch(i->i.equals(tester.toLowerCase()));
		//System.out.println(isValid);
		
		
		if(isValid)
		{
			//System.out.println(tester);//passed
			//System.out.println(data.Cammands[i]);//passed
			int i=Arrays.stream(Cammands)
			.map(String::toLowerCase) 
			.collect(Collectors.toList()).indexOf(tester.toLowerCase());
			//System.out.println(i);
			call(i,tester);
		}
	}
		
	

	

	//use the same trick  with hashmap
	
	
	
	//public static Function<Integer, > getAmount
	//try to use statagy or factory pattern, or use function 
	public void call(int printCode, String passedOn)
	{
		//System.out.println(printCode);
		switch(printCode) 
		{
			//"Add"0, "Remove"1, ("Entries","Entry")2,3,("ammounts","ammount")4,5,"all cammands"6
			case 0:
				addEntry(passedOn,true);
				//System.out.println("watch me add 1+5");
				break;
			case 1:
				removeEntry();
				//System.out.println("no remove on my watch");
				break;
			case 2:
			case 3:
				System.out.println("not impilmented yet");

				break;
			case 4:
			case 5:
				System.out.println("not impliment yet");
				break;
			case 6:
				//System.out.println("ok ok I will do it\njust let chetch my breath");
				System.out.println(cammands());

				break;
			case 7:
				System.out.println("no vaild cammand4");
				break;
			default:
				System.out.println("no cammand");
				break;
		};
	}

	
	
	
	

	

	
//add and remove method***************************************************************
	public void addEntry(String food,boolean report)
	{
		ConsoleProgram stat=new ConsoleProgram();
		String file=stat.readLine("name of the item: ");
		double in=stat.readDouble("set initial vaule: ");
		entriesA.add(new Entries(file,in));
		
		
		if(report){
			System.out.println("You added "+file+" and set it to "+in+".");
		}
	}
	
	
	
	
	public void addEntry(String name,double amount, boolean show)
	{
		entriesA.add(new Entries(name,amount));
		if(show){
			System.out.println("You added "+name+" and set it to "+amount+".");
		 }
	}

	
	
	
	
	
	
	public void removeEntry()
	{
		try
		{
			ConsoleProgram stat=new ConsoleProgram();
			String in=stat.readLine("what do you want to remove:");
			//System.out.println(entriesA);
			
			int i=Arrays.asList(Cammands).indexOf(in);
			entriesA.remove(i);
			
			System.out.println("You removed "+in+".");
			}
			
			catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("can't find entry to delete");
		}
	}
	
	

	
	
		
	
	
	/*
	//redo
	//public static String getEntries()//make anohter for
	{
	ConsoleProgram stat=new ConsoleProgram();
		String in=stat.readLine("what do you want to remove:");
		
		entriesA.remove(testFor(in,Entries.EntriesArray));
		System.out.println("You removed "+in+".");
	}
	*/
}
	
	