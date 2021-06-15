import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.*;
//import java.util.stream.Collectors.*;
//import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.function.Consumer;



//import 

//save and this one will be a universal save systemthat canbe adaptdt to many th
public class SaveSystem//throws
{
	//String[] topLabel={"test","test1","test2"};
	//String[] bottomLabel={"bottom","bottom1","bottom2"};
	private final String path;
	private BufferedWriter buffer;
	//private BufferedReader test;
	private final String divider=", ";
	private boolean isFirstWrite;
	//constructor

	public SaveSystem(String path) //throws IOException
	{
		this.path=path;
		try{
			//buffer = new BufferedWriter(new FileWriter(path));
		}catch(Exception ex){
			System.out.print(ex+"in construor");
		}
	}
	public String getPath()
	{
		return path;
	}
	




	
	//could have this done async
	public void Completabletest() throws Exception
	{
		//CompletableFuture example
		CompletableFuture<String>cF = new CompletableFuture<String>();
		cF.thenApply(data->data+" it changed").thenAccept(data->System.out.println(data));
		cF.complete("hi");
		//CompletableFuture<String> future =CompletableFuture.supplyAsync(()->printAsync(ty));
		//create(); 
		//System.out.println("first is done"); 
		//Stream.iterate(0,i->i+1).limit(10).forEach(i->System.out.println("hello world "+i));
		//System.out.println(finaloutput.get());
	}
	


	//loading
	public HashMap<Integer,String[]> load_Test(String[] headers,String[] divider)
	{
		try{
			var test=new BufferedReader(new FileReader(path));
			List<StringBuffer> SBuffer=new ArrayList<StringBuffer>();
			for(var h:headers)
			{
				SBuffer.add(new StringBuffer());
			}
			int i=0;
			String num="";
			while((num=test.readLine())!=null)
			{
				//String tester=test.readLine();System.out.println(num);
				if(num.endsWith(":"))
				{
					num=test.readLine();
					SBuffer.get(i).append(num);
					i++;


				}
			}
			i=0;
			HashMap<Integer,String[]> output=new HashMap<Integer,String[]>();
			for(var s:SBuffer)
			{
				String[] temp=SBuffer.get(i).toString().split(divider[i]);
				output.put(i,temp);
				i++;
			}
			//output.forEach((z,j)->System.out.print("{"+z+"="+Arrays.stream(j).collect(Collectors.joining(", ","{","}"))+"},"));
			test.close();
			//System.out.println("A ok: "+SBuffer.get(1));
			return output;
		}catch(Exception ex){
			System.out.println(ex+" in univeral reader");
			
			throw new RuntimeException("loading had an error");
		}finally{
			//x
		}
	}


	public static String[] getStringArray(HashMap<Integer,String[]> fullmap,int index)
	{
		return fullmap.get(new Integer(index));
	}
///*
	public static ArrayList<String> getStringAL(HashMap<Integer,String[]> fullmap,int index)
	{
		//if(fullmap!=null)
		{
			return new ArrayList<String>(
			Arrays.asList(fullmap.get(new Integer(index)))
		);
		}
		
		//return out;
		//ArrayList<String>out=new ArrayList<String>(Arrays.asList(name));

	}

//*/
}
/*name=SaveSystem.getStringArray(out,1);
		listOfRecipeList=
		var content=SaveSystem.getStringArray(out,2);
		listOfContentList.addAll(Arrays.asList(content));*/
	





















/*depricated
	//Two.stream().forEach(System.out::println);
			var x=Two.stream().collect(Collectors.joining(", ","{","}"));
			//.forEach(
			System.out.println(x);
			//var xya=Two.stream().concat(", ");
			//.toString();
			//collect(Collectors.toCollection(() -> new ArrayList<Person>()));
			buffer.newLine();
			buffer.append("Content list:");
			buffer.newLine();
			
			int i=0;
			for(String n:Two)
			{
				buffer.write(Two.get(i)+"<<end>>");
				i++;
			}
			//String bi=two
			//*/
