import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.concurrent.*;
//import java.util.stream.*;
import OldInvProject.*;


class Main 
{
	

	
	public static void main(String[] args) 
	{
		
		
		//this starts the gui
		Thread app= new Thread(new startup());
		
		//this thread is for my old text that i moved to a OldInvProject.
		Thread oldInv= new Thread(new inventory());
		
		
		//System.out.println(
			Thread.currentThread().setPriority(10);
			//);
		//System.out.println(Thread.currentThread().getName());
		
		
		boolean doExperiments=false;
		
		if(doExperiments)
		{
			Main bro = new Main();
			bro.experimentalzone();
		}
		
		
		
		
		//starting program
		
		
		
		//app.start();
		
		
		
		oldInv.start();
		
		
		throw new RuntimeException("All good,This is stop the main thread from any data race condion");
		//System.out.println(Thread.currentThread().getName());
		//try{
			//Thread.sleep(10000000);
			//}catch(Exception e){};

		
	}

	//experimental zone where I test stuff.
	//@Supress
	public void experimentalzone()
	{
		var tester=new test();
		var FTest=new FileGui();
		//var save=new SaveSystem("saveData/test.txt");
		
		String[] head={"test","test2"};
		String[] div={", ",", "};
		List<String>list=List.of("sdfs","sccc","sssvvs");
		try{
			//tester.Savetast();
			//tester.printTest();
			//tester.Completabletest();
			//FTest.load_Entry();
			//save.load_Test(head,div);
			//save.singleSave("Test",list);
			//save.singleSave("Test",list);
			//System.out.println(save.getPath());
			//tester.tStDlist();

			
		}catch(Exception ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
		
		System.out.println("all done with experiment");	
	
		
	}
	
}