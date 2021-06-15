import program.*;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.concurrent.*;
import java.io.*;
public class test extends TestData
{
	//for my new savesystem class
	// public void Savetast() throws IOException
	// {
	// 	//test data
	// 	var bi=converttoAL(super.argST);
		
	// 	//var bi=new ArrayList<Byte>();
	// 	//bi.addAll(Arrays.asList(arg
	// 	//));
	// 	var save=new SaveSystem("Hi.txt");
	// 	//save.save(bi,bi);
	// 	save.singleSave("test",bi);
	// 	save.singleSave("test2",bi);
	// 	save.doneSaveing();
	// 	//var get=new SaveRetrivial("Hi.txt",arg);
	// 	//get.read();
	// 	//get.doneSaveing();
	// 	//*/
	// }
	//print any number type or
	public void printTest()
	{
		//test data
		var bi=converttoAL(super.argST);
		
		
		//tesing the iterator in stream api 
		//var itter=Stream.iterate(97,i->i+1).limit(26).collect(Collectors.toList());
		
		
		//converting numbers list/array to ascii Character
		//System.out.print(
		//bi.stream().map(Character::toString).collect(Collectors.joining("<-> "))+"\n");
		
		
		
		//passed and can go into use
		//testing multi type printing with wrapers,mainly Integer,Double
		String post=bi.stream()
		.map(Object::toString)
		.collect(Collectors.joining(", "));
		
		
		System.out.println(post);
		//this is to mixed Double/Stings in jtables
		var post1=bi.stream()
		.map(Object::toString)
		.collect(Collectors.toList());
		
		
		System.out.print(post1);
		
		/*
		Iterator<String> ind1=bi.iterator();
		forEach((i)->{
			String ind=ind1.next();
			System.out.print(" is "+ind+"do do do"+", ");});
		
		//*/
	}






	//CompletableFuture
	public void Completabletest() throws Exception
	{
		//CompletableFuture
		CompletableFuture<String>cF = new CompletableFuture<String>();
		String ty="hi";
		//CompletableFuture<String> future =CompletableFuture.supplyAsync(()->printAsync(ty));
		//create(); 
		//System.out.println("first is done"); 
		cF.thenApply(data->data+" it changed").thenAccept(data->System.out.println(data));
		cF.complete("hi ");
		//Stream.iterate(0,i->i+1).limit(10).forEach(i->System.out.println("hello world "+i));
		//System.out.println(finaloutput.get());
	}
	
	public String printAsync(String x)
	{
			//could be a gitting some database or longer procedure
			//see what thread is running
			//System.out.println(Thread.currentThread().getPriority());
			//System.out.println(Thread.currentThread().getName());
			System.out.println("look mom I am printing async");
			try{
			Random rand = new Random();
			Stream.iterate(0,i->i+rand.nextInt(10000)
			).limit(10).forEach(i->{
				System.out.println(i);
				try{Thread.currentThread().sleep(10);}catch(Exception e){}
			});
			return "look ma I can do two things at once"; 
		}catch(Exception e){
			System.out.print(e);}
		return "";
	}
	//converting String to Double
	public void tStDlist()
	{
		var test=converttoAL(argST);
		var out=test.stream().map(Double::parseDouble).collect(Collectors.toList());
		System.out.println(out.getClass());
		System.out.println(out);
	}
	
	
	
}
/*
		/*
				switch(num)
				{
				case "file name:":
					num=test.readLine();
					String sub=num.substring(1,num.length()-1);
					//System.out.println(sub);
					temp=sub.split(", ");
					listOfRecipeList.clear();
					int i=0;
					for(String n: temp)
					{
						//if(!listOfRecipeList.get(i).equals(""))
						//{
							listOfRecipeList.add(n);
						//}
						//else
						//{
							//System.out.println(listOfRecipeList.get(i)+'x');
							//listOfRecipeList.add(n);
						//}
						i++;
					}
					break;
				case "Content list:":
					num=test.readLine().replaceAll("/n","\n");
					String consub=num.substring(0,num.length()-7);
					//System.out.println(consub);
					temp=consub.split("<<end>>");
					listOfContentList.clear();
					for(String n: temp)
					{
						listOfContentList.add(n);
					}
					break;
				};
			}
			test.close();
			System.out.println("done reading file mem");
		}
		catch(Exception ex)
		{
			//bringUp();
			System.out.println(ex+"in univeral");
			
		}*/
