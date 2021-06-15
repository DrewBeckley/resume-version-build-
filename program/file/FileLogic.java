//import javax.swing.*;
//import java.awt.*;
import java.util.*;
import java.io.*;
//import java.awt.event.*;
import java.util.stream.*;
public class FileLogic
{
	//this could be refactored out if not extra logic is needed here
	public String save(String entered)
	{
		return entered;
	}

	//save 
	//last refactoring 5/25/21 
	//added stringbuffer
	String fLocation="saveData/Data.txt";
	//String fLocation="Data.txt";
	public  void save(ArrayList<String>listOfContentList,ArrayList<String> listOfRecipeList)
	{
		try{
			BufferedWriter buffer = new BufferedWriter(new FileWriter(fLocation));
			String 
			
			names=listOfRecipeList.stream().collect(Collectors.joining(", "));
			String
			pre_edited=listOfContentList.stream().collect(Collectors.joining("<<end>>"));
			var edited=pre_edited.replace("\n","/n");
		
			
			StringBuffer test=new StringBuffer()
			.append("file name:\n"+names)
			
			.append("\nContent List:\n"+edited+"<<end>>");
			
			//System.out.println(listOfRecipeList);
			//System.out.println(listOfRecipeList+"and content is "+listOfContentList);
			buffer.write(test.toString());
			//closing writer
			buffer.close();
		}catch(Exception ex){
			System.out.println("Error in save");
			System.out.println(ex);
		}finally{
			System.out.println("done reading");
		};
		
	}
	
	
	private String[] head={"file name:","Content List:"};
	private String[] div={", ","<<end>>"};
	



	//load
	public HashMap<Integer,String[]> load()
	{
		var x=new SaveSystem(fLocation);
		var out=x.load_Test(head,div);
		return out;

	}

	//util method
	public static ArrayList<String> getStringAL(HashMap<Integer,String[]> fullmap,int index)
	{
		//System.out.println(fullmap.toString());
		//fullmap.forEach((i,j)->System.out.println(i+": "+Stream.of(j).collect(Collectors.joining(", "))));
		 return new ArrayList<String>(Arrays.asList(fullmap.get(new Integer(index)))
		);
	}

	public String getEditModeText(boolean editable,String name)
	{
		String doing=(editable) ? "editing" : "viewing";
		return "You are editing "+doing+": "+name;
		
	}
	
	

}
/*
String t="";
				
//.replaceAll("\n", "\n");
//char test
char[] te=in.toCharArray();
for(char n:te)
{	
	String con="";
	if(n=='\n')
	{
		System.out.println(n+" yep theres a new line");
		con="/n";
	}
	else
	{
		System.out.println(n);
		con=Character.toString(n);
	}
	t=t+con;
}
*/